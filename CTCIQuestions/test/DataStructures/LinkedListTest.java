package DataStructures; 

import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListTest{

	LinkedList<Integer> list;

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		list = new LinkedList<Integer>();	
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testInitialize(){
		assertNotNull(list);
		assertNull(list.getHead());
		assertNull(list.getTail());
	}

	@Test
	public void testAppendAndRemoveFromNull(){
		Integer expected = new Integer(5);
		list.appendToTail(expected);
		assertEquals(expected,list.getHead().getData());
		assertNull(list.getHead().getNext());
		assertNull(list.getHead().getPrev());

		list.remove(expected);
		assertNull(list.getHead());
		assertNull(list.getTail());
		assertEquals(0,list.size());
		
		//Added this to make sure the head and tail go back to null after calling removeTail
		list.appendToTail(expected);
		list.removeTail();
		assertNull(list.getHead());
		assertNull(list.getTail());
		assertEquals(0,list.size());
	}
	
	@Test
	public void testAppendAndRemoveAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		
		list.appendToTail(five);
		list.appendToTail(eight);

		assertEquals(eight, list.getHead().getNext().getData());
		assertEquals(eight, list.getTail().getData());
		
		assertEquals(five, list.getTail().getPrev().getData());
		assertEquals(five, list.getHead().getData());

		list.remove(eight);
		assertEquals(five, list.getHead().getData());
		assertEquals(five, list.getTail().getData());
		assertEquals(1, list.size());

		list.appendToTail(eight);

		assertEquals(eight, list.getHead().getNext().getData());
		assertEquals(eight, list.getTail().getData());
		
		assertEquals(five, list.getTail().getPrev().getData());
		assertEquals(five, list.getHead().getData());

		list.remove(five);
		assertEquals(eight, list.getHead().getData());
		assertEquals(eight, list.getTail().getData());
		assertEquals(1, list.size());

	}

	@Test
	public void testAppendAndRemoveTailAfterTwoElements(){
		Integer five = new Integer(5);
		Integer nine = new Integer(9);
		Integer eight = new Integer(8);
		
		list.appendToTail(five);
		list.appendToTail(nine);
		list.appendToTail(eight);

		assertEquals(five, list.getHead().getData());
		assertEquals(eight, list.getTail().getData());

		assertEquals(nine, list.getHead().getNext().getData());
		assertEquals(nine, list.getTail().getPrev().getData());
		
		list.removeTail();
		
		assertEquals(nine, list.getHead().getNext().getData());
		assertEquals(nine, list.getTail().getData());
		
		assertEquals(five, list.getTail().getPrev().getData());
		assertEquals(five, list.getHead().getData());
		
		assertEquals(2, list.size());
	}

	@Test
	public void testAppendToHeadFromNull(){
		Integer expected = new Integer(5);
		
		list.appendToHead(expected);
		
		assertEquals(expected,list.getHead().getData());
		assertNull(list.getHead().getNext());
		assertNull(list.getHead().getPrev());
	}

	@Test
	public void testAppendToHeadAfterOneElement(){
		Integer five = new Integer(5);
		Integer eight = new Integer(8);
		
		list.appendToHead(five);
		list.appendToHead(eight);

		assertEquals(five, list.getHead().getNext().getData());
		assertEquals(five, list.getTail().getData());
		
		assertEquals(eight, list.getTail().getPrev().getData());
		assertEquals(eight, list.getHead().getData());
	}

	@Test
	public void testAppendToHeadAfterTwoElement(){
		Integer five = new Integer(5);
		Integer nine = new Integer(9);
		Integer eight = new Integer(8);
		
		list.appendToHead(five);
		list.appendToHead(nine);
		list.appendToHead(eight);

		assertEquals(eight, list.getHead().getData());
		assertEquals(five, list.getTail().getData());

		assertEquals(nine, list.getHead().getNext().getData());
		assertEquals(nine, list.getTail().getPrev().getData());
	}

	@Test
	public void testSearch(){
		Integer five = new Integer(5);
		Integer nine = new Integer(9);
		Integer eight = new Integer(8);
		
		list.appendToTail(five);
		list.appendToTail(nine);
		list.appendToTail(eight);

		assertEquals(five, list.search(five).getData());
		assertEquals(eight, list.search(eight).getData());
		assertEquals(nine, list.search(nine).getData());
		assertNull(list.search(4));
	}
	
	@Test
	public void testRemove(){
		Integer five = new Integer(5);
		Integer nine = new Integer(9);
		Integer eight = new Integer(8);
		
		list.appendToTail(five);
		list.appendToTail(nine);
		list.appendToTail(eight);
		
		assertEquals(nine, list.search(nine).getData());
		
		list.remove(nine);

		assertEquals(five, list.search(five).getData());
		assertEquals(eight, list.search(eight).getData());
		assertNull(list.search(9));
		assertNull(list.search(4));
	}
}
