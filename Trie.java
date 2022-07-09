package Contacts;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private static Node root;
	private static HashMap<String,ArrayList<Integer>> storage;
	// Creating root node to initialize Trie 
	public Trie() {
		this.root = new Node();
		this.storage = new HashMap<>();
	}
	
	// Inserting contact in our Phone Book
	public static void insertContact(String contact, int number) {
		Node pointer = root;
		for(int i = 0; i < contact.length(); i++) {
			if(!pointer.containsChar(contact.charAt(i))) {
				pointer.put(contact.charAt(i), new Node());
			}
			pointer = pointer.get(contact.charAt(i));
			pointer.addPrefix();
		}
		pointer.endsHere();
		if(!storage.containsKey(contact)) {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(number);
			storage.put(contact, al);
		}
		else {
			ArrayList<Integer> al = storage.get(contact);
			al.add(number);
		}
	}
	
	// Checking if contact exists in our Phone Book
	public static boolean searchFor(String contact) {
		Node pointer = root;
		for(int i = 0; i < contact.length(); i++) {
			if(pointer.containsChar(contact.charAt(i))) {
				pointer = pointer.get(contact.charAt(i));
			}
			else return false;
		}
		if (pointer.noOfEnd > 0) return true;
		return false;
	}
	// Alternatively we can use hashmap to check existing contacts in O(1)
	
	// Checking how many contacts with given name are present in our Phone Book
	public static int checkNo(String contact) {
		Node ptr = root;
		for(int i = 0; i < contact.length(); i++) {
			if(ptr.containsChar(contact.charAt(i))) {
				ptr = ptr.get(contact.charAt(i));
			}
			else {
				return 0;
			}
		}
		return ptr.noOfEnd;
	}
	
	// Checking how many contacts with given prefix are present in our Phone Book
		public static int checkPrefix(String contact) {
			Node ptr = root;
			for(int i = 0; i < contact.length(); i++) {
				if(ptr.containsChar(contact.charAt(i))) {
					ptr = ptr.get(contact.charAt(i));
				}
				else {
					return 0;
				}
			}
			return ptr.noOfPrefix;
		}
	
	// Deleting an existing contact
	public static void delContact(String contact) {
		Node node = root;
		for(int i = 0; i < contact.length(); i++) {
			if(node.containsChar(contact.charAt(i))) {
				node = node.get(contact.charAt(i));
				node.delPrefix();
			}
			else {
				return;
			}
		}
		node.delEnd();
	}
	
	// Display all contacts with given prefix
	public static ArrayList<String> contactsWithPrefix(String prefix) {
		ArrayList<String> list = new ArrayList<>();
		Node ptr = root;
		for(int i = 0; i < prefix.length(); i++) {
			if(ptr.containsChar(prefix.charAt(i))) {
				ptr = ptr.get(prefix.charAt(i));
			}
			else {
				return list;
			}
		}
		contactsWithPrefixHelper(list, prefix, ptr);
		return list;
	}	
	
	// Helper function for getting contacts with a given prefix
	private static void contactsWithPrefixHelper(ArrayList<String> al, String soFar, Node ptr) {
		if(ptr.noOfEnd > 0) {
			for(int i = 0; i < ptr.noOfEnd; i++) {
				al.add(soFar);
			}
		}
		for(int i = 0; i < 91; i++) {
			if(ptr.links[i] != null) {
				contactsWithPrefixHelper(al, soFar + Character.toString(' '+i), ptr.links[i]);
			}
		}
		return;
	}
	
	// Print all contact names
	static void displayAllContacts() {
		ArrayList<String> al = contactsWithPrefix("");
		if(al.size() == 0) {
			System.out.println("No contacts exist");
			return;
		}
		System.out.println("Your contacts:");
		for(int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	// Getting all numbers under an existing name
	static ArrayList<Integer> getNumbers(String name) {
		return storage.get(name);
	}

	// Remove entry of contact from storage
	public static void delName(String name, int no) {
		if(no == 0) {
			storage.remove(name);
			return;
		}
		storage.get(name).remove(no-1);
	}
}
	
	