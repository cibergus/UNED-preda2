package preda_de;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import java.util.Stack;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZTests_DistEdicTest {
    String insertar = "i ";
    String sustituir = "s ";
    String borrar = "b ";
    String no_tocar = "no_tocar ";

    @Before
	public final void Inicio() {
		System.out.println("\n----> TEST DE: ");

	}

    @Test
    public final void test64_ruta_a_bba(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "bba";
        int valorEsperado_DistEdic   = 2;
        int[][] valorEsperado_matrizResolucion = {{0,1,2,3},{1,1,2,2}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(insertar + "1");
        valorEsperado_rutaASeguir.push(insertar + "1");

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test63_ruta_a_ba_CHECK(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "ba";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1,2},{1,1,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(insertar + "1");

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test62_ruta_bbba_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "bbba";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 3;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,1},{2,2},{3,3},{4,3}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(borrar + "1");
        valorEsperado_rutaASeguir.push(borrar + "1");
        valorEsperado_rutaASeguir.push(borrar + "1");

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test61_ruta_bba_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "bba";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 2;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,1},{2,2},{3,2}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(borrar + "1");
        valorEsperado_rutaASeguir.push(borrar + "1");

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test60_ruta_ba_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "ba";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,1},{2,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(borrar + i--);


        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }


    @Test
    public final void test59_ruta_a_bab_CHECK(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "bab";
        int valorEsperado_DistEdic   = 2;
        int[][] valorEsperado_matrizResolucion = {{0,1,2,3},{1,1,1,2}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(insertar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        valorEsperado_rutaASeguir.push(insertar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test58_ruta_ab_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "ab";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,0},{2,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(borrar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test57_ruta_casa_calle(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "casa";
        String cadenaFinal  = "calle";
        int valorEsperado_DistEdic   = 3;
        int[][] valorEsperado_matrizResolucion = {{0,1,2,3,4,5},{1,0,1,2,3,4},{2,1,0,1,2,3},{3,2,1,1,2,3},{4,3,2,2,2,3}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(insertar + i--);
        valorEsperado_rutaASeguir.push(sustituir + i--);
        valorEsperado_rutaASeguir.push(sustituir + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test56_ruta_a_ab(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "ab";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1,2},{1,0,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(insertar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

	@Test
    public final void test55_ruta_igual_igual(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "igual";
        String cadenaFinal  = "igual";
        int valorEsperado_DistEdic   = 0;
        int[][] valorEsperado_matrizResolucion = {{0,1,2,3,4,5},{1,0,1,2,3,4},{2,1,0,1,2,3},{3,2,1,0,1,2},{4,3,2,1,0,1},{5,4,3,2,1,0}};
        int i = valorEsperado_matrizResolucion.length - 1;
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);
        i--;//valorEsperado_rutaASeguir.push(no_tocar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test54_ruta_a_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 0;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,0}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        i--;//        valorEsperado_rutaASeguir.push(no_tocar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test53_ruta_a_Vacio(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0},{1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(borrar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test52_ruta_a_b(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "a";
        String cadenaFinal  = "b";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1},{1,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(sustituir + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test51_ruta_Vacio_a(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();

        String cadenaInicio = "";
        String cadenaFinal  = "a";
        int valorEsperado_DistEdic   = 1;
        int[][] valorEsperado_matrizResolucion = {{0,1}};
        int i = Math.max(valorEsperado_matrizResolucion.length - 1, valorEsperado_matrizResolucion[0].length - 1);
        valorEsperado_rutaASeguir.push(insertar + i--);

        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }

    @Test
    public final void test50_ruta_Vacio_Vacio(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        String cadenaInicio = "";
        String cadenaFinal  = "";
        int valorEsperado_DistEdic   = 0;
        int[][] valorEsperado_matrizResolucion = {{0}};
        Stack<String> valorEsperado_rutaASeguir = new Stack <>();


        int valorReal_DistEdic = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado_DistEdic, valorReal_DistEdic);
        int[][] valorReal_matrizResolucion = prueba.crearMatrizResolucion(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertArrayEquals(valorEsperado_matrizResolucion, valorReal_matrizResolucion);
        Stack<String> valorReal_rutaASeguir = prueba.rutaASeguirSegunMatrizResolucion(valorReal_matrizResolucion);
        assertEquals(valorEsperado_rutaASeguir, valorReal_rutaASeguir);
    }


    @Test
    public final void test50_PilaPruebas_OK(){


        Stack<String> pilaChequeo = new Stack<>();
        assertTrue(pilaChequeo.isEmpty());
        assertEquals(0, pilaChequeo.size());
        pilaChequeo.push("a");
        assertFalse(pilaChequeo.isEmpty());
        assertEquals("a", pilaChequeo.peek());
        assertEquals("a", pilaChequeo.pop());
        assertTrue(pilaChequeo.isEmpty());

        String[] x = {"a", "b", "c", "d"};
        for(int i = 0; i < x.length; i++) {
            pilaChequeo.push(x[i]);
            assertEquals(i + 1, pilaChequeo.size());
            assertEquals(x[i], pilaChequeo.peek());
            }
        for(int i = x.length - 1; i >= 0; i--) {
            assertEquals(x[i], pilaChequeo.pop());
            }
        assertTrue(pilaChequeo.isEmpty());
    }

    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////

	@Test
	public final void test37_matrizResolucion_Gus_Vacio(){
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        char[] cadenaInicial_Vector = "Gus".toCharArray();
        char[] candenaFinal_Vector = "".toCharArray();
		int[][] valorEsperado = {{0},{1},{2},{3}};
		int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
		assertArrayEquals(valorEsperado, valorReal);
	}

	@Test
	// 		int[][] matrizResolucion = crearMatrizResolucion(cadenaInicial, cadenaFinal);
	public final void test36_matrizResolucion_ba_ab(){
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicial = "ba";
		char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
		String cadenaFinal  = "ab";
		char[] candenaFinal_Vector = cadenaFinal.toCharArray();
		int[][] valorEsperado = {{0,1,2},{1,1,1},{2,1,2}};
		int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
		assertArrayEquals(valorEsperado, valorReal);
	}



	@Test
	public final void test35_matrizResolucion_igual_igual() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicial = "igual";
		char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
		String cadenaFinal  = "igual";
		char[] candenaFinal_Vector = cadenaFinal.toCharArray();
		int[][] valorEsperado = {{0,1,2,3,4,5},{1,0,1,2,3,4},{2,1,0,1,2,3},{3,2,1,0,1,2},{4,3,2,1,0,1},{5,4,3,2,1,0}};
		int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
		assertArrayEquals(valorEsperado, valorReal);
	}

    @Test
    // 		int[][] matrizResolucion = crearMatrizResolucion(cadenaInicial, cadenaFinal);
    public final void test34_matrizResolucion_a_ab(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        String cadenaInicial = "a";
        char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
        String cadenaFinal  = "ab";
        char[] candenaFinal_Vector = cadenaFinal.toCharArray();
        int[][] valorEsperado = {{0,1,2},{1,0,1}};
        int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
        assertArrayEquals(valorEsperado, valorReal);
    }

    @Test
	public final void test33_matrizResolucion_casa_calle(){
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicial = "casa";
		char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
		String cadenaFinal  = "calle";
		char[] candenaFinal_Vector = cadenaFinal.toCharArray();
		int[][] valorEsperado = {{0,1,2,3,4,5},{1,0,1,2,3,4},{2,1,0,1,2,3},{3,2,1,1,2,3},{4,3,2,2,2,3}};
		int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
		assertArrayEquals(valorEsperado, valorReal);
	}

    @Test
	public final void test32_matrizResolucion_a_5(){
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicial = "a";
		char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
		String cadenaFinal  = "5";
		char[] candenaFinal_Vector = cadenaFinal.toCharArray();
		int[][] valorEsperado = {{0,1},{1,1}};
		int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
		assertArrayEquals(valorEsperado, valorReal);
	}

    @Test
    public final void test31_matrizResolucion_a_b(){
        AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
        String cadenaInicial = "a";
        char[] cadenaInicial_Vector = cadenaInicial.toCharArray();
        String cadenaFinal  = "b";
        char[] candenaFinal_Vector = cadenaFinal.toCharArray();
        int[][] valorEsperado = {{0,1},{1,1}};
        int[][] valorReal = prueba.crearMatrizResolucion(cadenaInicial_Vector, candenaFinal_Vector); // =   int[][] matrizResolucion
        assertArrayEquals(valorEsperado, valorReal);
    }

    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////

	@Test
	public final void test19_baab_bb() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
//        Edicion prueba = new Edicion;
		String cadenaInicio = "baab";
		String cadenaFinal  = "bb";
		int valorEsperado = 2;
        int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
        assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test18_0abc0_0xyz0() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "0abc0";
		String cadenaFinal  = "0xyz0";
		int valorEsperado = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test17_a_bb() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "a";
		String cadenaFinal  = "bb";
		int valorEsperado = 2;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test16_infligir_infringir() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "infligir";
		String cadenaFinal  = "infringir";
		int valorEsperado   = 2;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test15_Gus_5() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "Gus";
		String cadenaFinal  = "5";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test14___Gus_aVacio() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "Gus";
		String cadenaFinal  = "";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test13__deVacio_Gus() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "";
		String cadenaFinal  = "Gus";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test12_ssbaaa_ppbaxaa() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "ssbaaa";
		String cadenaFinal  = "ppbaxaa";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test11_bbbadd_addxxx() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "bbbadd";
		String cadenaFinal  = "addxxx";
		int valorEsperado   = 6;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test10_xxxborrarxxx_borrar() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "xxxborrarxxx";
		String cadenaFinal  = "borrar";
		int valorEsperado   = 6;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test09_borrar_xxxborrarxxx() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "borrar";
		String cadenaFinal  = "xxxborrarxxx";
		int valorEsperado   = 6;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test08_borrar_borrarxxx() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "borrar";
		String cadenaFinal  = "borrarxxx";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test07_borrar_xxxborrar() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "borrar";
		String cadenaFinal  = "xxxborrar";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test06_borrarxxx_borrar() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "borrarxxx";
		String cadenaFinal  = "borrar";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test05_xxxborrar_borrar() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "xxxborrar";
		String cadenaFinal  = "borrar";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test04_igual_igual() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "igual";
		String cadenaFinal  = "igual";
		int valorEsperado   = 0;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test03_casa_calle() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "casa";
		String cadenaFinal  = "calle";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test02_a_5() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "a";
		String cadenaFinal  = "5";
		int valorEsperado   = 1;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test01_a_b() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "a";
		String cadenaFinal  = "b";
		int valorEsperado   = 1;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

    @Test
	public final void test00_ok_xax_a() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "xax";
		String cadenaFinal  = "a";
		int valorEsperado = 2;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	//////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////

    @Test
    public final void test008_Args_t_AlFinal() {
        System.out.println("testArgs08_t_AlFinal - NO_FUNCIONA_COMO_QUISIERA");
        String[] args = {"fichEntrada.txt", "fichSalida.txt", "-t"};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertTrue(Edicion.esTrazaActiva);
        assertEquals("fichSalida.txt", Edicion.parametroPenultimo);
        assertEquals("-t", Edicion.parametroUltimo);
    }

    @Test
    public final void test007_Args_VACIO() {
        System.out.println("testArgs07_VACIO");
        String[] args = {};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertFalse(Edicion.esTrazaActiva);
        assertNull(Edicion.parametroUltimo);
        assertNull(Edicion.parametroPenultimo);
    }

    @Test
    public final void test006_Args_entradaTxt_salidaTxt() {
        System.out.println("testArgs06_entradaTxt_salidaTxt");
        String[] args = {"fichEntrada.txt", "fichSalida.txt"};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertFalse(Edicion.esTrazaActiva);
        assertEquals("fichSalida.txt", Edicion.parametroUltimo);
        assertEquals("fichEntrada.txt", Edicion.parametroPenultimo);
    }

    @Test
    public final void test005_Args_entradaTxt() {
        System.out.println("testArgs05_entradaTxt");
        String[] args = {"fichEntrada.txt"};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertFalse(Edicion.esTrazaActiva);
        assertEquals("fichEntrada.txt", Edicion.parametroUltimo);
        assertNull(Edicion.parametroPenultimo);
    }

    @Test
    public final void test004_Args_niH_niT() {
        System.out.println("testArgs04_niH_niT");
        String[] args = {"otraCosa"};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertFalse(Edicion.esTrazaActiva);
        assertEquals("otraCosa", Edicion.parametroUltimo);
        assertNull(Edicion.parametroPenultimo);
    }

    @Test
    public final void test003_Args_h_t() {
        System.out.println("testArgs03_h_t");
        String[] args = {"-h", "-t"};
        Edicion.asignarParametros(args);
        assertTrue(Edicion.esAyudaActiva);
        assertTrue(Edicion.esTrazaActiva);
        assertEquals("-t", Edicion.parametroUltimo);
        assertEquals("-h", Edicion.parametroPenultimo);
    }

    @Test
    public final void test002_Args_t() {
        System.out.println("testArgs02_t");
        String[] args = {"-t"};
        Edicion.asignarParametros(args);
        assertFalse(Edicion.esAyudaActiva);
        assertTrue(Edicion.esTrazaActiva);
        assertEquals("-t", Edicion.parametroUltimo);
        assertNull(Edicion.parametroPenultimo);
    }

    @Test
    public final void test001_Args_h() {
        System.out.println("testArgs01_h");
        String[] args = {"-h"};
        Edicion.asignarParametros(args);
        assertTrue(Edicion.esAyudaActiva);
        assertFalse(Edicion.esTrazaActiva);
        assertEquals("-h", Edicion.parametroUltimo);
        assertNull(Edicion.parametroPenultimo);
    }
}