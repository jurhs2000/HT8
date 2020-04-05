import java.util.Queue;

public interface PriorityQueue<E extends Comparable<E>> extends Queue<E> {

    public E peek(); //getFirst
    // pre: !isEmpty()
    // post: returns the minimum value in priority queue
    public E poll(); //remove
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    public boolean add(E value);
    // pre: value is non-null comparable
    // post: value is added to priority queue
    public boolean isEmpty();
    // post: returns true iff no elements are in queue
    public int size();
    // post: returns number of elements within queue
    public void clear();
    // post: removes all elements from queue
}