/**
 * @author Julio Herrera
 */
import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.Test;

public class PriorityQueueFactoryTest {

	/**
     * Con esta prueba verificaremos que jUnit este funcionando
     */
    @Test
    public void pruebaJUnit() {
        assertTrue(true);
    }
    
    @Test
    public void getPriorityQueueTest1() {
    	PriorityQueueFactory<Patient> pqf = new PriorityQueueFactory<>();
    	Queue<Patient> result = pqf.getPriorityQueue(1);
    	assertEquals(result.getClass().getName(), "VectorHeap");
    }
    
    @Test
    public void getPriorityQueueTest2() {
    	PriorityQueueFactory<Patient> pqf = new PriorityQueueFactory<>();
    	Queue<Patient> result = pqf.getPriorityQueue(2);
    	assertEquals(result.getClass().getName(), "java.util.PriorityQueue");
    }
}
