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
}
