/**
 * UVG - ADT - HT8
 * 
 * Clase que representa la ficha de un paciente y que se puede comparar por
 * el tipo de prioridad que tiene y el orden de agregado.
 * 
 * @author Julio Herrera
 */
public class Patient implements Comparable<Patient> {

    private String priority;
    private String symptom;
    private String name;
    private Integer id; // Se agrega el id para mejor comparacion de pacientes

    public Patient(String priority, String symptom, String name, Integer id) {
        this.priority = priority;
        this.symptom = symptom;
        this.name = name;
        this.id = id;
    }

    /**
     * La comparacion se realiza por medio de la prioridad pero, si la 
     * prioridad es la misma, se compara el id, es decir, quien se agrego
     * primero a la cola, en este punto no tendrian que poder ser iguales
     * @param patient Un paciente
     * @return -1 si es menor, 1 si es mayor
     */
    @Override
    public int compareTo(Patient patient) {
        if (priority.compareTo(patient.getPriority()) < 0) {
            return -1;
        } else if (priority.compareTo(patient.getPriority()) > 0) {
            return 1;
        } else {
            return id.compareTo(patient.getId());
        }
    }

    /**
     * @return Solo el primer caracter de la prioridad (A,B,C,D,E)
     */
    public String getPriority() {
        return priority.substring(0, 1);
    }

    public String getSymptom() {
        return symptom;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return name + " - " + symptom + " - " + priority.substring(0, 1) + ".\n";
    }

}