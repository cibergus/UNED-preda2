/**
 * @author	Augusto Javier Ibañez Garcia
 * 	 email: aibanez122@alumno.uned.es
 * 	 DNI:   25.404.287M
 * @version 2.0 => 12 Octubre 2018  ///  1.0 => 7 Octubre 2018
 *
 */

package preda_de;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ManejadorDeFichero {
	public static boolean hayFicheroSalida;
	public static boolean hayFichero;
	public static String  ficheroSalida;
	private static String cadenaOrigen;
	private static String cadenaDestino;
	private static Scanner scanner;
	static String lineaLeida;

	
	public ManejadorDeFichero() {
		setCadenaOrigen("");
		setCadenaDestino("");
	}

	public static String getCadenaOrigen() {
		return cadenaOrigen;
	}

	public static String getCadenaDestino() {
		return cadenaDestino;
	}

	//	@SuppressWarnings("static-access")
	public static void setCadenaOrigen(String cadenaOrigen) {
		ManejadorDeFichero.cadenaOrigen = cadenaOrigen;
	}

	//	@SuppressWarnings("static-access")
	public static void setCadenaDestino(String cadenaDestino) {
		ManejadorDeFichero.cadenaDestino = cadenaDestino;
	}

	public static void LeeFichero(String ficheroEntrada) {
		try {
			FileReader fr = new FileReader(ficheroEntrada);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				if (!linea.equals("")) {
					setCadenaOrigen(linea);
					linea = br.readLine();
					setCadenaDestino(linea);
				}
			}
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.out.println("Error de entrada de datos");
		}
	}

	public static void inicializarFicheroSalida(String ficheroSalida) {
		File nuevoFichero = new File(ficheroSalida);

		nuevoFichero.delete();
		try {
			nuevoFichero.createNewFile();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void EscribeFichero(String ficheroSalida, String resultado) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		//Código sencillo de escritura en fichero del resultado de la solución del laberinto
		try {
			fichero = new FileWriter(ficheroSalida, true);
			pw = new PrintWriter(fichero);
			pw.println("\r\n");
			pw.println("La solución es: \r\n" + resultado + "\r\n");
			pw.println(formatoFechaHora.format(date) + "\r\n");
			pw.println("Fin\r\n" );
			pw.println("\r\n");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	public static void leeEstandarEntrada(boolean esTrazaActiva) {
		try {
			leeEstandarEntradaSimple();
		} 
		catch (Exception excepcion) {
			System.out.println("Error leyendo fichero " + ": " + excepcion);
		}
	}

	public static void leeEstandarEntradaSimple() {
		scanner = new Scanner(System.in);
		pedirPorConsolaCadenaOrigen();
		pedirPorConsolaCadenaDestino();
	}

	private static void pedirPorConsolaCadenaOrigen() {
		System.out.println("Dame la palabra de partida y pulsa ENTER:");
		lineaLeida = scanner.nextLine();	
		setCadenaOrigen(lineaLeida);
	}
	
	private static void pedirPorConsolaCadenaDestino() {
		System.out.println("Dame la palabra a llegar y pulsa ENTER:");
		lineaLeida = scanner.nextLine();	
		setCadenaDestino(lineaLeida);		
	}


}