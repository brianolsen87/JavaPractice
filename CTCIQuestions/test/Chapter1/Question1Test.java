package Chapter1;

import org.junit.*;
import static org.junit.Assert.*;

public class Question1Test{
	
	Question1 q1;

	@Before
	public void setUp(){
		q1 = new Question1();
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testIsUnique(){
		assertFalse(q1.isUnique(null));
		assertTrue(q1.isUnique(""));
		assertTrue(q1.isUnique("abcdefghijklmnopqrstuvwxyz1234567890?><!@#$%^&*()_ 	"));
		assertFalse(q1.isUnique("hello it's me..."));
		assertFalse(q1.isUnique("  "));
	}
}
