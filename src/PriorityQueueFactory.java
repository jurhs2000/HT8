/**
 * UVG - ADT - HT8
 * 
 * Implementacion de patron Factory para decidir si utilizar el 
 * Priority Queue de Java Collection Framework o utilizar el Heap
 * basado en vectores.
 * 
 * @author Julio Herrera
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueFactory<E extends Comparable<E>> {

    /**
     * Devuelve la cola elegida segun el parametro. 1. VectorHeap 2. PriorityQueue
     * JCF
     * 
     * @param pQueueType el numero elegido
     * @return Una cola ya que es la interfaz comun entre estas clases
     */
    public Queue<E> getPriorityQueue(int pQueueType) {
        switch (pQueueType) {
            case 1:
                /**
                 * Se coloca true ya que se quiere que sea un Min Heap
                 */
                return new VectorHeap<E>(true);
            case 2:
                /**
                 * Este ProrityQueue viene directamente de java.util (JCF)
                 */
                return new PriorityQueue<E>();
            default:
                return null;
        }
    }
}