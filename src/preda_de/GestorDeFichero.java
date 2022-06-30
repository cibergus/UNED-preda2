/*
  @author	cibergus
 * @version 2.0 => 12 Octubre 2018  ///  1.0 => 7 Octubre 2018
 */

package preda_de;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class GestorDeFichero {
    private static String cadenaOrigen;
	private static String cadenaDestino;
	private static Scanner scanner;
	private static String lineaLeida;


    static String getCadenaOrigen() {
        return cadenaOrigen;
	}

	static String getCadenaDestino() {
        return cadenaDestino;
	}

	private static void setCadenaOrigen(String cadenaOrigen) {
		GestorDeFichero.cadenaOrigen = cadenaOrigen;
	}

	private static void setCadenaDestino(String cadenaDestino) {
		GestorDeFichero.cadenaDestino = cadenaDestino;
	}

	static void LeeFichero(String ficheroEntrada) {
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
		} catch(Exception e) {
			System.out.println("Error de entrada de datos");
		}
	}

//	static void inicializarFicheroSalida(String ficheroSalida) {
//		File nuevoFichero = new File(ficheroSalida);
////		nuevoFichero.delete();
//		try {
//			final boolean isNuevoFichero = nuevoFichero.createNewFile();
//		}
//		catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}

	static void EscribeFichero(String ficheroSalida, String resultado) {
		FileWriter ficheroEscritura = null;
		PrintWriter impresionEscritura;

		try {
			ficheroEscritura   = new FileWriter(ficheroSalida, true);
			impresionEscritura = new PrintWriter(ficheroEscritura);
			impresionEscritura.println(resultado);
		}
		catch (Exception excepcion1) {
			excepcion1.printStackTrace();
		}
		finally {
			try {
				if (null != ficheroEscritura) ficheroEscritura.close();
			}
			catch (Exception excepcion2) {
				excepcion2.printStackTrace();
			}
		}
	}

//	static void EscribeFichero(String ficheroSalida, String resultado) {
//		FileWriter fichero = null;
//		PrintWriter pw;
//		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = new Date();
//
//		//Código sencillo de escritura en fichero del resultado de la solución del laberinto
//		try {
//			fichero = new FileWriter(ficheroSalida, true);
//			pw = new PrintWriter(fichero);
//			pw.println("\r\n" + "La solución es: \r\n" +
//                    resultado + "\r\n" +
//                    formatoFechaHora.format(date) + "\r\n" +
//                    "Fin\r\n\r\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (null != fichero)
//					fichero.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}

	static void leeEstandarEntrada() {
		try {
			leeEstandarEntradaSimple();
		} catch (Exception excepcion) {
			System.out.println("Error leyendo fichero " + ": " + excepcion);
		}
	}

	private static void leeEstandarEntradaSimple() {
        System.out.println("DATOS ENTRADA");
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
