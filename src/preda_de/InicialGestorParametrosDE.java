/**
 * @author	Augusto Javier Ibañez Garcia
 * 	 email: aibanez122@alumno.uned.es
 * 	 DNI:   25.404.287M
 * @version 2.0 => X7 Noviembre 2018  / 1.0 => 8 Octubre 2018
 *
 */

package preda_de;

import preda_de.AlgoritmoProgrDinamica;
import preda_de.ManejadorDeFichero;

public class InicialGestorParametrosDE {	
	static boolean esTrazaActiva;
	static boolean esAyudaActiva;
	static boolean hayFicheroEntrada = false;
	static boolean hayFicheroSalida = false;
	static String ficheroEntrada = null;
	public static String ficheroSalida = null; 
	static String parametroUltimo;
	static String parametroPenultimo;
	static int resultado = 0;

	static ManejadorDeFichero manejoFicheros = new ManejadorDeFichero();
	static AlgoritmoProgrDinamica ProgrDinamica = new AlgoritmoProgrDinamica();

	public static void main(String[] args) {
		asignarParametros(args);
		if (esAyudaActiva)
			GestorDeTexto.imprimeMensajeAyuda();
		else
			gestionarLlamadaInicial();
	}

	static void asignarParametros(String[] args) {
		esTrazaActiva = false;
		esAyudaActiva = false;
		parametroUltimo = null;
		parametroPenultimo = null;
		int numeroParametrosSiAyudaOTraza = 0;
		int numeroRealParametros = args.length;
		int numeroParametrosSinAyudaNiTraza = 0;

		try{
			if (numeroRealParametros != 0) {
				asignaParametrosUltimoYPenultimo(args, numeroRealParametros);
				numeroParametrosSiAyudaOTraza = cuentaSiAyuda_y_o_Traza(args, numeroRealParametros);
			}
			numeroParametrosSinAyudaNiTraza = numeroRealParametros - numeroParametrosSiAyudaOTraza;
			asignaParametrosFicherosES(numeroParametrosSinAyudaNiTraza);
		}
		catch (Exception ex){
			esAyudaActiva = false;
			esTrazaActiva = false;
		}
	}

	private static void asignaParametrosUltimoYPenultimo(String[] args, int numeroRealParametros) {
		parametroUltimo = args[numeroRealParametros - 1];
		if (numeroRealParametros > 1) 
			parametroPenultimo = args[numeroRealParametros - 2];
	}

	public static int cuentaSiAyuda_y_o_Traza(String[] args, int numeroRealParametros) {
		int cuentaParametros = 0;
		for (int i=0; i<= numeroRealParametros - 1 ;i++) {
			if (args[i].equals("-h")) {
				cuentaParametros++;
				esAyudaActiva = true;
			}
			if (args[i].equals("-t")) {						
				cuentaParametros++;
				esTrazaActiva = true;
			}
		}
		return cuentaParametros;
	}

	private static void asignaParametrosFicherosES(int numeroParametrosSinAyudaNiTraza) {
		boolean paramUltimoNoEsTrazaNiEsAyuda = !(parametroUltimo.equals("-t")) && !(parametroUltimo.equals("-h"));
		if (numeroParametrosSinAyudaNiTraza ==  2) {	
			if (paramUltimoNoEsTrazaNiEsAyuda ) {
				hayFicheroSalida = true;
				ficheroSalida = parametroUltimo;
				ManejadorDeFichero.inicializarFicheroSalida(ficheroSalida);
			}
			boolean paramPenultimoNoEsTrazaNiEsAyuda = !(parametroPenultimo.equals("-t")) && !(parametroPenultimo.equals("-h"));
			if (paramPenultimoNoEsTrazaNiEsAyuda ) {
				hayFicheroEntrada = true;
				ficheroEntrada = parametroPenultimo;
			}
		}
		else {
			if (paramUltimoNoEsTrazaNiEsAyuda ) {
				hayFicheroEntrada = true;
				ficheroEntrada = parametroUltimo;
			}				
		}
		ManejadorDeFichero.hayFicheroSalida = hayFicheroSalida;
		ManejadorDeFichero.ficheroSalida	= ficheroSalida;
	}

	private static void gestionarLlamadaInicial() {
		try {
			hacerLlamadaAlgoritmoProgrDinam();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(-1);
		}
	}

	private static void hacerLlamadaAlgoritmoProgrDinam() {
		if (hayFicheroEntrada) {
			ManejadorDeFichero.LeeFichero(ficheroEntrada);
			char[] entrada = ManejadorDeFichero.getCadenaOrigen().toCharArray();
			char[] salida  = ManejadorDeFichero.getCadenaDestino().toCharArray();			
			AlgoritmoProgrDinamica distanciaEdicionProgrDinam = new AlgoritmoProgrDinamica();
			resultado = distanciaEdicionProgrDinam.distanciaEdicionProgDinamica(entrada, salida);
		}
		else {
			// TODO manejarlo por pantalla
			// pedir datos por pantalla y meterlos en "entrada"
			// "salida" por pantalla/fichSalida 
			System.out.println("DATOS ENTRADA");
			manejoFicheros.leeEstandarEntrada(esTrazaActiva);
			char[] entrada = ManejadorDeFichero.getCadenaOrigen().toCharArray();
			char[] salida  = ManejadorDeFichero.getCadenaDestino().toCharArray();			
			AlgoritmoProgrDinamica distanciaEdicionProgrDinam = new AlgoritmoProgrDinamica();
			resultado = distanciaEdicionProgrDinam.distanciaEdicionProgDinamica(entrada, salida);
		}
		
	}

}