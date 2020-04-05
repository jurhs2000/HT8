import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueFactory<E extends Comparable<E>> {
    public Queue<E> getPriorityQueue(int pQueueType) {
        switch (pQueueType) {
            case 1:
                return new VectorHeap<E>(true);
            case 2:
                return new PriorityQueue<E>();
            default:
                return null;
        }
    }
}