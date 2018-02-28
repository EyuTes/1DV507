package eb223db_assign1.Exercise1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestArrayStack {
	int count = 0;
	ArrayIntStack intStack=new ArrayIntStack();
	/* Executed before every test method. */
	@Before
	public void setUp() {
		System.out.println("Run test method: " + (++count));
	}

	/* Executed after every test method. */
	@After
	public void tearDown() {
		System.out.println(" --- done with test " + count);
	}
	@Test
	public void testIsStackEmpty() {

		boolean isEmpty = true;// Expected
		assertEquals(isEmpty, intStack.isEmpty());
		
		/* Test that throws exception for pop*/
		boolean isEmptyForPop = true;// Expected
		try {
			intStack.pop();
		} catch (IndexOutOfBoundsException e) {
			isEmptyForPop = true;
		}
		assertTrue(isEmptyForPop);
		/* Test that throws exception  for peek*/
		boolean isEmptyForPeek = false;
		
		try {
			intStack.peek();
		} catch (IndexOutOfBoundsException e) {
			isEmptyForPeek = true;
		}
		assertTrue(isEmptyForPeek);
			
	}
	@Test
	public void testSize(){

		/* for integer data type */
		intStack.push(2);
		intStack.push(4);
		intStack.push(6);
		intStack.push(8);
		intStack.push(10);
		intStack.push(12);
		intStack.push(14);
		intStack.push(16);
		intStack.push(18);
		int expected=9;
		assertEquals(intStack.size(), expected);
	}
	@Test
	public void testStackExceptions() {
		
		intStack.push(12);
		intStack.push(14);
		intStack.push(16);
		intStack.push(18);
		assertEquals(intStack.size(), 4);
		assertEquals(intStack.peek(), 18);
		assertEquals(intStack.pop(), 18);
		assertEquals(intStack.pop(), 16);
		assertEquals(intStack.pop(), 14);
		assertEquals(intStack.pop(), 12);
		boolean isEmpty = false;
		/* Test that throws exception for pop*/
		try {
			intStack.pop();
		} catch (IndexOutOfBoundsException e) {
			isEmpty = true;
		}
		assertTrue(isEmpty);
		boolean isEmptyForPeek = false;
		/* Test that throws exception  for peek*/
		try {
			intStack.peek();
		} catch (IndexOutOfBoundsException e) {
			isEmptyForPeek = true;
		}
		assertTrue(isEmptyForPeek);
	}
	 @Test
	 public void testMethodToString(){
	    	intStack.push(2);
	    	intStack.push(5);
	    	intStack.push(7);
			String expected="[ 2 5 7 ]";
			assertEquals(intStack.toString(),expected);
	  }
	
	 @Test
	 public void testMethodPop(){
		 boolean isEmpty= false;
			/* Test that throws exception  for peek*/
			try {
				intStack.pop();
			} catch (IndexOutOfBoundsException e) {
				isEmpty = true;
			}
			assertTrue(isEmpty);
		intStack.push(3);
		intStack.push(5);
		intStack.push(7);
		assertEquals(intStack.size(), 3);
		assertEquals(intStack.pop(), 7);
		assertEquals(intStack.pop(), 5);
	 }
	 @Test
	 public void testMethodPeek(){
		 boolean isEmpty= false;
			/* Test that throws exception  for peek*/
			try {
				intStack.peek();
			} catch (IndexOutOfBoundsException e) {
				isEmpty = true;
			}
			assertTrue(isEmpty);
		intStack.push(3);
		intStack.push(5);
		intStack.push(7);
		assertEquals(intStack.size(), 3);
		assertEquals(intStack.peek(), 7);
		assertEquals(intStack.peek(), 7);
	 }
}
