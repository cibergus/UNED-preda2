/*
  @author    cibergus
  @version 3.1 => M13 Noviembre 2018  / 1.0 => D8 Octubre 2018

 */

package preda_de;

import static preda_de.GestorDeTexto.imprimeMensajeAyuda;

class Edicion {
	static boolean esTrazaActiva;
	static boolean esAyudaActiva;
	private static boolean hayFicheroEntrada;
	private static String ficheroEntrada;
	static boolean hayFicheroSalida;
	static String  ficheroSalida;
    static String parametroUltimo;
	static String parametroPenultimo;
    private static int resultado;


    static {
        resultado = 0;
        ficheroEntrada = null;
        hayFicheroEntrada = false;
    }

    private static final AlgoritmoProgrDinamica ProgrDinamica = new AlgoritmoProgrDinamica();

    public static void main(String[] args) {
		asignarParametros(args);
		if (esAyudaActiva)
            imprimeMensajeAyuda();
		else
			gestionarLlamadaInicial();
	}

	static void asignarParametros(String[] args) {
		esTrazaActiva = false;
		esAyudaActiva = false;
		parametroUltimo = null;
		parametroPenultimo = null;
        int numeroRealParametros = args.length;
		int numeroParametrosSinAyudaNiTraza;

		try{
            int numeroParametrosSiAyudaOTraza = 0;
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

	private static int cuentaSiAyuda_y_o_Traza(String[] args, int numeroRealParametros) {
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
		if (hayFicheroEntrada)
            GestorDeFichero.LeeFichero(ficheroEntrada);
		else
            GestorDeFichero.leeEstandarEntrada();
		char[] entrada = GestorDeFichero.getCadenaOrigen().toCharArray();
		char[] salida  = GestorDeFichero.getCadenaDestino().toCharArray();
		resultado = ProgrDinamica.distanciaEdicionProgDinamica(entrada, salida);
        System.out.println(resultado);
	}
}
