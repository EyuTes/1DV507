package eb223db_assign1.Exercise1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestStackAndList {

	int count = 0;
	CollectionFactory collection=new CollectionFactory();
	AbstractIntCollection stack=collection.getCollection("stack");
	AbstractIntCollection list=collection.getCollection("list");
	
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
	

}
