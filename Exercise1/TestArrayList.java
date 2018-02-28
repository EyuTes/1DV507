package eb223db_assign1.Exercise1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestArrayList {

	private static int count = 0;
	ArrayIntList intList=new ArrayIntList();
	
	/**
	 * Test for methods on ArrayList and methods in the abstract supper class
	 */
	@Test
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
	public void testIsEmpty() {

		boolean isEmpty = true;// Expected
		/* Test isEmpty() method */
		assertEquals(isEmpty, intList.isEmpty());
		
		/* Test that throws exception for remove from empty list or wrong index*/
		
		try {
			intList.remove(3);
		} catch (IndexOutOfBoundsException e) {
			isEmpty = true;
		}
		assertTrue(isEmpty);
		intList.add(4);
		intList.remove(0);
		boolean isEmptyForWrongIndex = false;// Expected
		try {
			intList.remove(0);
		} catch (IndexOutOfBoundsException e) {
			isEmptyForWrongIndex = true;
		}
		assertTrue(isEmptyForWrongIndex);
		
	}
	@Test
	public void testListSize(){

		/* Add to the list */
		intList.add(2);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(10);
		intList.add(12);
		intList.add(14);
		intList.add(16);
		intList.add(18);
		int expected=9;
		assertEquals(intList.size(), expected);
	}
	
	@Test
	public void testListExceptions() {
		/* Test add() method */
		intList.add(12);
		intList.add(14);
		intList.add(20);
		intList.add(22);
		intList.add(16);
		intList.add(18);
		/* Test size() method */
		assertEquals(intList.size(), 6);
		/* Test get() method */
		assertEquals(intList.get(2), 20);
		assertEquals(intList.get(0), 12);
		assertEquals(intList.get(5), 18);
		/* Test indexOf() method */
		assertEquals(intList.indexOf(20), 2);
		assertEquals(intList.indexOf(14), 1);
		assertEquals(intList.indexOf(124), -1);
		/* Test addAt() method */
		intList.addAt(32,2);
		intList.addAt(34,4);
		intList.addAt(36,6);
		assertEquals(intList.indexOf(32), 2);
		assertEquals(intList.indexOf(34), 4);
		assertEquals(intList.get(6), 36);
		Iterator<Integer> itr=intList.iterator();
		while(itr.hasNext()){
			itr.next();
		}
		
		
	}
    @Test
    public void testAddAtSpecificPostion(){
    	/* Test addAt() method */
    	intList.add(10);
    	intList.add(15);
    	intList.add(20);
    	intList.add(25);
    	intList.add(27);
    	intList.add(30);
    	intList.add(38);
		intList.addAt(32,2);
		intList.addAt(34,4);
		intList.addAt(36,6);
		assertEquals(intList.indexOf(30), 8);
		assertEquals(intList.indexOf(34), 4);
		assertEquals(intList.get(6), 36);
		Iterator<Integer> itr=intList.iterator();
		while(itr.hasNext()){
			itr.next();
		}
		
    }
    @Test
    public void testremoveList(){
    	/* Test addAt() method */
    	intList.add(10);
    	intList.add(15);
    	intList.add(20);
    	intList.add(25);
    	intList.add(27);
    	intList.add(30);
    	intList.add(38);
		intList.addAt(32,2);
		intList.addAt(34,4);
		intList.addAt(36,6);
		intList.remove(3);
		intList.remove(5);
		assertEquals(intList.indexOf(30), 6);
		assertEquals(intList.indexOf(34), 3);
		assertEquals(intList.get(6), 30);
		Iterator<Integer> itr=intList.iterator();
		while(itr.hasNext()){
			itr.next();
		}
		
    }
    @Test
    public void testMethodGet(){
    
    	boolean isEmpty = false;
		try {
			intList.get(0);
		} catch (IndexOutOfBoundsException e) {
			isEmpty = true;
		}
		assertTrue(isEmpty);
    	
		intList.add(12);
		intList.add(14);
		assertEquals(intList.get(1), 14);
    }
    @Test
    public void testMethodIndexOf(){
    	
    	boolean isEmpty = false;
		try {
			intList.get(0);
		} catch (IndexOutOfBoundsException e) {
			isEmpty = true;
		}
		assertTrue(isEmpty);
    	
		intList.add(12);
		intList.add(14);
		assertEquals(intList.indexOf(12), 0);
    }
    @Test
    public void testMethodToString(){
    	intList.add(2);
		intList.add(5);
		String expected="[ 2 5 ]";
		assertEquals(intList.toString(),expected);
    }
}
