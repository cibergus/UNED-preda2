package preda_de;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZTests_DistEdic {

	@Before
	public final void Inicio() {
		System.out.println("\n----> TEST DE: ");
	}

	//	@Test
	//	public final void test_agregarUnElementoAUnVector_01() {
	//		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
	//		char[] charInicio = {'a','a','a'};
	//		char charFinal  = 'b';
	//		char[] valorEsperado = {'a','a','a','b'};
	//		char[] valorReal = prueba.vectorAgregarUnElemento(charInicio, charFinal);
	//		assertEquals(valorEsperado, valorReal);
	//	}

	public final void testArgs08_t_AlFinal() {
		System.out.println("testArgs08_t_AlFinal - NO_FUNCIONA_COMO_QUISIERA");
		String[] args = {"fichEntrada.txt", "fichSalida.txt", "-t"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertTrue(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("fichSalida.txt", InicialGestorParametrosDE.parametroPenultimo);
		assertEquals("-t", InicialGestorParametrosDE.parametroUltimo);
	}
	
	@Test
	public final void testArgs07_VACIO() {
		System.out.println("testArgs07_VACIO");
		String[] args = {};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertFalse(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals(null, InicialGestorParametrosDE.parametroUltimo);
		assertEquals(null, InicialGestorParametrosDE.parametroPenultimo);
	}
	
	@Test
	public final void testArgs06_entradaTxt_salidaTxt() {
		System.out.println("testArgs06_entradaTxt_salidaTxt");
		String[] args = {"fichEntrada.txt", "fichSalida.txt"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertFalse(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("fichSalida.txt", InicialGestorParametrosDE.parametroUltimo);
		assertEquals("fichEntrada.txt", InicialGestorParametrosDE.parametroPenultimo);
	}
	
	@Test
	public final void testArgs05_entradaTxt() {
		System.out.println("testArgs05_entradaTxt");
		String[] args = {"fichEntrada.txt"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertFalse(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("fichEntrada.txt", InicialGestorParametrosDE.parametroUltimo);
		assertEquals(null, InicialGestorParametrosDE.parametroPenultimo);
	}

	@Test
	public final void testArgs04_niH_niT() {
		System.out.println("testArgs04_niH_niT");
		String[] args = {"otraCosa"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertFalse(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("otraCosa", InicialGestorParametrosDE.parametroUltimo);
		assertEquals(null, InicialGestorParametrosDE.parametroPenultimo);
	}

	@Test
	public final void testArgs03_h_t() {
		System.out.println("testArgs03_h_t");
		String[] args = {"-h", "-t"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertTrue(InicialGestorParametrosDE.esAyudaActiva);
		assertTrue(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("-t", InicialGestorParametrosDE.parametroUltimo);
		assertEquals("-h", InicialGestorParametrosDE.parametroPenultimo);
	}

	@Test
	public final void testArgs02_t() {
		System.out.println("testArgs02_t");
		String[] args = {"-t"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertFalse(InicialGestorParametrosDE.esAyudaActiva);
		assertTrue(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("-t", InicialGestorParametrosDE.parametroUltimo);
		assertEquals(null, InicialGestorParametrosDE.parametroPenultimo);
	}
	
	@Test
	public final void testArgs01_h() {
		System.out.println("testArgs01_h");
		String[] args = {"-h"};
		InicialGestorParametrosDE.asignarParametros(args);
		assertTrue(InicialGestorParametrosDE.esAyudaActiva);
		assertFalse(InicialGestorParametrosDE.esTrazaActiva);
		assertEquals("-h", InicialGestorParametrosDE.parametroUltimo);
		assertEquals(null, InicialGestorParametrosDE.parametroPenultimo);
	}

	@Test
	public final void test19_baab_bb() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
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
	public final void test14() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "Gus";
		String cadenaFinal  = "";
		int valorEsperado   = 3;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}

	@Test
	public final void test13_____Gus() {
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
	public final void test00_xax_a() {
		AlgoritmoProgrDinamica prueba = new AlgoritmoProgrDinamica();
		String cadenaInicio = "xax";
		String cadenaFinal  = "a";
		int valorEsperado = 2;
		int valorReal = prueba.distanciaEdicionProgDinamica(cadenaInicio.toCharArray(), cadenaFinal.toCharArray());
		assertEquals(valorEsperado, valorReal);
	}
}