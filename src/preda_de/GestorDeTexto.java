/**
 * @author	Augusto Javier Ibañez Garcia
 * 	 email: aibanez122@alumno.uned.es
 * 	 DNI:   25.404.287M
 * @version 1.0 => X7 Noviembre 2018  ///  1.0 => X7 Noviembre 2018
 *
 */

package preda_de;

import java.util.List;

public class GestorDeTexto {

	public static String imprimeInfoInicial(int[] vectorA, int mNumeroElementos, int cSumaElementos) {
		return (
				"Programa que sirve para calcular los subconjuntos de una suma dada.\n"
						+ "SINTAXIS:\n"
						+ "suma [-t][-h][fichero_entrada][fichero_salida]\n"
						+ "  -t               Traza la selección de subconjuntos\n"
						+ "  -h               Muestra esta ayuda\n"
						+ "  fichero_entrada  Nombre del fichero de entrada\n"
						+ "  fichero_salida   Nombre del fichero de salida"
				);
	}

	public static String convertirArrayEnterosEnListaEnteros(List<Integer> subconjSoluciones) {
		String textoEnLista = "";
		for (Integer linea : subconjSoluciones)
			textoEnLista += (linea.toString() + " ");
		return textoEnLista;
	}

	public static void imprimeMensajeAyuda() {
		System.out.println(
				"Programa que sirve para calcular los subconjuntos de una suma dada.\n"
						+ "SINTAXIS:\n"
						+ "suma [-t][-h][fichero_entrada][fichero_salida]\n"
						+ "  -t               Traza la selección de subconjuntos\n"
						+ "  -h               Muestra esta ayuda\n"
						+ "  fichero_entrada  Nombre del fichero de entrada\n"
						+ "  fichero_salida   Nombre del fichero de salida"
				);
	}

	public static void enviarTextoA_Pantalla_O_Fichero(String texto) {
		if (InicialGestorParametrosDE.hayFicheroSalida) {
			ManejadorDeFichero.EscribeFichero(InicialGestorParametrosDE.ficheroSalida, texto);
		}
		else {
			System.out.println(texto);
		}
	}


}