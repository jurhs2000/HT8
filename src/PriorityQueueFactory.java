import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueFactory<E> {
    public Queue<E> getQueue(int pQueueType) {
        switch (pQueueType) {
            case 1:
                return null;
            case 2:
                return new PriorityQueue<E>();
            default:
                return null;
        }
    }
}