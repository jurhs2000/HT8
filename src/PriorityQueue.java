/**
 * UVG - ADT - HT8
 * 
 * Interfaz que define los metodos necesarios para implementar un
 * priority Queue, en este caso se usara en el VectorHeap. Aunque por el libro
 * JavaStructures sabemos que el PriorityQueue no debe ser tratado como una Cola,
 * ya que no necesariamente el primero que entra es el primero que sale (En este 
 * programa, sí se necesita eso y se soluciona por el comparable del paciente),
 * necesitamos la interfaz Queue para poder estar en la misma familia 
 * que el PriorityQueue de JCF y poder funcionar con el Factory.
 * 
 * Bailey Duane A. (2007). Data Structures in Java for the Principled Programmer. Williams College
 * 
 * @author Julio Herrera
 * 
 * @see VectorHeap
 */
import java.util.Queue;

public interface PriorityQueue<E extends Comparable<E>> extends Queue<E> {

    /**
     * Este seria el getFirst()
     * pre: !isEmpty()
     * post: return the minimum value in priority queue
     */
    public E peek();

    /**
     * Este seria el remove()
     * pre: !isEmpty()
     * post: return and removes minimum or maximum value from queue
     */
    public E poll();

    /**
     * pre: value is non-null comparable
     * post: value is added to priority queue
     */
    public boolean add(E value);
    
    /**
     * post: returns true iff no elements are in queue
     */
    public boolean isEmpty();
    
    /**
     * post: returns number of elements within queue
     */
    public int size();
    
    /**
     * post: removes all elements from queue
     */
    public void clear();
}