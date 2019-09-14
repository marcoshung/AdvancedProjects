import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*; // note static import

public class PrisonerGameTester {

	@Test
	public void testSize() {
		LinkedList prisoners=new LinkedList();
		assertTrue(prisoners.isEmpty()); //before inserting, list is empty assertEquals(0, prisoners.size); // Size is 0
		prisoners.setNumOfPrisoners(5);
		assertFalse(prisoners.isEmpty()); // after inserting element, list is not empty
		assertEquals(5,prisoners.size()); //size is 1
		
	}
	
	@Test
	public void outputTest() {
		LinkedList list = new LinkedList();
		
		list.playGame(6,2);
		assertEquals(1, list.getTargetData());
		list.clearList();
		
		list.playGame(1, 9);
		assertEquals(1,list.getTargetData());
		list.clearList();
		
		list.playGame(7, 7);
		assertEquals(4,list.getTargetData());
		list.clearList();
		
		list.playGame(12, 8);
		assertEquals(2,list.getTargetData());
		list.clearList();
		
		list.playGame(5,1);
		assertEquals(3,list.getTargetData());
		list.clearList();
	}
	

}
