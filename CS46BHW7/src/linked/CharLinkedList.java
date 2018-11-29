package linked;

import java.util.*;


public class CharLinkedList {
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity(){
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null)
		{
			if (visitedNodes.contains(node))
				return false;		// Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}
		
		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}
	
	
	public CharNode find(char ch) {
		//precondition
		assert hasIntegrity();
		
		CharNode temp = head;
		
		//iterates through the nodes to look for the desired char.
		while(temp !=null){
			if(temp.getData() == ch) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	public void duplicate(char ch) {
		//precondition
		assert hasIntegrity();
		
		//position is equal to the node that contain the desired char. Position lies within head.
		CharNode position = find(ch);
		
		//makes sure it is a valid character. if not it will throw an exception
		if(position == null) {
			throw new IllegalArgumentException("Character is not in string");
		}
		
		//duplicates the node
		CharNode copy = new CharNode(position.getData());
		
		//sets the tail equal to the copy cuz now its at the end
		if(position == tail) {
			position.setNext(copy);
			tail = copy;
		}else {
			//sets temp to node after the desired node which will contain all nodes after the
			//node we're looking for
			CharNode temp = position.getNext();
			
			//sets the next node of position to the copied node. After this head will contain 
			// the desired nodes everything before them. Copy becomes the last node in head
			position.setNext(copy);
			
			//sets the next node of copy to term. This connects the node streams.
			copy.setNext(temp);
		}
		
	}
}