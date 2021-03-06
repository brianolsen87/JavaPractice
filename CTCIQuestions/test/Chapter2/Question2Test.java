package Chapter2;

import DataStructures.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Question2Test{
	LinkedList<Integer> list;	
	Question2 q2;

	@Before
	public void setUp(){
		q2 = new Question2();
		list = new LinkedList<Integer>();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testRemoveDuplicates(){
		LinkedListNode<Integer> expected = list.getHead();
		assertNull(expected);
		assertEquals(expected, q2.getKthToLastNode(list.getHead(), 0));

		list.appendToTail(1);
		expected = list.getTail();

		list.appendToTail(2);
		list.appendToTail(3);

		assertEquals(expected, q2.getKthToLastNode(list.getHead(), 2));
	
		list.appendToTail(4);
		list.appendToTail(5);
		
		assertEquals(expected, q2.getKthToLastNode(list.getHead(), 4));

		assertNull(q2.getKthToLastNode(list.getHead(), 5));
	}

}
