package eb223db_assign1.Exercise3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRecursion {
	int count = 0;
	
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
	public void testRecursiveSum() {
		/* test recursive sum for different inputs */
		
		assertEquals(SumMain.sum(1), 1);
		assertEquals(SumMain.sum(2), 3);
		assertEquals(SumMain.sum(5), 15);
		assertEquals(SumMain.sum(10), 55);
		assertEquals(SumMain.sum(100), 5050);
				
	}
	@Test (expected = IllegalArgumentException.class) 
	public void testtestIllegalArgumentRecursiveSums(){
		/* test Illegal Arguments for wrong inputs */
		SumMain.sum(0);
	}
	@Test
	public void testPascalTriangle(){
		
		//If N=0
		int []expected=new int[]{1};
		equals(PascalMain.pascal(0).equals(expected));
		
		//If N=1
		int []result=PascalMain.pascal(1);
		expected=new int []{1,1};
		assertEquals(Arrays.toString(result),Arrays.toString(expected));
		
		//If N=2
		expected=new int[]{1,3,1};
		equals(PascalMain.pascal(2).equals(expected));
		
		//If N=3
		expected=new int[]{1,3,1};
		equals(PascalMain.pascal(3).equals(expected));
		
		//If N=4
		 expected=new int[]{1,3,3,1};
		 equals(PascalMain.pascal(4).equals(expected));
		 
		//If N=5
		 expected=new int[]{1,4,6,4,1};
		 equals(PascalMain.pascal(5).equals(expected));
		 
		//If N=6
		 expected=new int[]{1,5,10,10,5,1};
		 equals(PascalMain.pascal(6).equals(expected));
		 
		//If N=7
		 expected=new int[]{1,6,15,20,15,6,1};
		 equals(PascalMain.pascal(6).equals(expected));
	}
}
