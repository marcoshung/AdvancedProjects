
public class Node {
	private int prisonerNum;
	private Node next;
	private Node prev;
	
	public Node(int num) {
		this.prisonerNum = num;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public void setPrev(Node node) {
		this.prev = node;
	}
	
	public int getData() {
		return this.prisonerNum;
	}
}
