import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length = 0;
	private int targetData;
	double startTime = System.currentTimeMillis();
	
	public LinkedList() {}
	
	//This is the call function for outside classes to run the game
	public Node playGame(int numPrisoners, int count) {
		setNumOfPrisoners(numPrisoners);
		return getPosition(count);
	}
	
	//this method will insert a node at the end of the LinkedList
	public void insert(int num){
		
		Node node = new Node(num);
		
		if (this.head == null) { // corner case : inserting into empty node.
			this.head = node;		
			this.tail = node;
			//the prev node will be itself in this case
			this.head.setPrev(this.tail);
		}else {
			//Current node is now the new tail
			this.tail.setNext(node);
			//former tail is now this Node's previous value
			node.setPrev(this.tail);
			//the head will now be the node's next val
			node.setNext(this.head);
			this.tail = node;
			//resets the head node's prev to the correct tail
			this.head.setPrev(this.tail);
		}
	}
	
	//method sets the number of nodes in the linkedList
	public void setNumOfPrisoners(int num) {
		this.length = num;
		
		for(int i = 1; i <= num; i++) {
			insert(i);
		}
		System.out.println("Time to create new LinkedList: " + (System.currentTimeMillis() - startTime) + " milliseconds");

	}
	
	//returns the winner of the game
	public Node getPosition(int k) {
		printAllValues();
		System.out.println(" Inital list of prisoners; start counting from 1");
		Node targetNode = this.head; // Since we start counting from a node ahead of given position
	
		while(length > 1) {
			for(int i = 0; i < k; i++) {
				targetNode = targetNode.getNext();
			}
			
			//corner cases: node is head or tail
			if(targetNode == this.head) {
				this.head = this.head.getNext();
			}
			if(targetNode == this.tail) {
				this.tail = this.tail.getPrev();
			}
			Node eliminatedNode = targetNode;
			
			//removes the target node from the linkedlist by pointing the surronding nodes to each other
			targetNode.getPrev().setNext(targetNode.getNext());
			targetNode.getNext().setPrev(targetNode.getPrev());
			System.out.println("Time to delete a node: " + (System.currentTimeMillis() - startTime) + " milliseconds");

			
			targetNode = targetNode.getNext(); //Since we start counting a node ahead of given position
			length--;
			
			printAllValues();
			System.out.print(" Prisoner " + eliminatedNode.getData() + " eliminated.");
			if(length != 1) {
				System.out.println(" Continue counting from " + targetNode.getData());
			}else{
				System.out.println(" Lucky prisoner " + targetNode.getData() + " is the lucky winner");
			}
			
		}
		this.targetData = targetNode.getData();
		System.out.println("Time to find winner: " + (System.currentTimeMillis() - startTime) + " milliseconds");

		return targetNode;
	}
	
	public void printAllValues() {
		Node node = this.head;
		for(int i = 0;i < this.length; i++) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
	}
	
	public boolean isEmpty() {
		if(length == 0) {
			return true;
		}
		return false;
	}
	
	
	public int size() {
		return this.length;
	}

	public int getTargetData() {
		return this.targetData;
	}
	
	//resets private values.
	public void clearList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
		this.targetData = 0;
	}
}
