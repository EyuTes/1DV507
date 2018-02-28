/**
 * An interface representing a simple integer list.  This interface defines the required
 * functionality for all <code>IntList</code> implementations. It provides
 * support for accessing (add, remove, get) at an arbitrary position in the list. It also
 * contains basic support for sequential access of the whole content (i.e., iterators).
 * <p/>
 * Illegal accesses (outside current range) should throw an unchecked exception of type
 * <code>IndexOutOfBoundsException</code>.
 * <p/>
 * Currently available <code>IntList</code> implementations in the 
 * <code>linked</code> package are:
 * <ul>
 * <li>  {@link data_structures.LinkedIntList} </li>
 * <li>  {@link data_structures.ArrayIntList} </li>
 * </ul>
 *
 * @author	Jonas Lundberg
 * @see	java.util.List
 * @since 2006-11-06
 */
package eb223db_assign1.Exercise1;

import java.lang.IndexOutOfBoundsException;


/* A simple interface describing an integer list. 
   Updated with exceptions 2015-09-17. */

public interface IntList extends Iterable<Integer> {
	
	/* Add integer n to the end of the list. */
	public void add(int n);
	
	/**
	 * Inserts integer <code>n</code> at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  
     *
     * @param      n integer to be added.
     * @param      index position where <code>n</code> should be added.
     * @throws     IndexOutOfBoundsException if <code>index</code>
     *             outside current range <code>[0, size]</code>.
	 */

	public void addAt(int n, int index) throws IndexOutOfBoundsException;
	
	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException;
	/**
	 * Get integer at position <code>index</code>.
     *
     * @param      index position of element to be returned.
     * @return	   element at position <code>index</code>
     * @throws     IndexOutOfBoundsException if <code>index</code>
     *             outside current range <code>[0, size]</code>.
	 */

	public int get(int index) throws IndexOutOfBoundsException;
	
	 /** Number of integers currently stored in the list. */
	
	public int size();
	
	/* Returns true if collection is empty. */
	public boolean isEmpty();
	
	/** Find first position of integer <code>n</code>. Returns -1 if element not found.
	 *  
     * @param      n element to look for
     * @return     index of first element found, otherwise return -1.
	 */

	public int indexOf(int n);
	
	/** Returns a string representation of the current list content.
	 *  For example, a string of like "[ 7 56 -45 68 ... ]".
	 *  
     *  @return     string representation of the content.
	 */

	public String toString();
}


