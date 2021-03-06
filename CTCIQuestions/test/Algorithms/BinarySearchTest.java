package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class BinarySearchTest{

	@Before
	public void setUp(){
		
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testBinarySearch(){
		List<Integer> arr = new ArrayList<Integer>();
		List<String> strArr = new ArrayList<String>();
		int expected = -1;
		
		assertEquals(expected, BinarySearch.binarySearch(arr, 1));
		assertEquals(expected, BinarySearch.binarySearchRecursive(arr, 1));
		assertEquals(expected, BinarySearch.binarySearch(null, 1));
		assertEquals(expected, BinarySearch.binarySearchRecursive(null, 1));
		
		assertEquals(expected, BinarySearch.binarySearch(strArr, "1"));
		assertEquals(expected, BinarySearch.binarySearchRecursive(strArr, "1"));
		assertEquals(expected, BinarySearch.binarySearch(null, "1"));
		assertEquals(expected, BinarySearch.binarySearchRecursive(null, "1"));
		
		for(expected = 0; expected < 10; expected++){
			String expectedString = Integer.toString(expected);
			arr.add(expected);
			strArr.add(expectedString);
			
			assertEquals(expected, BinarySearch.binarySearch(arr, expected));
			assertEquals(expected, BinarySearch.binarySearchRecursive(arr, expected));
			
			assertEquals(expected, BinarySearch.binarySearch(strArr, expectedString));
			assertEquals(expected, BinarySearch.binarySearchRecursive(strArr, expectedString));
		}
		
		expected = -1;
		
		for(int i = 0; i < 10; i++){
			String expectedString = Integer.toString(i);
			arr.remove(new Integer(i));
			strArr.remove(expectedString);
			assertEquals(expected, BinarySearch.binarySearch(arr, i));
			assertEquals(expected, BinarySearch.binarySearchRecursive(arr, i));
			assertEquals(expected, BinarySearch.binarySearch(strArr, expectedString));
			assertEquals(expected, BinarySearch.binarySearchRecursive(strArr, expectedString));
		}

	}
	
	@Test
	public void testBinarySearchCustomClass(){
		List<CustomClass> arr = new ArrayList<CustomClass>();
		int expected = 1;
		
		arr.add(new CustomClass(4, "F", 11));
		arr.add(new CustomClass(5, "G", 6));
		arr.add(new CustomClass(10, "A", 10));
		arr.add(new CustomClass(3, "D", 7));
		arr.add(new CustomClass(1, "D", 8));
		arr.add(new CustomClass(6, "A", 8));
		arr.add(new CustomClass(6, "D", 3));
		arr.add(new CustomClass(1, "A", 5));
		arr.add(new CustomClass(4, "C", 2));
		arr.add(new CustomClass(5, "D", 3));
		arr.add(new CustomClass(9, "A", 4));
		arr.add(new CustomClass(2, "C", 1));
		arr.add(new CustomClass(1, "B", 9));
		
		//System.out.println("Before Sort: ");
		//System.out.println(arr);
		
		Collections.sort(arr);
		
		//System.out.println("After Sort: ");
		//System.out.println(arr);
		
		//Notice notId doesn't have to match
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(1, "B", 122)));
		
		expected = 4;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(3, "D", 123)));
		
		expected = 7;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(5, "D", 99)));
		
		expected = 12;
		assertEquals(expected, BinarySearch.binarySearch(arr, new CustomClass(10, "A", 8675309)));
	}
	
}
