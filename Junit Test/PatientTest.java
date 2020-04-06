/**
 * @author Julio Herrera
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class PatientTest {

	/**
     * Con esta prueba verificaremos que jUnit este funcionando
     */
    @Test
    public void pruebaJUnit() {
        assertTrue(true);
    }
    
    @Test
    public void compareToTest1() {
    	Patient patient = new Patient("A","...", "Andres", 1);
    	Patient patient2 = new Patient("B","...", "Jose", 2);
    	assertEquals(-1, patient.compareTo(patient2));
    }
    
    @Test
    public void compareToTest2() {
    	Patient patient = new Patient("C","...", "Andres", 1);
    	Patient patient2 = new Patient("B","...", "Jose", 2);
    	assertEquals(1, patient.compareTo(patient2));
    }
    
    @Test
    public void compareToTest3() {
    	Patient patient = new Patient("A","...", "Andres", 1);
    	Patient patient2 = new Patient("A","...", "Jose", 2);
    	assertEquals(-1, patient.compareTo(patient2));
    }
    
    @Test
    public void compareToTest4() {
    	Patient patient = new Patient("A","...", "Andres", 3);
    	Patient patient2 = new Patient("A","...", "Jose", 2);
    	assertEquals(1, patient.compareTo(patient2));
    }

}
