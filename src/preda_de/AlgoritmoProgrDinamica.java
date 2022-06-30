/*
  @author	cibergus
 * @version 1.8 => D18 Noviembre 2018  / 1.0 => 8 Octubre 2018
 */

package preda_de;

import java.util.Stack;

class AlgoritmoProgrDinamica {
    private final String textoBorrar = "b";
    private final String textoInsertar = "i";
    private final String textoSustituir = "s";
    private final String textoNoTocar = "n";
    private int casillaATratar;

    int distanciaEdicionProgDinamica(char[] cadenaInicial, char[] cadenaFinal){
        String infoInicial = imprimeInfoInicial(String.valueOf(cadenaInicial), String.valueOf(cadenaFinal));
        enviarTextoA_Pantalla_O_Fichero(infoInicial);
        int[][] matrizResolucion = crearMatrizResolucion(cadenaInicial, cadenaFinal);
        int valorDistanciaEdicion = matrizResolucion[cadenaInicial.length][cadenaFinal.length];
        enviarTextoA_Pantalla_O_Fichero(String.valueOf(valorDistanciaEdicion));
        Stack<String> rutaObtenida = rutaASeguirSegunMatrizResolucion(matrizResolucion);
        sacarLineas(rutaObtenida, cadenaInicial, cadenaFinal);

//        Stack<String> rutaObtenidaSimple = rutaASeguirSegunMatrizResolucionSimple(matrizResolucion);
//        sacarLineasSimple(rutaObtenidaSimple, cadenaInicial, cadenaFinal);

        return valorDistanciaEdicion;
    }

//    private void sacarLineasSimple(Stack<String> pilaChequeo, char[] cadenaInicial, char[] cadenaFinal) {
//        int gusLongitudCadenaFinal = Math.max(cadenaInicial.length, cadenaFinal.length);
//        char[] gusVectorCadenaCambiante = new char[gusLongitudCadenaFinal];
////        for (int i=0;i < gusVectorCadenaCambiante.length;i++)
////            gusVectorCadenaCambiante[i] = ' ';
//        System.arraycopy(cadenaInicial, 0, gusVectorCadenaCambiante, 0, cadenaInicial.length);
////        int borrados = 0;
//
//        int celda = 0;
//        while (!pilaChequeo.isEmpty()) {
//            String linea = pilaChequeo.pop();
//
//            int linea_numeroOrigen = Integer.valueOf(linea);
//
//            char[] sourceArray;
//            int startingPositionSourceArray;
//            char[] targetArray;
//            int startingPositionTargetArray;
//            int numeroElementosACopiar;
////            int celda = 0;
//            boolean empiezaBorrando;
//
//            switch (linea) {
//                case textoNoTocar:
//                    empiezaBorrando = false;
//                    if (celda != 0)
//                      celda++;
//                    break;
//
//                case textoBorrar:
//                    sourceArray = gusVectorCadenaCambiante;
//                    startingPositionSourceArray = linea_numeroOrigen;
//                    targetArray = gusVectorCadenaCambiante;
//                    startingPositionTargetArray = linea_numeroOrigen - 1;
//                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numeroOrigen;
//                    System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
//                    gusVectorCadenaCambiante[gusVectorCadenaCambiante.length - 1] = ' ';
//                    if (celda == 0)
//                        empiezaBorrando = true;
//                    else empiezaBorrando = false;
//                   if (empiezaBorrando){
//                       System.out.println(
//                               "borrar "
//                                       + "1 "
//                                       + String.valueOf(gusVectorCadenaCambiante));
//                   }
//                   else {
//                       System.out.println(
//                               "borrar "
//                                       + celda + " "
//                                       + String.valueOf(gusVectorCadenaCambiante));
//                       linea_numeroOrigen--;
//                       celda++;
//                   }
//                    break;
//
//                case textoInsertar :
//                    empiezaBorrando = false;
//                    sourceArray = gusVectorCadenaCambiante;
//                    startingPositionSourceArray = linea_numeroOrigen - 1;
//                    targetArray = gusVectorCadenaCambiante;
//                    startingPositionTargetArray = linea_numeroOrigen ;
//                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numeroOrigen;
//                    if (linea_numeroOrigen == gusVectorCadenaCambiante.length)
//                        gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
//                    else {
//                        System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
//                        gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
//                    }
//                    System.out.println(
//                            "insertar "
//                                    + celda + " "
//                                    + String.valueOf(gusVectorCadenaCambiante));
//                    break;
//                case textoSustituir:
//                    empiezaBorrando = false;
//
//                  gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
////                    gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroDestino - 1];
////                    gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[Math.min(linea_numeroOrigen, linea_numeroDestino) - 1];
//                    System.out.println(
//                            "sustituir "
//                                    + celda + " "
//                                    + String.valueOf(gusVectorCadenaCambiante));
//                    celda++;
//            }
//        }
//    }

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

//    Stack<String> rutaASeguirSegunMatrizResolucionSimple(int[][] matrizResolucion) {
//        Stack <String> pilaChequeo = new Stack <>();
//        int[][] test = {{0}};
//        boolean isMatrizResolucionVacia = isMatrizResolucionVacia(matrizResolucion, test);
//        boolean matrizResolucionBorrar;
//        boolean matrizResolucionInsertar;
//        boolean matrizResolucionSustituir;
//
//        if (isMatrizResolucionVacia)
//            return pilaChequeo;
//        int fila_I = matrizResolucion.length - 1;
//        int colu_F = matrizResolucion[0].length - 1;
//        while (fila_I != 0 && colu_F != 0) {
//            matrizResolucionBorrar = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1][colu_F] + 1);
//            matrizResolucionInsertar = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I][colu_F - 1] + 1);
//            matrizResolucionSustituir = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1][colu_F - 1] + 1);
//            if (matrizResolucionBorrar) {
//                pilaChequeo.push(textoBorrar);
//                fila_I--;
//            } else if (matrizResolucionInsertar) {
//                pilaChequeo.push(textoInsertar);
//                colu_F--;
//            } else if (matrizResolucionSustituir) {
//                pilaChequeo.push(textoSustituir);
//                fila_I--;
//                colu_F--;
//            } else {
//                pilaChequeo.push(textoNoTocar);
//                fila_I--;
//                colu_F--;
//            }
//        }
//        return pilaChequeo;
//    }


    Stack<String> rutaASeguirSegunMatrizResolucion(int[][] matrizResolucion) {
        Stack<String> pilaChequeo = new Stack<>();
        int[][]test = {{0}};
        boolean isMatrizResolucionVacia = isMatrizResolucionVacia(matrizResolucion, test);
        boolean matrizResolucionBorrar;
        boolean matrizResolucionInsertar;
        boolean matrizResolucionSustituir;
        String espacio = " ";
        String uno = "1";
        if (isMatrizResolucionVacia)
            return pilaChequeo;
        int fila_I = matrizResolucion.length - 1;
        int colu_F = matrizResolucion[0].length - 1;
        int i = Math.max(fila_I, colu_F);
        boolean esPrimeroBorrar = true;
        while (fila_I != 0 && colu_F != 0) {
            matrizResolucionBorrar    = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1] [colu_F]     + 1);
            matrizResolucionInsertar  = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I]     [colu_F - 1] + 1);
            matrizResolucionSustituir = (matrizResolucion[fila_I][colu_F] == matrizResolucion[fila_I - 1] [colu_F - 1] + 1);
            if (matrizResolucionBorrar) {
                if (esPrimeroBorrar) {
                    pilaChequeo.push(textoBorrar + espacio + uno);  i--;
                    fila_I--;
                }
                else {
                    pilaChequeo.push(textoBorrar + espacio + i--);   i++;
                    fila_I--;
                    esPrimeroBorrar = false;
                }
            } else if (matrizResolucionInsertar) {
                pilaChequeo.push(textoInsertar + espacio + i--);
                colu_F--;
                esPrimeroBorrar = false;
            } else if (matrizResolucionSustituir) {
                pilaChequeo.push(textoSustituir + espacio + i--);
                fila_I--;
                colu_F--;
                esPrimeroBorrar = false;
            } else {
                pilaChequeo.push(textoNoTocar + espacio + i--);
                //i--;
                fila_I--;
                colu_F--;
                esPrimeroBorrar = false;
            }
        }
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
        int borrados = 0;
        casillaATratar = 1;

        while (!pilaChequeo.isEmpty()) {
            String[] linea = pilaChequeo.pop().split(" ");
            String linea_accion = linea[0];
            String linea_numeroEnTexto = linea[1];
            int linea_numeroOrigen = Integer.valueOf(linea_numeroEnTexto);
            int linea_numeroDestino = linea_numeroOrigen - borrados;
            char[] sourceArray;
            int startingPositionSourceArray;
            char[] targetArray;
            int startingPositionTargetArray;
            int numeroElementosACopiar;

            switch (linea_accion) {
                case textoBorrar:
                    borrados++;
                    sourceArray = gusVectorCadenaCambiante;
                    startingPositionSourceArray = linea_numeroOrigen;
                    targetArray = gusVectorCadenaCambiante;
                    startingPositionTargetArray = linea_numeroOrigen - 1;
                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numeroOrigen;
                    System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
                    gusVectorCadenaCambiante[gusVectorCadenaCambiante.length - 1] = ' ';
                    System.out.println(
                            "borrar "
                                    + linea_numeroEnTexto + " "
//                                    + " =" + casillaATratar + " "
                                    + String.valueOf(gusVectorCadenaCambiante)

                    );
                    linea_numeroDestino--;
                    break;
                case textoInsertar :
                    sourceArray = gusVectorCadenaCambiante;
                    startingPositionSourceArray = linea_numeroOrigen - 1;
                    targetArray = gusVectorCadenaCambiante;
                    startingPositionTargetArray = linea_numeroOrigen ;
                    numeroElementosACopiar = gusVectorCadenaCambiante.length - linea_numeroOrigen;
                    if (linea_numeroOrigen == gusVectorCadenaCambiante.length)
                        gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
                    else {
                        System.arraycopy(sourceArray, startingPositionSourceArray, targetArray, startingPositionTargetArray, numeroElementosACopiar);
                        gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
                    }
                    System.out.println(
                            "insertar "
                                    + linea_numeroEnTexto + " "
//                                    + " =" + casillaATratar + " "
                                    + String.valueOf(gusVectorCadenaCambiante)
                    );
                    casillaATratar++;
                    break;
                case textoSustituir:

//                  gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroOrigen - 1];
                    gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroDestino - 1];
//                    gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[Math.min(linea_numeroOrigen, linea_numeroDestino) - 1];
                    System.out.println(
                            "sustituir "
                                    + linea_numeroEnTexto + " "
//                                    + " =" + casillaATratar + " "
                                    + String.valueOf(gusVectorCadenaCambiante)
                    );
                    casillaATratar++;
                    break;

                default:
//                    gusVectorCadenaCambiante[linea_numeroOrigen - 1] = cadenaFinal[linea_numeroDestino - 1];
                    System.out.println(
                            "no tocar "
                                    + linea_numeroEnTexto + " "
//                                    + " =" + casillaATratar + " "
                                    + String.valueOf(gusVectorCadenaCambiante)
                    );
                    casillaATratar++;

            }
        }
    }

    public int getCasillaATratar(){
        return casillaATratar;
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
