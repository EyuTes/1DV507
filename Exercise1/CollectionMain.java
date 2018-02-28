package eb223db_assign1.Exercise1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CollectionMain {
	static ArrayIntStack intStack=new ArrayIntStack();
	static ArrayIntList intList=new ArrayIntList();
	
	public static void main(String[] args) {
		
		CollectionMain.testIsListEmpty();
		CollectionMain.testIsStackEmpty();
	}
	public static void testIsListEmpty() {

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
	public static void testIsStackEmpty() {

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
}
