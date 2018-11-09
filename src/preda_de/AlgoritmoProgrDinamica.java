/**
 * @author	Augusto Javier Ibañez Garcia
 * 	 email: aibanez122@alumno.uned.es
 * 	 DNI:   25.404.287M
 * @version 1.5 => X7 Noviembre 2018  / 1.0 => 8 Octubre 2018
 *
 */

package preda_de;

import java.util.Stack;


public class AlgoritmoProgrDinamica {

	private String textoLinea;
	private String cadenaDespues;

	public int distanciaEdicionProgDinamica(char[] cadenaInicial, char[] cadenaFinal){
		int[][] matrizResolucion = crearMatrizResolucion(cadenaInicial, cadenaFinal);

		imprimirCamino(cadenaInicial, cadenaFinal, matrizResolucion);
		int valorDistanciaEdicion = matrizResolucion[cadenaInicial.length][cadenaFinal.length];
		return valorDistanciaEdicion;
	}

	private int[][] crearMatrizResolucion(char[] cadenaInicial, char[] cadenaFinal) {
		int matrizResolucion[][] = new int[cadenaInicial.length+1][cadenaFinal.length+1];   

		for(int fila=0; fila < matrizResolucion.length; fila++) { 
			matrizResolucion[fila][0] = fila; 
		}

		for(int colum=0; colum < matrizResolucion[0].length; colum++) { 
			matrizResolucion[0][colum] = colum;
		}

		for(int fila=1; fila <= cadenaInicial.length; fila++){
			for(int colum=1; colum <= cadenaFinal.length; colum++){
				if(cadenaInicial[fila-1] == cadenaFinal[colum-1]){
					matrizResolucion[fila][colum] = matrizResolucion[fila-1][colum-1];
				}else{
					matrizResolucion[fila][colum] = 1 + minimoDe3(matrizResolucion[fila-1][colum-1], matrizResolucion[fila-1][colum], matrizResolucion[fila][colum-1]);
				}
			}
		}
		return matrizResolucion;
	}

	private int minimoDe3(int celda1, int celda2, int celda3){
		return Math.min(Math.min(celda1, celda2), celda3);
	}

	private void imprimirCamino(char[] cadenaInicial, char[] cadenaFinal, int matrizResolucion[][]) {
		int fila = matrizResolucion.length - 1;
		int colum = matrizResolucion[0].length - 1;
		System.out.println("Conversión de la cadenas: " + String.valueOf(cadenaInicial) + " --> " + String.valueOf(cadenaFinal));
		int numeroDistanciaMinima = matrizResolucion[fila][colum];
		System.out.println(numeroDistanciaMinima);
		Stack<String> pilaCaminoSoluciones = new Stack<String>();
		char[] cadenaTemporal;
		cadenaTemporal = cadenaFinal.clone();
		while(true) {
			cadenaDespues = convertirVectorToString(cadenaTemporal);
			if (fila == 0 || colum == 0) {
				while( fila > 0 ) {
					cadenaTemporal = impresorLineaBorrar(cadenaTemporal, fila, colum, pilaCaminoSoluciones, cadenaInicial);
					fila--;
				}
				while ( colum > 0 ) {
					cadenaTemporal = impresorLineaInsertar(cadenaTemporal, fila, colum, pilaCaminoSoluciones);
					colum--;	
				}
				break;
			}
			if (cadenaInicial[fila - 1] == cadenaFinal[colum - 1]) {
				fila--;
				colum--;
			} else { 
				
				if (matrizResolucion[fila][colum] == matrizResolucion[fila-1][colum-1] + 1){
					impresorLineaSustituir(cadenaTemporal, fila, colum, pilaCaminoSoluciones, cadenaInicial);
					fila--;
					colum--;
				} else if (matrizResolucion[fila][colum] == matrizResolucion[fila-1][colum] + 1) {
					cadenaTemporal = impresorLineaBorrar(cadenaTemporal, fila, colum, pilaCaminoSoluciones, cadenaInicial);
					fila--;
				} else if (matrizResolucion[fila][colum] == matrizResolucion[fila][colum-1] + 1){
					cadenaTemporal = impresorLineaInsertar(cadenaTemporal, fila, colum, pilaCaminoSoluciones);
					colum--;
				} else {
					throw new IllegalArgumentException("Datos incorrectos");
				}  
			}
		}
		while (!pilaCaminoSoluciones.isEmpty()) { 
			System.out.println(pilaCaminoSoluciones.pop());
		}
	}

	public void impresorLineaSustituir(char[] cadenaTemporal, int fila, int colum, Stack<String> pilaCaminoSoluciones, char[] cadenaInicial) {
		cadenaTemporal[colum-1] = cadenaInicial[fila-1];
		textoLinea = "sustituir " + " " + fila + " " + cadenaDespues;
		pilaCaminoSoluciones.push(textoLinea);
	}

	public char[] impresorLineaInsertar(char[] cadenaTemporal, int fila, int colum, Stack<String> pilaCaminoSoluciones) {
		char[] cadenaDelante = cadenaDespues.substring(0, colum-1).toCharArray();
		char[] cadenaDetras  = cadenaDespues.substring(colum, cadenaDespues.length()).toCharArray();
		cadenaTemporal = combine(cadenaDelante, cadenaDetras);						
		textoLinea = "insertar  " + " " + fila + " " + cadenaDespues;
		pilaCaminoSoluciones.push(textoLinea);
		return cadenaTemporal;
	}

	public char[] impresorLineaBorrar(char[] cadenaTemporal, int fila, int colum, Stack<String> pilaCaminoSoluciones, char[] cadenaInicial) {
		char[] cadenaDelante = cadenaDespues.substring(0, colum).toCharArray();
		char[] cadenaDetras  = cadenaDespues.substring(colum, cadenaDespues.length()).toCharArray();
		char[] nuevaCadenaDelante = vectorAgregarUnElemento(cadenaDelante, cadenaInicial[fila-1]);		
		cadenaTemporal = combine(nuevaCadenaDelante, cadenaDetras);					
		textoLinea = "borrar    " + " " + fila + " " + cadenaDespues;
		pilaCaminoSoluciones.push(textoLinea);
		return cadenaTemporal;
	}

	public char[] vectorAgregarUnElemento(char[] cadenaDelante, char c) {
		int length = cadenaDelante.length + 1;
		char[] result = new char[length];
		System.arraycopy(cadenaDelante, 0, result, 0, cadenaDelante.length);
		result[length-1] = c;
		return result;
	}

	private String convertirVectorToString(char[] cadenaFinal) {
		String temp = "";
		for (int i = 0; i < cadenaFinal.length; i++) {
			temp += cadenaFinal[i];
		}
		return temp;
	}	

	public static char[] combine(char[] cadenaDelante, char[] cadenaDetras){
		int length = cadenaDelante.length + cadenaDetras.length;
		char[] result = new char[length];
		System.arraycopy(cadenaDelante, 0, result, 0, cadenaDelante.length);
		System.arraycopy(cadenaDetras, 0, result, cadenaDelante.length, cadenaDetras.length);
		return result;
	}

}