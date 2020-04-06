/**
 * @author Julio Herrera
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class VectorHeapTest {

	/**
     * Con esta prueba verificaremos que jUnit este funcionando
     */
    @Test
    public void pruebaJUnit() {
        assertTrue(true);
    }
    
    @Test
    public void addTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	vh.add("D");
    	vh.add("A");
    	vh.add("E");
    	vh.add("C");
    	assertEquals(vh.size(), 5);
    }
    
    @Test
    public void sizeTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	vh.add("D");
    	vh.add("A");
    	vh.add("E");
    	vh.add("C");
    	assertEquals(vh.size(), 5);
    }
    
    @Test
    public void pollTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	vh.add("D");
    	vh.add("A");
    	vh.add("E");
    	vh.add("C");
    	String deleted = vh.poll();
    	assertEquals(deleted, "A");
    }
    
    @Test
    public void peekTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	vh.add("D");
    	vh.add("A");
    	vh.add("E");
    	vh.add("C");
    	String root = vh.peek();
    	assertEquals(root, "A");
    }
    
    @Test
    public void isEmptyTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	assertFalse(vh.isEmpty());
    }
    
    @Test
    public void clearTest() {
    	VectorHeap<String> vh = new VectorHeap<>(true);
    	vh.add("B");
    	vh.add("D");
    	vh.add("A");
    	vh.add("E");
    	vh.add("C");
    	vh.clear();
    	assertTrue(vh.isEmpty());
    }

}
