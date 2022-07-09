package Contacts;

public class Node {
	Node links[] = new Node[91];
	int noOfEnd = 0;
	int noOfPrefix = 0;
	
	public Node() {
		
	}
	
	boolean containsChar(char alphabet) {
		return (this.links[alphabet-' '] != null);
	}
	Node get(char alphabet) {
		return links[alphabet-' '];
	}
	
	void put(char alphabet, Node node) {
		links[alphabet-' '] = node;
	}
	
	void endsHere() {
		noOfEnd++;
	}
		
	void addPrefix() {
		noOfPrefix++;
	}
	
	void delEnd() {
		noOfEnd--;
	}
	
	void delPrefix() {
		noOfPrefix--;
	}
}
