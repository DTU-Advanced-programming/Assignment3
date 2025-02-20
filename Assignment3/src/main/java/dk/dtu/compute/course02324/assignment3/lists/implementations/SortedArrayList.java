package dk.dtu.compute.course02324.assignment3.lists.implementations;


import dk.dtu.compute.course02324.assignment3.lists.types.List;
import dk.dtu.compute.course02324.assignment3.lists.types.SortedList;

import javax.validation.constraints.NotNull;
import java.util.Comparator;

/**
 * An implementation of the interface {@link SortedList} based on the
 * {@link ArrayList} implementation of the interface{@link List}
 * arrays, which dynamically are adapted in size when needed.
 *
 * @param <E> the type of the list's elements.
 */
public class SortedArrayList<E extends Comparable<E>> extends ArrayList<E> implements SortedList<E> {

    @Override
    public boolean add(@NotNull E e) {
        if (e == null ) {
        	throw new IllegalArgumentException("add, null");
        }
        this.add(findIndexToInsert(e),e);
        return true;
        //      needs implementation (Assignment 3b)
    }

    /**
     * Finds the position at which a given element should be inserted
     * to the sorted list. The element must not be <code>null</code>.
     * The implementation finds this position by linearly going through
     * the array, stopping at the first element greater or equal to
     * this element.
     *
     * @param e the given element to be inserted
     * @return the position at which the element should be inserted
     */
    private int findIndexToInsert(@NotNull E e) {
        // simple implementation finding the index in a linear way

        //      implementing and using this method might help you with
        //      a simple implementation of the add(E e) method.
        //      (Assignment 3b)
        int i=0;
        while ( i<this.size() && e.compareTo(this.get(i))>0 ) {i++;}
        return i;

    }
    
    @Override
    public void sort(@NotNull Comparator<? super E> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("sort, Can't sort sortedArrayList");
    }

}
