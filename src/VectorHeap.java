/**
 * UVG - ADT - HT8
 * 
 * PriorityQueue vasado en Vector. Este funciona tanto como Min o como Max Heap,
 * segun se le indique en el contructor.
 * isMinHeap = true => Sera un Min Heap
 * isMinHeap = false => Sera un Max Heap
 * Implementa su propia interfaz PriorityQueue y necesita que el generico
 * sea Comparable.
 * 
 * Se definiran solo los metodos que propone la implementacion, los metodos de
 * Queue<E> seran implementados mas no definidos.
 * 
 * Por lo tanto este PriorityQueue contiene como raiz el minimo o maximo de los datos
 * en el vector sin importar si este fue añadido antes o despues que uno igual, es decir,
 * no se comporta como una Cola.
 * 
 * Bailey Duane A. (2007). Data Structures in Java for the Principled Programmer. Williams College
 * 
 * Package Structure5. Class VectorHeap<E extends java.lang.Comparable<E>>.
 * Extraido de: http://www.cs.williams.edu/~bailey/JavaStructures/doc/structure5/structure5/VectorHeap.html
 * 
 * @author Julio Herrera
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    /**
     * El Vector es la estructura de datos que guarda los objetos del Heap
     * y lo hace por nivel, de izquierda a derecha segun el arbol binario que define
     * el orden de los datos, esto es conocido como Level-Order Tree Traversal.
     */
    private Vector<E> data = new Vector<E>();

    /**
     * Para saber si el VectorHeap es un Min Heap o Max Heap
     * true : es Min Heap
     * false : es Max Heap
     */
    private boolean isMinHeap;

    /**
     * Constructor del VectorHeap
     * @param isMinHeap define si el Heap es Min Heap, si es falso
     *                  el Heap es un Max Heap.
     */
    public VectorHeap(boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
    }

    /**
     * @param i Index de un elemento en el vector
     * @return el Index del padre del nodo seleccionado
     */
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param i Index de un elemento en el vector
     * @return El index del hijo izquierdo al nodo seleccionado
     */
    private static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * @param i Index de un elemento en el vector
     * @return El index del hijo derecho al nodo seleccionado
     */
    private static int right(int i) {
        return 2 * (i + 1);
    }

    /**
     * Añade un elemento al vector a la ultima posicion.
     * Luego con percolateUp lo mueve a la posicion necesaria
     * @param value Un valor del tipo generico trabajado
     * @return True porque sí!
     */
    @Override
    public boolean add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
        return true;
    }

    /**
     * Se compara segun si es un Min o Max Heap.
     * Compara al nodo seleccionado con su padre para saber si moverlo
     * y hacer el cambio.
     * Mueve hacia arriba un nodo.
     * @param leaf Index del nodo que se movera hacia arriba
     */
    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        /**
         * Si es un Min Heap
         */
        if (isMinHeap) {
            while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
                data.set(leaf, data.get(parent));
                leaf = parent;
                parent = parent(leaf);
            }
        /**
         * Si es un Max Heap
         */
        } else {
            while (leaf > 0 && (value.compareTo(data.get(parent)) > 0)) {
                data.set(leaf, data.get(parent));
                leaf = parent;
                parent = parent(leaf);
            }
        }
        data.set(leaf, value);
    }

    /**
     * Elimina la raiz actual del Heap y devuelve el valor eliminado.
     * Utiliza pushDownRoot para poder llevar a la nueva raiz (el ultimo
     * valor ingresado en el vector) para llevarlo a donde corresponde.
     * @return El valor eliminado
     */
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

    /**
     * Se compara segun si es un Min o Max Heap.
     * Compara primero los dos nodos hijos para saber cual es el mayor o menor.
     * El seleccionado es intercambiado por la raiz y esta se vuelve a compararar
     * y a cambiar.
     * Mueve hacia abajo un nodo.
     * @param root Index 0, la nueva raiz que era el ultimo elemento ingresado
     */
    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                /**
                 * Si es un min Heap
                 */
                if (isMinHeap) {
                    // Se determina que hijo es el menor
                    if ((right(root) < heapSize) && ((data.get(childpos)).compareTo(data.get(childpos + 1)) > 0)) {
                        childpos++;
                    }
                    // Se compara el hijo seleccionado con el padre
                    if ((data.get(childpos)).compareTo(value) < 0) {
                        data.set(root, data.get(childpos));
                        root = childpos;
                    } else {
                        data.set(root, value);
                        return;
                    }
                /**
                 * Si es un Max Heap
                 */
                } else {
                    // Se determina que hijo es el mayor
                    if ((right(root) < heapSize) && ((data.get(childpos)).compareTo(data.get(childpos + 1)) < 0)) {
                        childpos++;
                    }
                    // Se compara el hijo seleccionado con el padre
                    if ((data.get(childpos)).compareTo(value) > 0) {
                        data.set(root, data.get(childpos));
                        root = childpos;
                    } else {
                        data.set(root, value);
                        return;
                    }
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * @return El valor de la raiz actual en el Vector
     */
    @Override
    public E peek() {
        return data.get(0);
    }

    /**
     * @return True si el Vector esta vacio
     */
    @Override
    public boolean isEmpty() {
        return (data.size() == 0) ? true : false;
    }

    /**
     * @return El tamaño del Vector
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Vacia el Vector
     */
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
    
    /**
     * Método no definido
     */
    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean offer(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método no definido
     */
    @Override
    public E element() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método no definido
     */
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método no definido
     */
    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método no definido
     */
    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método no definido
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }
}