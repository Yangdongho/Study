package Linkedlist;

public class Node <E>{
	private E value;
	private Node next;
	
	
	public E getValue() {
		return value;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(E value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public void setValue(E value) {
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
