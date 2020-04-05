
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
import java.util.PriorityQueue;
import java.util.Queue;

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
		ArrayList<String> lineList = new ArrayList<>(); // ya que solo se agrega al final
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
		int pQueueType = -1;
		boolean isCorrect = false;
		while (!isCorrect) {
			System.out.println("Ingrese la implementacion de Heap que desea usar:");
			System.out.println("1. VectorHeap");
			System.out.println("2. PriorityQueue de JCF.");
			try {
				pQueueType = Integer.valueOf(scan.nextLine());
				if (pQueueType > 0 && pQueueType < 3) {
					isCorrect = true;
				}
			} catch (Exception e) {
				System.out.println("Ingrese un numero valido");
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
		isCorrect = false;
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
		PriorityQueueFactory<Patient> pQueueFactory = new PriorityQueueFactory<>();
		/**
		 * Se obtiene el priority queue y se ingresan los datos
		 */
		Queue<Patient> pQueue = pQueueFactory.getPriorityQueue(pQueueType);
		int cont = 1;
		for (String patient : patientsList) {
			String[] separated = patient.split(",");
			String name = separated[0];
			name = (name.substring(0, 1).equals(" ")) ? name.substring(1) : name;
			String symptom = separated[1];
			symptom = (symptom.substring(0, 1).equals(" ")) ? symptom.substring(1) : symptom;
			String priority = separated[2].replaceAll(" ", "").toUpperCase() + cont;
			pQueue.add(new Patient(priority, symptom, name));
			cont++;
		}
		/**
		 * Se crea el ciclo con el menu y la logica de cada operacion para el pQueue
		 */
		int userOption = 0;
		while (userOption != 4) {
			Patient actualPatient = pQueue.peek();
			/**
			 * Show menu
			 */
			System.out.println("------------------ SISTEMA DE ATENCION DE PACIENTES ------------------");
			System.out.println("Toca atender al paciente " + actualPatient.getName() + " con "
					+ actualPatient.getSymptom() + " en prioridad " + actualPatient.getPriority() + ".");
			System.out.println("1. Atender al paciente.");
			System.out.println("2. Ver cola actual.");
			System.out.println("3. Agregar paciente.");
			try {
				userOption = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Ingrese un numero");
			}
			/**
			 * Acciones
			 */
			switch (userOption) {
				case 1:
					System.out.println("Se atendio al paciente " + actualPatient.getName() + " con "
						+ actualPatient.getSymptom() + " en prioridad " + actualPatient.getPriority() + ".");
					pQueue.poll();
				break;
				case 2:
					System.out.println(pQueue.toString());
				break;
				case 3:
					System.out.println("Ingrese el nombre del paciente");
					String name = scan.nextLine();
					System.out.println("Ingrese los sintomas del paciente");
					String symptom = scan.nextLine();
					System.out.println("Ingrese la prioridad del paciente (Solo las letras: A, B, C, D, E)");
					String priority = scan.nextLine();
					pQueue.add(new Patient(priority.substring(0, 1) + cont, symptom, name));
					cont++;
				break;
				case 4:
					System.out.println("Adios!");
				break;
				default:
					System.out.println("Elige una opcion valida");
				break;
			}
			System.out.println();
			if (pQueue.isEmpty()) {
				while (!isCorrect) {
					System.out.println("Ya no hay pacientes en la cola. ¿Desea agregar uno nuevo?");
					System.out.println("1. Si\n2. No");
					try {
						userOption = Integer.valueOf(scan.nextLine());
						isCorrect = true;
					} catch (Exception e) {
						System.out.println("Ingrese un numero");
					}
					switch (userOption) {
						case 1:
							System.out.println("Ingrese el nombre del paciente");
							String name = scan.nextLine();
							System.out.println("Ingrese los sintomas del paciente");
							String symptom = scan.nextLine();
							System.out.println("Ingrese la prioridad del paciente (Solo las letras: A, B, C, D, E)");
							String priority = scan.nextLine();
							pQueue.add(new Patient(priority.substring(0, 1) + cont, symptom, name));
							cont++;
						break;
						case 2:
							userOption = 4;
							System.out.println("Adios!");
						break;
						default:
							System.out.println("Elige una opcion valida");
						break;
					}
				}
				isCorrect = false;
			}
			System.out.println();
		}
		scan.close();
	}
}