package Contacts;

import java.util.*;

public class use {
	public static void main(String args[]) {
		Trie phoneBook = new Trie();
		Scanner sc = new Scanner(System.in);
		boolean Exit = false;
		//Implement delete properly
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
			System.out.println("\tOr enter anything else to exit");
			System.out.println("/====================================================================================================/");
			int action = sc.nextInt();
			switch(action) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				Exit = true;
				break;
			}
		}
	}
}
