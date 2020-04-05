public class Patient implements Comparable<Patient> {

    protected String priority;
    private String symptom;
    private String name;

    public Patient(String priority, String symptom, String name) {
        this.priority = priority;
        this.symptom = symptom;
        this.name = name;
    }

    @Override
    public int compareTo(Patient patient) {
        return priority.compareTo(patient.priority);
    }

    public String getPriority() {
        return priority.substring(0, 1);
    }

    public String getSymptom() {
        return symptom;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " - " + symptom + " - " + priority.substring(0, 1) + ".\n";
    }

}