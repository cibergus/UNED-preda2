/**
 * @author	Augusto Javier Ibañez Garcia
 * 	 email: aibanez122@alumno.uned.es
 * 	 DNI:   25.404.287M
 * @version 1.8 => D18 Noviembre 2018  / 1.0 => 8 Octubre 2018
 *
 */

package preda_de;

import java.util.Stack;

public class AlgoritmoProgrDinamica {
    private final String textoBorrar = "b";
    private final String textoInsertar = "i";
    private final String textoSustituir = "s";

    public int distanciaEdicionProgDinamica(char[] cadenaInicial, char[] cadenaFinal){
        String infoInicial = imprimeInfoInicial(String.valueOf(cadenaInicial), String.valueOf(cadenaFinal));
        enviarTextoA_Pantalla_O_Fichero(infoInicial);
        int[][] matrizResolucion = crearMatrizResolucion(cadenaInicial, cadenaFinal);
        int valorDistanciaEdicion = matrizResolucion[cadenaInicial.length][cadenaFinal.length];
        enviarTextoA_Pantalla_O_Fichero(String.valueOf(valorDistanciaEdicion));
        Stack rutaObtenida = rutaASeguirSegunMatrizResolucion(matrizResolucion);
        sacarLineas(rutaObtenida, cadenaInicial, cadenaFinal);
        return valorDistanciaEdicion;
    }

    private void enviarTextoA_Pantalla_O_Fichero(String texto) {
        if (Edicion.hayFicheroSalida)
            GestorDeFichero.EscribeFichero(Edicion.ficheroSalida, texto);
        else
            System.out.println(texto);
    }

    private String imprimeInfoInicial(String cadenaInicial, String cadenaFinal) {
        return ("Hay que convertir "
                + cadenaInicial
                + " --> "
                + cadenaFinal);
    }

    Stack<String> rutaASeguirSegunMatrizResolucion(int[][] matrizResolucion) {
        Stack<String> pilaChequeo = new Stack<>();
        int[][]test = {{0}};
        boolean isMatrizResolucionVacia = isMatrizResolucionVacia(matrizResolucion, test);
        boolean matrizResolucionBorrar;
        boolean matrizResolucionInsertar;
        boolean matrizResolucionSustituir;
        String espacio = " ";
        if (isMatrizResolucionVacia) {
            return pilaChequeo;
        }
        int fila_I = matrizResolucion.length - 1;
        int colu_F = matrizResolucion[0].length - 1;
        int i = Math.max(fila_I, colu_F);
        while (fila_I != 0 && colu_F != 0) {
            matrizResolucionBorrar    = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1] [colu_F]     + 1);
            matrizResolucionInsertar  = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I]     [colu_F - 1] + 1);
            matrizResolucionSustituir = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1] [colu_F - 1] + 1);
            if (matrizResolucionBorrar) {
                pilaChequeo.push(textoBorrar + espacio + i--);
                fila_I--;
            } else if (matrizResolucionInsertar) {
                pilaChequeo.push(textoInsertar + espacio + i--);
                colu_F--;
            } else if (matrizResolucionSustituir) {
                pilaChequeo.push(textoSustituir + espacio + i--);
                fila_I--;
                colu_F--;
            } else {
                i--;
                fila_I--;
                colu_F--;
            }
        }
        do {
            int posicion = 1;
            while (fila_I > 0) {
                pilaChequeo.push(textoBorrar + espacio + posicion);
                fila_I--;
            }
            while (colu_F > 0) {
                pilaChequeo.push(textoInsertar + espacio + posicion);
                colu_F--;
            }
            return pilaChequeo;
        } while (fila_I == 0 | colu_F == 0);
    }

    private boolean isMatrizResolucionVacia(int[][] matrizResolucion, int[][] test) {
        boolean isMatrizResolucionVacia = false;
        if (matrizResolucion.length == test.length && matrizResolucion[0].length == test[0].length)
            for(int fila=0; fila < matrizResolucion.length; fila++)
                for(int colum=0; colum < matrizResolucion[0].length; colum++) {
                    if (matrizResolucion[fila][colum] == test[fila][colum])
                        isMatrizResolucionVacia = true;
                }
        return isMatrizResolucionVacia;
    }

    int[][] crearMatrizResolucion(char[] cadenaInicial, char[] cadenaFinal) {
        int matrizResolucion[][] = new int[cadenaInicial.length+1][cadenaFinal.length+1];

        for(int fila=0; fila < matrizResolucion.length; fila++)
            matrizResolucion[fila][0] = fila;
        for(int colum=0; colum < matrizResolucion[0].length; colum++)
            matrizResolucion[0][colum] = colum;
        for(int fila=1; fila <= cadenaInicial.length; fila++)
            for (int colum = 1; colum <= cadenaFinal.length; colum++)
                if (cadenaInicial[fila - 1] == cadenaFinal[colum - 1])
                    matrizResolucion[fila][colum] = matrizResolucion[fila - 1][colum - 1];
                else
                    matrizResolucion[fila][colum] = 1 + minimoDe3(matrizResolucion[fila - 1][colum - 1], matrizResolucion[fila - 1][colum], matrizResolucion[fila][colum - 1]);
        return matrizResolucion;
    }

    private int minimoDe3(int celda1, int celda2, int celda3){
        return Math.min(Math.min(celda1, celda2), celda3);
    }

    private void sacarLineas(Stack <String> pilaChequeo, char[] cadenaInicial, char[] cadenaFinal) {
        int gusLongitudCadenaFinal = Math.max(cadenaInicial.length, cadenaFinal.length);
        char[] gusVectorCadenaCambiante = new char[gusLongitudCadenaFinal];
        for (int i=0;i < gusVectorCadenaCambiante.length;i++)
            gusVectorCadenaCambiante[i] = ' ';
        System.arraycopy(cadenaInicial, 0, gusVectorCadenaCambiante, 0, cadenaInicial.length);
        while (!pilaChequeo.isEmpty()) {
            String[] linea = pilaChequeo.pop().split(" ");
            String linea_accion = linea[0];
            String linea_numeroEnTexto = linea[1];
            int linea_numero = Integer.valueOf(linea_numeroEnTexto);
            char[] sourceArray;
            int startingPositionSourceArray;
            char[] targetArray;
            int startingPositionTargetArray;
            int numeroElementosACopiar;

            switch (linea_accion) {
                case textoBorrar:
                    sourceArray = gusVectorCadenaCambiante;
                    startingPositionSourceArray = linea_numero;
                    targetArray = gusVectorCadenaCambiante;
                    startingPositionTargetArray = linea_numero - 1;
                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numero;
                    System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
                    gusVectorCadenaCambiante[gusVectorCadenaCambiante.length - 1] = ' ';
                    System.out.println(
                            "borrar "
                                    + linea_numeroEnTexto + " "
                                    + String.valueOf(gusVectorCadenaCambiante));
                    break;
                case textoInsertar :
                    sourceArray = gusVectorCadenaCambiante;
                    startingPositionSourceArray = linea_numero - 1;
                    targetArray = gusVectorCadenaCambiante;
                    startingPositionTargetArray = linea_numero ;
                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numero;
                    if (linea_numero == gusVectorCadenaCambiante.length)
                        gusVectorCadenaCambiante[linea_numero - 1] = cadenaFinal[linea_numero - 1];
                    else {
                        System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
                        gusVectorCadenaCambiante[linea_numero - 1] = cadenaFinal[linea_numero - 1];
                    }
                    System.out.println(
                            "insertar "
                                    + linea_numeroEnTexto + " "
                                    + String.valueOf(gusVectorCadenaCambiante));
                    break;
                case textoSustituir:
                    gusVectorCadenaCambiante[linea_numero - 1] = cadenaFinal[linea_numero - 1];
                    System.out.println(
                            "sustituir "
                            + linea_numeroEnTexto + " "
                            + String.valueOf(gusVectorCadenaCambiante));
            }
        }
    }

//    public void impresorLineaSustituir(Stack <String> pilaCaminoSoluciones, int fila, int colum, char[] cadenaTemporal, char[] cadenaInicial) {
//        cadenaTemporal[colum-1] = cadenaInicial[fila-1];
//        textoLinea = "sustituir " + " " + fila + " " + cadenaDespues;
//        pilaCaminoSoluciones.push(textoLinea);
//    }
//
//    public void impresorLineaInsertar(Stack <String> pilaCaminoSoluciones, int fila, int colum) {
//        char[] cadenaDelante = cadenaDespues.substring(0, colum-1).toCharArray();
//        char[] cadenaDetras  = cadenaDespues.substring(colum).toCharArray();
//        char[] cadenaTemporal = combine(cadenaDelante, cadenaDetras);
//
//        if (cadenaDelante != null )
//            textoLinea = "insertar  " + " " + fila + " " + cadenaDespues +
//                    " cadenaDelante=" + String.valueOf(cadenaDelante) +
//                    " cadenaDetras =" + String.valueOf(cadenaDetras) +
//                    " cadenaTemporal=" + String.valueOf(cadenaTemporal) ;
//        else
//            textoLinea = "insertar  " + " " + fila + " " +  cadenaDetras ;
//        pilaCaminoSoluciones.push(textoLinea);
//    }
//
//    public void impresorLineaBorrar(Stack <String> pilaCaminoSoluciones, int fila, int colum, char[] cadenaInicial) {
//        char[] cadenaDelante = cadenaDespues.substring(0, colum).toCharArray();
//        char[] cadenaDetras  = cadenaDespues.substring(colum).toCharArray();
//        char[] nuevaCadenaDelante = vectorAgregarUnElemento(cadenaDelante, cadenaInicial[fila-1]);
//        char[] cadenaTemporal = combine(nuevaCadenaDelante, cadenaDetras);
//        textoLinea = "borrar    " + " " + fila + " " + cadenaDespues;
//        pilaCaminoSoluciones.push(textoLinea);
//    }
//
//    public char[] vectorAgregarUnElemento(char[] cadenaDelante, char c) {
//        int length = cadenaDelante.length + 1;
//        char[] result = new char[length];
//        System.arraycopy(cadenaDelante, 0, result, 0, cadenaDelante.length);
//        result[length-1] = c;
//        return result;
//    }
//
//    private String convertirVectorToString(char[] cadenaFinal) {
//        String temp = "";
//        for (int i = 0; i < cadenaFinal.length; i++) {
//            temp += cadenaFinal[i];
//        }
//        return temp;
//    }
//
//    public static char[] combine(char[] cadenaDelante, char[] cadenaDetras){
//        int length = cadenaDelante.length + cadenaDetras.length;
//        char[] result = new char[length];
//        System.arraycopy(cadenaDelante, 0, result, 0, cadenaDelante.length);
//        System.arraycopy(cadenaDetras, 0, result, cadenaDelante.length, cadenaDetras.length);
//        return result;
//    }

}