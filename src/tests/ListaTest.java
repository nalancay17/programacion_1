package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import listas.Lista;

public class ListaTest {

	@Test
	public void listaVaciatest() {
		Lista<String> lista = new Lista<String>();
		assertTrue(lista.isVacia());
	}

	@Test
	public void listaNoVaciaTest() {
		Lista<String> lista = new Lista<String>();
		lista.agregar("Casa");
		assertFalse(lista.isVacia());
	}

	@Test
	public void largoListaVaciaTest() {
		Lista<Integer> lista = new Lista<Integer>();
		assertEquals(0, lista.largo());
	}

	@Test
	public void largoListaNoVaciaTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(2);
		lista.agregar(9);
		assertEquals(2, lista.largo());
	}

	@Test
	public void agregarEnListaVaciaTest() {
		String cadena = "Hola!";
		Lista<String> lista = new Lista<String>();
		lista.agregar(cadena);

		assertFalse(lista.isVacia());
		assertEquals(cadena, lista.obtener(0));
	}

	@Test
	public void agregarEnListaNoVaciaTest() {
		Lista<String> lista = new Lista<String>();
		String cadena1 = "Perro";
		String cadena2 = "Gato";

		lista.agregar(cadena1);
		lista.agregar(cadena2);

		assertEquals(cadena2, lista.obtener(1));
	}

	@Test
	public void obtenerEnListaTest() {
		Lista<String> lista = new Lista<String>();
		String c0 = "Ratón";
		String c1 = "Gallina";
		String c2 = "Perro";

		lista.agregar(c0);
		lista.agregar(c1);
		lista.agregar(c2);

		assertEquals(c0, lista.obtener(0));
		assertEquals(c1, lista.obtener(1));
		assertEquals(c2, lista.obtener(2));
	}

	@Test(expected = NullPointerException.class)
	public void obtenerEnListaVaciaTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.obtener(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerPosicionNegativaTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(23);
		lista.agregar(17);

		lista.obtener(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerPosicionMayorALargoTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(23);
		lista.agregar(17);

		int posicion = lista.largo();
		lista.obtener(posicion);
	}

}
