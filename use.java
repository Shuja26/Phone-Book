package Contacts;

import java.util.*;

public class use {
	public static void main(String args[]) {
		//Add contacts
		Trie phoneBook = new Trie();
		Scanner sc = new Scanner(System.in);
		boolean Exit = false;
		String name = "";
		while(!Exit) {
			System.out.println("/====================================================================================================/");
			System.out.println("Select an option :");
			System.out.println("\tEnter 1 to: Insert a contact in your phonebook");
			System.out.println("\tEnter 2 to: Check if a contact is already present in your phonebook.");
			System.out.println("\tEnter 3 to: Check how many contact numbers are stored under a given name.");
			System.out.println("\tEnter 4 to: Check how many contacts with a given prefix are present");
			System.out.println("\tEnter 5 to: Delete an existing contact");
			System.out.println("\tEnter 6 to: Display all contacts with a given prefix");
			System.out.println("\tEnter 7 to: Display all names in your Phonebook");
			System.out.println("\tEnter 8 to: Get all numbers under an existing name");
			System.out.println("\tOr enter any other number to exit");
			System.out.println("/====================================================================================================/");
			int action = sc.nextInt();
			switch(action) {
			case 1:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter contact number:");
				int number = sc.nextInt();
				phoneBook.insertContact(name, number);
				System.out.println("Contact entered in Phone Book");
				System.out.println();
				break;
			case 2:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				if(phoneBook.searchFor(name)) {
					System.out.println("Conatact '" + name + "' exists in your phone book and has the following number(s)");
					ArrayList<Integer> al = phoneBook.getNumbers(name);
					int n = al.size();
					for(int i = 0; i < n; i++) {
						System.out.println(al.get(i));
					}
				}
				else {
					System.out.println("Contact not found");
				}
				break;
			case 3:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				System.out.println(phoneBook.checkNo(name) + " contacts are stored under the name '" + name + "'");
				break;
			case 4:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				System.out.println(phoneBook.checkPrefix(name) + " contacts having '" + name + "' as prefix are present");
				break;
			case 5:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				int n = phoneBook.checkNo(name);
				if(n == 0) {
					System.out.println("No such contact exists");
					break;
				}
				if(n == 1) {
					System.out.println("Contact deleted successfully");
					phoneBook.delName(name, 0);
					phoneBook.delContact(name);
					break;
				}
				System.out.println("The numbers under the name " + name + " are:");
				ArrayList<Integer> al = phoneBook.getNumbers(name);
				for(int i = 0; i < al.size(); i++) {
					System.out.println((i+1) + " " + al.get(i));
				}
				System.out.println("Select the serial number of the contact to be deleted");
				n = sc.nextInt();
				phoneBook.delName(name, n);
				phoneBook.delContact(name);
				System.out.println("Contact deleted successfully");
				break;
			case 6:
				System.out.println("Enter contact name:");
				name = sc.nextLine();
				name = sc.nextLine();
				ArrayList<String> al1 = phoneBook.contactsWithPrefix(name);
				if(al1.size() == 0) {
					System.out.println("No contacts with " + name + " as prefix exists");
					break;
				}
				System.out.println("Search results:");
				for(int i = 0; i < al1.size(); i++) {
					System.out.println(al1.get(i));
				}
				break;
			case 7:
				phoneBook.displayAllContacts();
				break;
			case 8:
				System.out.println("Enter name");
				name = sc.nextLine();
				name = sc.nextLine();
				if(phoneBook.searchFor(name)) {
					ArrayList<Integer> al11 = phoneBook.getNumbers(name);
					System.out.println("The numbers under name: " + name + " are:");
					for(int i = 0; i < al11.size(); i++) {
						System.out.println(al11.get(i));
					}
				}
				else {
					System.out.println("No numbers exist under this name");
				}
				break;
			default:
				Exit = true;
				break;
			}
		}
	}
}
