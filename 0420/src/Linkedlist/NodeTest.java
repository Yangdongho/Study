package Linkedlist;

import java.util.List;

public class NodeTest {
public static void main(String[] args) {
	
/*	Node temp1 = new Node("A");
	Node temp2 = new Node("B");
	System.out.println(temp1);
	
	temp1.add(value);
	//주소값 셋
	temp2.add(value);
	//List<String> list = new  ArrayListst<String>();
	
	
	temp1 = temp2;
	System.out.println(temp2);
	System.out.println(temp1);*/
	
	MyLinkedList list = new MyLinkedList();
	
	list.add("A");
	list.add("B");
	list.add("C");
	list.add("D");
	list.add("E");
	list.add("F");
	System.out.println(list+"  "+list.size());
	
	list.set(0, "dds");
	System.out.println(list+"  "+list.size());
	
	//System.out.println(list);
	
	//System.out.println(list.get(3));
	//list.set(2, "NEW");
	/*System.out.println("set : "+list);
	
	list.remove(0);
	System.out.println("remove  : "+list);*/
	
	
	
	}
}
