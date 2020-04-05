import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private Vector<E> data = new Vector<E>();

    private boolean isMinHeap;

    public VectorHeap(boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }

    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        if (isMinHeap) {
            while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
                data.set(leaf, data.get(parent));
                leaf = parent;
                parent = parent(leaf);
            }
        } else {
            while (leaf > 0 && (value.compareTo(data.get(parent)) > 0)) {
                data.set(leaf, data.get(parent));
                leaf = parent;
                parent = parent(leaf);
            }
        }
        data.set(leaf, value);
    }

    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (isMinHeap) {
                    if ((right(root) < heapSize) && ((data.get(childpos)).compareTo(data.get(childpos + 1)) > 0)) {
                        childpos++;
                    }
                    // Assert: childpos indexes smaller of two children
                    if ((data.get(childpos)).compareTo(value) < 0) {
                        data.set(root, data.get(childpos));
                        root = childpos; // keep moving down
                    } else { // found right location
                        data.set(root, value);
                        return;
                    }
                } else {
                    if ((right(root) < heapSize) && ((data.get(childpos)).compareTo(data.get(childpos + 1)) < 0)) {
                        childpos++;
                    }
                    // Assert: childpos indexes smaller of two children
                    if ((data.get(childpos)).compareTo(value) > 0) {
                        data.set(root, data.get(childpos));
                        root = childpos; // keep moving down
                    } else { // found right location
                        data.set(root, value);
                        return;
                    }
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

    @Override
    public E peek() {
        return data.get(0);
    }

    @Override
    public E poll() {
        E root = peek();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return root;
    }

    @Override
    public boolean add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return (data.size() == 0) ? true : false;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

    public String toString() {
        String constructedString = "";
        for (E e : data) {
            constructedString += e.toString();
        }
        return constructedString;
    }

    /**
     * NOT USED METHODS
     */
    
    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean offer(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }
}