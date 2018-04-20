package Linkedlist;

public class Node {
	private String value;
	private Node next;
	
	
	public String getValue() {
		return value;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}
	
	
	@Override
	public String toString() {
		return value+" ";
	}


}
