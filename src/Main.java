/**
 * 
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Hoja de trabajo 8
 * 03/04/2020
 * 
 * Hoja de Trabajo 8 Algoritmos y Estructuras de Datos. Implementación de Priority Queue con Heaps
 * 
 * Programa para atención de pacientes con prioridad de emergencia
 * 
 * @author Julio Herrera 19402
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	/**
	 * 
	 * Este método es utilizado para leer el archivo datos.txt. La lectura se
	 * realiza para todas las líneas del archivo y separa cada una que tenga el
	 * archivo para agregarla al Array de Strings que devolvera.
	 * 
     * @param fileName nombre del archivo que se leera
	 * @return una lista de todas las lineas del archivo separadas
	 * @throws Exception excepción general para la lectura del archivo
	 */
	public static ArrayList<String> textReader(String fileName) throws Exception {
		final String bar = File.separator;
		final String dir = System.getProperty("user.dir");
		/**
		 * AQUI SE LEE EL ARCHIVO TXT si no corre se debe de reemplazar en el parentesis
		 * (dir + barra +"NOMBRE DEL FOLDER EN DONDE ESTA EL PROYECTO" +barra+
		 * "nombre.txt") El error del archivo de texto puede pasar si se corre el
		 * programa en eclipse y no en consola o tambien sucede al trabajar con paquetes
		 */
		final File file = new File(dir + bar + fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("No se encontro el archivo!");
		}
		FileReader fr;
		fr = new FileReader(file);
		final BufferedReader br = new BufferedReader(fr);
		ArrayList<String> lineList = new ArrayList<>(); //ya que solo se agrega al final
		String line = "";
		while ((line = br.readLine()) != null) {
			lineList.add(line);
		}
		br.close();
		return lineList;
	}

	public static void main(final String[] args) throws Exception {
		/**
		 * Menu de elección de implementación a usar
		 */
        Scanner scan = new Scanner(System.in);
        int pQueueType;
		boolean isCorrect = false;
        while(!isCorrect) {
            System.out.println("Ingrese la implementacion de Heap que desea usar:");
            System.out.println("1. VectorHeap");
            System.out.println("2. PriorityQueue de JCF.");
            try {
                pQueueType = Integer.valueOf(scan.nextLine());
                if (pQueueType > 0 && pQueueType < 3) {
                    isCorrect = true;
                }
            } catch(Exception e) {
                System.out.println("Ingrese un numero");
            }
        }
        isCorrect = false;
        /**
         * Menu de eleccion de archivo
         */
		String fileName = "";
		while (!isCorrect) {
            System.out.println("Escriba el nombre del archivo que va a leer");
            System.out.println("Si presiona solo enter se escoge por default ('pacientes.txt'): ");
			fileName = scan.nextLine();
			if (fileName.split(".").length < 1) {
                isCorrect = false;
                System.out.println("Indique la extension del archivo .txt");
            } else {
                isCorrect = true;
            }
		}
		if (fileName.equals("")) {
			fileName = "pacientes.txt";
		}
		/**
		 * Se lee el archivo de texto
		 */
        ArrayList<String> patientsList = textReader(fileName);
        /**
         * Se implementa el factory para saber que tipo de Priority usar
         */
        PriorityQueueFactory<Patient<String>> pQueueFactory = new PriorityQueueFactory<>();
        
		scan.close();
	}
}