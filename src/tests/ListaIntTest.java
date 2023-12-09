package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import listas.ListaInt;

public class ListaIntTest {

	@Test
	public void listaVaciatest() {
		ListaInt lista = new ListaInt();
		assertTrue(lista.isVacia());
	}

	@Test
	public void listaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		lista.agregar(1);
		assertFalse(lista.isVacia());
	}

	@Test
	public void largoListaVaciaTest() {
		ListaInt lista = new ListaInt();
		assertEquals(0, lista.largo());
	}

	@Test
	public void largoListaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		lista.agregar(2);
		lista.agregar(9);
		assertEquals(2, lista.largo());
	}

	@Test
	public void agregarEnListaVaciaTest() {
		int n = 14;
		ListaInt lista = new ListaInt();
		lista.agregar(n);

		assertFalse(lista.isVacia());
		assertEquals(n, lista.obtener(0));
	}

	@Test
	public void agregarEnListaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 13;
		int n2 = 19;

		lista.agregar(n1);
		lista.agregar(n2);

		assertEquals(n2, lista.obtener(1));
	}

	@Test
	public void obtenerEnListaTest() {
		ListaInt lista = new ListaInt();
		int n0 = 17;
		int n1 = 9;
		int n2 = 0;

		lista.agregar(n0);
		lista.agregar(n1);
		lista.agregar(n2);

		assertEquals(n0, lista.obtener(0));
		assertEquals(n1, lista.obtener(1));
		assertEquals(n2, lista.obtener(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerEnListaVaciaTest() {
		ListaInt lista = new ListaInt();
		lista.obtener(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerIndiceNegativoTest() {
		ListaInt lista = new ListaInt();
		lista.agregar(23);
		lista.agregar(17);

		lista.obtener(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerIndiceMayorALargoTest() {
		ListaInt lista = new ListaInt();
		lista.agregar(23);
		lista.agregar(17);

		int posicion = lista.largo();
		lista.obtener(posicion);
	}

	@Test
	public void agregarEnIndiceCeroEnListaVaciaTest() {
		ListaInt lista = new ListaInt();
		int n = 99;
		int indice = 0;

		lista.agregar(n, indice);

		assertEquals(n, lista.obtener(indice));
	}

	@Test
	public void agregarEnIndiceCeroEnListaLlenaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 24;
		int n2 = 87;
		lista.agregar(n1);
		int indice = 0;

		lista.agregar(n2, indice);

		assertEquals(n2, lista.obtener(indice));
	}

	@Test
	public void agregarEnIndiceMedioEnListaLlenaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 24;
		int n2 = 99;
		int n3 = 77;
		int indice = 1;

		lista.agregar(n1);
		lista.agregar(n2);

		lista.agregar(n3, indice);

		assertEquals(n3, lista.obtener(1));
	}

	@Test
	public void agregarEnIndiceAlFinalEnListaLlenaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 88;
		int n2 = 8128;
		int n3 = 99;
		int indice = 2;

		lista.agregar(n1);
		lista.agregar(n2);
		lista.agregar(n3, indice);

		assertEquals(n3, lista.obtener(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarEnIndiceMenorACeroTest() {
		ListaInt lista = new ListaInt();
		int n = 99;

		lista.agregar(n, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarEnIndiceMayorALargoListaTest() {
		ListaInt lista = new ListaInt();
		lista.agregar(77);
		lista.agregar(1);

		lista.agregar(44, 3);
	}

}
