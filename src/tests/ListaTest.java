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
	public void obtenerIndiceNegativoTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(23);
		lista.agregar(17);

		lista.obtener(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void obtenerIndiceMayorALargoTest() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(23);
		lista.agregar(17);

		int posicion = lista.largo();
		lista.obtener(posicion);
	}

	@Test
	public void agregarEnIndiceCeroEnListaVaciaTest() {
		Lista<String> lista = new Lista<String>();
		String cadena = "Perro";
		int indice = 0;

		lista.agregar(cadena, indice);

		assertEquals(cadena, lista.obtener(indice));
	}

	@Test
	public void agregarEnIndiceCeroEnListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gallina";
		lista.agregar(cad1);
		int indice = 0;

		lista.agregar(cad2, indice);

		assertEquals(cad2, lista.obtener(indice));
	}

	@Test
	public void agregarEnIndiceMedioEnListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gato";
		String cad3 = "Conejo";
		int indice = 1;

		lista.agregar(cad1);
		lista.agregar(cad2);

		lista.agregar(cad3, indice);

		assertEquals(cad3, lista.obtener(1));
	}

	@Test
	public void agregarEnIndiceAlFinalEnListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gato";
		String cad3 = "Conejo";
		int indice = 2;

		lista.agregar(cad1);
		lista.agregar(cad2);
		lista.agregar(cad3, indice);

		assertEquals(cad3, lista.obtener(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarEnIndiceMenorACeroTest() {
		Lista<String> lista = new Lista<String>();
		String cad = "Perro";

		lista.agregar(cad, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarEnIndiceMayorALargoListaTest() {
		Lista<String> lista = new Lista<String>();
		lista.agregar("Perro");
		lista.agregar("Gato");

		lista.agregar("Gallina", 3);
	}

	@Test
	public void isSinDuplicadosListaVaciaTest() {
		Lista<String> lista = new Lista<String>();
		boolean resultado = true;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void isSinDuplicadosListaUnElemTest() {
		Lista<String> lista = new Lista<String>();
		String cad = "Gallina";
		lista.agregar(cad);
		boolean resultado = true;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void isSinDuplicadosListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gallina";
		String cad3 = "Gato";
		lista.agregar(cad1);
		lista.agregar(cad2);
		lista.agregar(cad3);
		lista.agregar(cad2);

		boolean resultado = false;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void rotarDerechaListaVaciaTest() {
		Lista<String> lista = new Lista<String>();

		lista.rotarDerecha();

		assertEquals(lista.largo(), 0);
	}

	@Test
	public void rotarDerechaListaUnElemTest() {
		Lista<String> lista = new Lista<String>();
		String cad = "Oso panda";
		lista.agregar(cad);

		lista.rotarDerecha();

		assertEquals(cad, lista.obtener(0));
	}

	@Test
	public void rotarDerechaListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gato";
		String cad3 = "Oso panda";
		lista.agregar(cad1);
		lista.agregar(cad2);
		lista.agregar(cad3);

		lista.rotarDerecha();

		assertEquals(cad3, lista.obtener(0));
	}

	@Test
	public void isOrdenadaListaVaciaTest() {
		Lista<String> lista = new Lista<String>();

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaUnElemTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Oso panda";

		lista.agregar(cad1);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaElemsNoOrdenadosTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Perro";
		String cad2 = "Gallina";
		String cad3 = "Oso panda";

		lista.agregar(cad1);
		lista.agregar(cad2);
		lista.agregar(cad3);

		assertFalse(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaElemsOrdenadosTest() {
		Lista<String> lista = new Lista<String>();
		String cad1 = "Gallina";
		String cad2 = "Oso panda";
		String cad3 = "Perro";

		lista.agregar(cad1);
		lista.agregar(cad2);
		lista.agregar(cad3);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaVaciaTest() {
		Lista<Integer> lista = new Lista<Integer>();
		Integer n1 = 1;

		lista.insertarOrdenado(n1);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaSinRepetidosTest() {
		Lista<Integer> lista = new Lista<Integer>();
		Integer n1 = 23;
		Integer n2 = 22;
		Integer n3 = 2000;
		Integer n4 = 1999;

		lista.insertarOrdenado(n1);
		lista.insertarOrdenado(n2);
		lista.insertarOrdenado(n3);
		lista.insertarOrdenado(n4);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaConRepetidosTest() {
		Lista<Integer> lista = new Lista<Integer>();
		Integer n1 = 23;
		Integer n2 = 22;
		Integer n3 = 2000;

		lista.insertarOrdenado(n3);
		lista.insertarOrdenado(n1);
		lista.insertarOrdenado(n2);
		lista.insertarOrdenado(n3);

		assertTrue(lista.isOrdenada());
	}

	@Test(expected = IllegalArgumentException.class)
	public void intercambiarColasUnaListaVaciaTest() {
		Lista<String> lista1 = new Lista<String>();
		Lista<String> lista2 = new Lista<String>();

		lista1.agregar("Oso panda");
		lista1.agregar("Perro");
		lista1.agregar("Gato");

		Lista.intercambiarColas(lista1, 1, lista2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void intercambiarColasUnaPosicionNoValidaTest() {
		Lista<String> lista1 = new Lista<String>();
		Lista<String> lista2 = new Lista<String>();

		lista1.agregar("Oso panda");
		lista1.agregar("Perro");
		lista2.agregar("Gato");

		Lista.intercambiarColas(lista1, 1, lista2, 2);
	}

	@Test
	public void intercambiarColasPosicionesIgualACeroTest() {
		Lista<Integer> lista1 = new Lista<Integer>();
		Lista<Integer> lista2 = new Lista<Integer>();
		lista1.agregar(2);
		lista1.agregar(4);
		lista1.agregar(6);
		lista1.agregar(8);
		lista2.agregar(1);
		lista2.agregar(3);
		lista2.agregar(5);
		lista2.agregar(7);

		Lista.intercambiarColas(lista1, 0, lista2, 0);

		assertEquals(lista1EsperadaIntercambiarColasPosicionesIgualCero(), lista2);
		assertEquals(lista2EsperadaIntercambiarColasPosicionesIgualCero(), lista1);
	}

	@Test
	public void intercambiarColasPosicionesDistintasDeCeroTest() {
		Lista<Integer> lista1 = new Lista<Integer>();
		Lista<Integer> lista2 = new Lista<Integer>();
		lista1.agregar(2);
		lista1.agregar(4);
		lista1.agregar(6);
		lista1.agregar(8);
		lista2.agregar(1);
		lista2.agregar(3);
		lista2.agregar(5);
		lista2.agregar(7);

		Lista.intercambiarColas(lista1, 2, lista2, 2);

		assertEquals(lista1EsperadaIntercambiarColasPosicionesDistintasDeCero(), lista1);
		assertEquals(lista2EsperadaIntercambiarColasPosicionesDistintasDeCero(), lista2);
	}

	@Test
	public void buscarTodosListaVaciaTest() {
		Lista<String> lista = new Lista<String>();
		Lista<Integer> listaVacia = new Lista<Integer>();

		Lista<Integer> aparicionesElem = lista.buscarTodos("Oso panda");

		assertEquals(listaVacia, aparicionesElem);
	}

	@Test
	public void buscarTodosSinAparicionesListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		Lista<Integer> listaVacia = new Lista<Integer>();
		lista.agregar("Casa");
		lista.agregar("Perro");
		lista.agregar("Computadora");

		Lista<Integer> aparicionesElem = lista.buscarTodos("Oso panda");

		assertEquals(listaVacia, aparicionesElem);
	}

	@Test
	public void buscarTodosConAparicionesListaLlenaTest() {
		Lista<String> lista = new Lista<String>();
		Lista<Integer> listaVacia = new Lista<Integer>();
		lista.agregar("Casa");
		lista.agregar("Perro");
		lista.agregar("Computadora");
		lista.agregar("Perro");
		listaVacia.agregar(1);
		listaVacia.agregar(3);

		Lista<Integer> aparicionesElem = lista.buscarTodos("Perro");

		assertEquals(listaVacia, aparicionesElem);
	}

	private Lista<Integer> lista1EsperadaIntercambiarColasPosicionesDistintasDeCero() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(2);
		lista.agregar(4);
		lista.agregar(5);
		lista.agregar(7);
		return lista;
	}

	private Lista<Integer> lista2EsperadaIntercambiarColasPosicionesDistintasDeCero() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(1);
		lista.agregar(3);
		lista.agregar(6);
		lista.agregar(8);
		return lista;
	}

	private Lista<Integer> lista1EsperadaIntercambiarColasPosicionesIgualCero() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(2);
		lista.agregar(4);
		lista.agregar(6);
		lista.agregar(8);
		return lista;
	}

	private Lista<Integer> lista2EsperadaIntercambiarColasPosicionesIgualCero() {
		Lista<Integer> lista = new Lista<Integer>();
		lista.agregar(1);
		lista.agregar(3);
		lista.agregar(5);
		lista.agregar(7);
		return lista;
	}
}