package eb223db_assign1.Exercise1;

public class ArrayIntList extends AbstractIntCollection implements IntList{
	/**
	 * Add integer n to the end of the list.Resize the array if necessary.
	 * 
	 * @param n an integer to be added at the end of the list
	 */
	@Override
	public void add(int n) {
		if(size==values.length-1)
			resize();
	  values[size++]=n;
	}
	/**
	 * Add integer n specified index within the list. Resize the array if
	 * necessary.
	 * 
	 * @param n
	 *            an integer to be added. Shifting is required if the index is
	 *            before the end of the list.
	 * @param index
	 *            an integer that indicate the desired position.
	 */
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		
		checkIndex(index, size+1);
		makeSpace(index,size);//i need to test this again
		size++;
		values[index] = n;
	
		/* resize: if needed  */
		if (size == values.length) 
			resize();
				
	}
	/**
	 * Remove integer at position index or throw exception if not possible
	 * 
	 * @param index
	 *            an integer that is index for the list
	 */
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index,size)) throw new IndexOutOfBoundsException("Wrong");
		removeSpace(index,size);
		size--;
	}
	/**
	 * Get integer at position index.
	 * 
	 * @param index
	 *            an integer to find the corresponding value in the list.
	 * @return either corresponding value for the a given key or throw exception
	 */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(!checkIndex(index,size)) throw new IndexOutOfBoundsException("Wrong");
		//checkIndex(index, size);
		return values[index];
	}
	/**
	 * Find position of integer n
	 * 
	 * @param n
	 *            an integer @ return the index of a given integer if found,
	 *            otherwise return -1
	 */
	@Override
	public int indexOf(int n) {
		
		for (int i=0;i< size;i++) {
			if (values[i]==n)
				return i;
		}
		return -1;
	}
	private void makeSpace(int index, int size){
		/* Shift right and add new value*/
		for (int i=size;i > index;i--) 
			values[i] = values[i-1];
		
	}
	private void removeSpace(int index, int size){
		/* remove space */
		for (int i=index;i< size;i++)
			values[i] = values[i+1];
	}
}
