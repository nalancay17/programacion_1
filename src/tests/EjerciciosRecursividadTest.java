package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import recursividad.EjerciciosRecursividad;

public class EjerciciosRecursividadTest {

	@Test
	public void sumatoriaOkTest() {
		int n = 5;
		int sumatoria = EjerciciosRecursividad.sumatoria(n);
		assertEquals(15, sumatoria);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sumatoriaArgumentoMenorACeroTest() {
		int n = -10;
		EjerciciosRecursividad.sumatoria(n);
	}

	@Test
	public void sumatoriaParesNParOkTest() {
		int n = 6;
		int sumatoriaPar = EjerciciosRecursividad.sumatoriaPares(n);
		assertEquals(12, sumatoriaPar);
	}

	@Test
	public void sumatoriaParesNImparOkTest() {
		int n = 5;
		int sumatoriaPar = EjerciciosRecursividad.sumatoriaPares(n);
		assertEquals(6, sumatoriaPar);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sumatoriaParesArgumentoMenorADosTest() {
		int n = 1;
		EjerciciosRecursividad.sumatoriaPares(n);
	}

	@Test
	public void potenciaOkTest() {
		double base = 10.0;
		int exponente = 3;
		double potencia = EjerciciosRecursividad.potencia(base, exponente);
		assertEquals(1000.0, potencia, 0);
	}

	@Test
	public void potenciaExponenteCeroTest() {
		double base = 10.0;
		int exponente = 0;
		double potencia = EjerciciosRecursividad.potencia(base, exponente);
		assertEquals(1, potencia, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void potenciaBaseYExponenteCeroTest() {
		double base = 0;
		int exponente = 0;
		EjerciciosRecursividad.potencia(base, exponente);
	}

	@Test(expected = IllegalArgumentException.class)
	public void potenciaExponenteNegativoTest() {
		double base = 10;
		int exponente = -1;
		EjerciciosRecursividad.potencia(base, exponente);
	}

	@Test
	public void factorialOkTest() {
		int n = 5;
		int factorial = EjerciciosRecursividad.factorial(n);
		assertEquals(120, factorial);
	}

	@Test
	public void factorialCeroTest() {
		int n = 0;
		int factorial = EjerciciosRecursividad.factorial(n);
		assertEquals(1, factorial);
	}

	@Test(expected = IllegalArgumentException.class)
	public void factorialNegativoTest() {
		int n = -1;
		EjerciciosRecursividad.factorial(n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void logConNNegativoTest() {
		int n = -1;
		int b = 4;
		EjerciciosRecursividad.log(n, b);
	}

	@Test(expected = IllegalArgumentException.class)
	public void logConBNegativoTest() {
		int n = 4;
		int b = -1;
		EjerciciosRecursividad.log(n, b);
	}

	@Test(expected = IllegalArgumentException.class)
	public void logConNyBCeroTest() {
		int n = 0;
		int b = 0;
		EjerciciosRecursividad.log(n, b);
	}

	@Test
	public void logDivisionSinDecimalesOkTest() {
		int n = 8;
		int b = 2;
		int resultado = EjerciciosRecursividad.log(n, b);

		assertEquals(4, resultado);
	}

	@Test
	public void logDivisionConDecimalesOkTest() {
		int n = 16;
		int b = 3;
		int resultado = EjerciciosRecursividad.log(n, b);

		assertEquals(3, resultado);
	}

	@Test
	public void logBMasgrandeQueNOkTest() {
		int n = 5;
		int b = 6;
		int resultado = EjerciciosRecursividad.log(n, b);

		assertEquals(1, resultado);
	}

	@Test
	public void quitarCadenaOkTest() {
		String str1 = "candela";
		String str2 = "cada";
		String str3 = "banana";
		String str4 = "a";
		String str5 = "perro";
		String str6 = "no";
		String str7 = "perro";
		String str8 = "eno";
		String str9 = "";
		String str10 = "luz";

		String resultado1 = EjerciciosRecursividad.quitarCadena(str1, str2);
		String resultado2 = EjerciciosRecursividad.quitarCadena(str3, str4);
		String resultado3 = EjerciciosRecursividad.quitarCadena(str5, str6);
		String resultado4 = EjerciciosRecursividad.quitarCadena(str7, str8);
		String resultado5 = EjerciciosRecursividad.quitarCadena(str9, str10);

		assertEquals("nel", resultado1);
		assertEquals("bnana", resultado2);
		assertEquals("perro", resultado3);
		assertEquals("prro", resultado4);
		assertEquals("", resultado5);
	}

	@Test
	public void laMarOkTest() {
		String s1 = "serena";
		String s2 = "carro";
		String s3 = "";
		String s4 = "hielo";

		String res1 = EjerciciosRecursividad.laMar(s1);
		String res2 = EjerciciosRecursividad.laMar(s2);
		String res3 = EjerciciosRecursividad.laMar(s3);
		String res4 = EjerciciosRecursividad.laMar(s4);

		assertEquals("ssarranna", res1);
		assertEquals("ccarrrra", res2);
		assertEquals("", res3);
		assertEquals("hhaalla", res4);
	}

	@Test
	public void eliminarVocalesRodeadasPorConsonantesOkTest() {
		String s1 = "cabezas";
		String s2 = "celeste";
		String s3 = "ciudad";
		String s4 = "acuerdo";
		String s5 = "aaalll";
		String s6 = "";

		String res1 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s1);
		String res2 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s2);
		String res3 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s3);
		String res4 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s4);
		String res5 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s5);
		String res6 = EjerciciosRecursividad.eliminarVocalesRodeadasPorConsonantes(s6);

		assertEquals("cbzs", res1);
		assertEquals("clste", res2);
		assertEquals("ciudd", res3);
		assertEquals("acuerdo", res4);
		assertEquals("aaalll", res5);
		assertEquals("", res6);
	}

	@Test
	public void letrasMayoresOkTest() {
		String s1 = "aazz";
		String s2 = "bubu";
		String s3 = "camas";
		String s4 = "bus";
		String s5 = "ala";
		String s6 = "ajo";
		String s7 = "luz";
		String s8 = "";

		String res1 = EjerciciosRecursividad.letrasMayores(s1, s2);
		String res2 = EjerciciosRecursividad.letrasMayores(s3, s4);
		String res3 = EjerciciosRecursividad.letrasMayores(s5, s6);
		String res4 = EjerciciosRecursividad.letrasMayores(s7, s8);

		assertEquals("buzz", res1);
		assertEquals("cusas", res2);
		assertEquals("alo", res3);
		assertEquals("luz", res4);
	}

	@Test
	public void eliminarVocalesYRevertirOkTest() {
		String s1 = "toro";
		String s2 = "risa";
		String s3 = "mapa";
		String s4 = "fadap";
		String s5 = "uia";

		String res1 = EjerciciosRecursividad.eliminarVocalesYRevertir(s1);
		String res2 = EjerciciosRecursividad.eliminarVocalesYRevertir(s2);
		String res3 = EjerciciosRecursividad.eliminarVocalesYRevertir(s3);
		String res4 = EjerciciosRecursividad.eliminarVocalesYRevertir(s4);
		String res5 = EjerciciosRecursividad.eliminarVocalesYRevertir(s5);

		assertEquals("rt", res1);
		assertEquals("sr", res2);
		assertEquals("pm", res3);
		assertEquals("pdf", res4);
		assertEquals("", res5);
	}

	@Test
	public void extremosOkTest() {
		String s1 = "solemnidad";
		String s2 = "solitario";
		String s3 = "soledad";
		String s4 = "soledad";
		String s5 = "palabra";

		String res1 = EjerciciosRecursividad.extremos(s1, 4, 3);
		String res2 = EjerciciosRecursividad.extremos(s2, 3, 1);
		String res3 = EjerciciosRecursividad.extremos(s3, 0, 4);
		String res4 = EjerciciosRecursividad.extremos(s4, 3, 0);
		String res5 = EjerciciosRecursividad.extremos(s5, 0, 0);

		assertEquals("soledad", res1);
		assertEquals("solo", res2);
		assertEquals("edad", res3);
		assertEquals("sol", res4);
		assertEquals("", res5);
	}

	@Test
	public void estaPrimeraOkTest() {
		String s1 = "piedra";
		String s2 = "cantor";
		String s3 = "";
		String s4 = "perro";
		String s5 = "hielo";
		String s6 = "holanda";
		String s7 = "candelabro";
		String s8 = "canario";
		String s9 = "materia";
		String s10 = "";

		String res1 = EjerciciosRecursividad.estaPrimero(s1, s2);
		String res2 = EjerciciosRecursividad.estaPrimero(s3, s4);
		String res3 = EjerciciosRecursividad.estaPrimero(s5, s6);
		String res4 = EjerciciosRecursividad.estaPrimero(s7, s8);
		String res5 = EjerciciosRecursividad.estaPrimero(s9, s10);

		assertEquals(s2, res1);
		assertEquals(s3, res2);
		assertEquals(s5, res3);
		assertEquals(s8, res4);
		assertEquals(s10, res5);
	}

	@Test
	public void separarVocalesOkTest() {
		String s1 = "murcielago";
		String s2 = "manzana";
		String s3 = "llamado";
		String s4 = "el";

		String res1 = EjerciciosRecursividad.separarVocales(s1);
		String res2 = EjerciciosRecursividad.separarVocales(s2);
		String res3 = EjerciciosRecursividad.separarVocales(s3);
		String res4 = EjerciciosRecursividad.separarVocales(s4);

		assertEquals("mrclgoaeiu", res1);
		assertEquals("mnznaaa", res2);
		assertEquals("llmdoaa", res3);
		assertEquals("le", res4);
	}

	@Test
	public void intercalarDespuesDeOkTest() {
		String s1 = "banana";
		String s2 = "ooo";
		String s3 = "aula";
		String s4 = "hola";
		String s5 = "perro";
		String s6 = "x";
		String s7 = "";
		String s8 = "luz";
		String s9 = "sol";
		String s10 = "";
		char c1 = 'a';
		char c2 = 'l';
		char c3 = 'r';
		char c4 = 'h';
		char c5 = 'o';

		String res1 = EjerciciosRecursividad.intercalarDespuesDe(s1, c1, s2);
		String res2 = EjerciciosRecursividad.intercalarDespuesDe(s3, c2, s4);
		String res3 = EjerciciosRecursividad.intercalarDespuesDe(s5, c3, s6);
		String res4 = EjerciciosRecursividad.intercalarDespuesDe(s7, c4, s8);
		String res5 = EjerciciosRecursividad.intercalarDespuesDe(s9, c5, s10);

		assertEquals("baonaonao", res1);
		assertEquals("aulha", res2);
		assertEquals("perxro", res3);
		assertEquals("", res4);
		assertEquals("sol", res5);
	}

	@Test
	public void estaIncluidaOkTest() {
		String s1 = "ala";
		String s2 = "calidad";
		String s3 = "alla";
		String s4 = "calidad";
		String s5 = "alla";
		String s6 = "llave";
		String s7 = "cajon";
		String s8 = "callejones";
		String s9 = "";
		String s10 = "palabra";
		String s11 = "ala";
		String s12 = "almidon";

		assertTrue(EjerciciosRecursividad.estaIncluida(s1, s2));
		assertFalse(EjerciciosRecursividad.estaIncluida(s3, s4));
		assertFalse(EjerciciosRecursividad.estaIncluida(s5, s6));
		assertTrue(EjerciciosRecursividad.estaIncluida(s7, s8));
		assertTrue(EjerciciosRecursividad.estaIncluida(s9, s10));
		assertFalse(EjerciciosRecursividad.estaIncluida(s11, s12));
	}

	@Test
	public void cantAparicionesOkTest() {
		String s1 = "anana";
		String s2 = "elefante";
		String s3 = "lamina";
		String s4 = "";
		String s5 = "camino";
		char c1 = 'a';
		char c2 = 'f';
		char c3 = 'z';
		char c4 = 'a';
		char c5 = 'c';

		int res1 = EjerciciosRecursividad.cantApariciones(s1, c1);
		int res2 = EjerciciosRecursividad.cantApariciones(s2, c2);
		int res3 = EjerciciosRecursividad.cantApariciones(s3, c3);
		int res4 = EjerciciosRecursividad.cantApariciones(s4, c4);
		int res5 = EjerciciosRecursividad.cantApariciones(s5, c5);

		assertEquals(3, res1);
		assertEquals(1, res2);
		assertEquals(0, res3);
		assertEquals(0, res4);
		assertEquals(1, res5);
	}

	@Test
	public void prodCifrasOkTest() {
		int n1 = 2034;
		int n2 = 52;
		int n3 = 9;
		int n4 = 11020;

		int res1 = EjerciciosRecursividad.prodCifras(n1);
		int res2 = EjerciciosRecursividad.prodCifras(n2);
		int res3 = EjerciciosRecursividad.prodCifras(n3);
		int res4 = EjerciciosRecursividad.prodCifras(n4);

		assertEquals(24, res1);
		assertEquals(10, res2);
		assertEquals(9, res3);
		assertEquals(2, res4);
	}

	@Test
	public void repetirCharOkTest() {
		String s1 = "ameno";
		String s2 = "caerse";
		String s3 = "fino";
		char c1 = 'a';
		char c2 = 'e';
		char c3 = 'u';
		int n1 = 3;
		int n2 = 4;
		int n3 = 2;

		String res1 = EjerciciosRecursividad.repetirChar(s1, c1, n1);
		String res2 = EjerciciosRecursividad.repetirChar(s2, c2, n2);
		String res3 = EjerciciosRecursividad.repetirChar(s3, c3, n3);

		assertEquals("aaameno", res1);
		assertEquals("caeeeerseeee", res2);
		assertEquals("fino", res3);
	}

}
