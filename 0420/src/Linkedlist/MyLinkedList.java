package Linkedlist;

public class MyLinkedList<E> {
	private int count;
	private Node head;

	//

	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		count = 0;
		head = null;
	}

	public E get(int index) {
		Node temp = head;

		for (int i = 0; i < index-1; i++) {
			temp = temp.getNext();
		}

		return (E) temp.getValue();

	}

	public void set(int index, E value) {

		if (index == 0) {
			Node newN = new Node(value);
			newN.setNext(head);
			head = newN;

		} else {

			Node temp = head;

			for (int i = 1; i < index - 1; i++) {
				temp = temp.getNext();
			}
			Node newN = new Node(value);

			newN.setNext(temp.getNext());
			temp.setNext(newN);

		}
		count++;
	}

	public void add(String value) {

		if (head == null) {
			head = new Node(value);
		} else {
			Node temp = new Node(value);
			tail().setNext(temp);

		}
		count++;

	}

	public void remove(int index) {

		Node temp = head;

		if (index == 0) {
			head = head.getNext();
		} else {
			for (int i = 0; i < index - 2; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}

		count--;

	}

	public int size() {
		return count;
	}

	public Node tail() {// 제일 마지막 Node next에 주소를 넣기위해서
		Node tail = head;

		for (int i = 0; i < count - 1; i++) {
			tail = tail.getNext();
		}

		return tail;

	}

	public String toString() { // 전체 출력
		// StringBuilder 생성 후 계속해서 해둥 주소를 참조하여 수정
		// STtring 지속적으로 새로운 객체를 만드는것
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		for (int i = 0; i < count; i++) {
			sb.append(cur.getValue()).append(" ");
			cur = cur.getNext();
		}
		return sb.toString();
	}

}
