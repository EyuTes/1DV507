package eb223db_assign1.Exercise1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{
	/**
	 *   Add integer n to the top of the stack. Resize  the array if necessary.
	 *   @param n an integer to be added at the end of the stack
	 */
	@Override
	public void push(int n) {
		
	 if(size==values.length-1) 
		 resize();
	  values[size++]=n;
	
	}
	/**
	 * Returns and removes integer at top of stack
	 * @return and remove an integer from the top of the stack or throw exception for underflow
	 */
	@Override
	public int pop() throws IndexOutOfBoundsException {
		if(isEmpty()){throw new ArrayIndexOutOfBoundsException("Empty stack");}
		return values[--size];
	}
	/**
	 * Returns an integer at top of stack
	 * @return an integer from the top of the stack or throw exception if stack is empty
	 */
	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(isEmpty()){throw new ArrayIndexOutOfBoundsException("Empty stack");}
		return values[size-1];
	}

}
