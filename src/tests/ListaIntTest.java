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

	@Test
	public void isSinDuplicadosListaVaciaTest() {
		ListaInt lista = new ListaInt();
		boolean resultado = true;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void isSinDuplicadosListaUnElemTest() {
		ListaInt lista = new ListaInt();
		int n = 88;
		lista.agregar(n);
		boolean resultado = true;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void isSinDuplicadosListaLlenaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		lista.agregar(n1);
		lista.agregar(n2);
		lista.agregar(n3);
		lista.agregar(n2);

		boolean resultado = false;

		assertEquals(resultado, lista.isSinDuplicados());
	}

	@Test
	public void rotarDerechaListaVaciaTest() {
		ListaInt lista = new ListaInt();

		lista.rotarDerecha();

		assertEquals(lista.largo(), 0);
	}

	@Test
	public void rotarDerechaListaUnElemTest() {
		ListaInt lista = new ListaInt();
		int n = 66;
		lista.agregar(n);

		lista.rotarDerecha();

		assertEquals(n, lista.obtener(0));
	}

	@Test
	public void rotarDerechaListaLlenaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		lista.agregar(n1);
		lista.agregar(n2);
		lista.agregar(n3);

		lista.rotarDerecha();

		assertEquals(n3, lista.obtener(0));
	}

	@Test
	public void isOrdenadaListaVaciaTest() {
		ListaInt lista = new ListaInt();

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaUnElemTest() {
		ListaInt lista = new ListaInt();
		int n = 1;

		lista.agregar(n);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaElemsNoOrdenadosTest() {
		ListaInt lista = new ListaInt();
		int n1 = 99;
		int n2 = 101;
		int n3 = 23;

		lista.agregar(n1);
		lista.agregar(n2);
		lista.agregar(n3);

		assertFalse(lista.isOrdenada());
	}

	@Test
	public void isOrdenadaListaElemsOrdenadosTest() {
		ListaInt lista = new ListaInt();
		int n1 = 1;
		int n2 = 88;
		int n3 = 101;

		lista.agregar(n1);
		lista.agregar(n2);
		lista.agregar(n3);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaVaciaTest() {
		ListaInt lista = new ListaInt();
		int n1 = 1;

		lista.insertarOrdenado(n1);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaSinRepetidosTest() {
		ListaInt lista = new ListaInt();
		int n1 = 23;
		int n2 = 22;
		int n3 = 2000;
		int n4 = 1999;

		lista.insertarOrdenado(n1);
		lista.insertarOrdenado(n2);
		lista.insertarOrdenado(n3);
		lista.insertarOrdenado(n4);

		assertTrue(lista.isOrdenada());
	}

	@Test
	public void insertarOrdenadoEnListaConRepetidosTest() {
		ListaInt lista = new ListaInt();
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
		ListaInt lista1 = new ListaInt();
		ListaInt lista2 = new ListaInt();

		lista1.agregar(1);
		lista1.agregar(2);
		lista1.agregar(3);

		ListaInt.intercambiarColas(lista1, 1, lista2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void intercambiarColasUnaPosicionNoValidaTest() {
		ListaInt lista1 = new ListaInt();
		ListaInt lista2 = new ListaInt();

		lista1.agregar(66);
		lista1.agregar(12);
		lista2.agregar(89);

		ListaInt.intercambiarColas(lista1, 1, lista2, 2);
	}

	@Test
	public void intercambiarColasPosicionesIgualACeroTest() {
		ListaInt lista1 = new ListaInt();
		ListaInt lista2 = new ListaInt();
		lista1.agregar(2);
		lista1.agregar(4);
		lista1.agregar(6);
		lista1.agregar(8);
		lista2.agregar(1);
		lista2.agregar(3);
		lista2.agregar(5);
		lista2.agregar(7);

		ListaInt.intercambiarColas(lista1, 0, lista2, 0);

		assertEquals(lista1EsperadaIntercambiarColasPosicionesIgualCero(), lista2);
		assertEquals(lista2EsperadaIntercambiarColasPosicionesIgualCero(), lista1);
	}

	@Test
	public void intercambiarColasPosicionesDistintasDeCeroTest() {
		ListaInt lista1 = new ListaInt();
		ListaInt lista2 = new ListaInt();
		lista1.agregar(2);
		lista1.agregar(4);
		lista1.agregar(6);
		lista1.agregar(8);
		lista2.agregar(1);
		lista2.agregar(3);
		lista2.agregar(5);
		lista2.agregar(7);

		ListaInt.intercambiarColas(lista1, 2, lista2, 2);

		assertEquals(lista1EsperadaIntercambiarColasPosicionesDistintasDeCero(), lista1);
		assertEquals(lista2EsperadaIntercambiarColasPosicionesDistintasDeCero(), lista2);
	}

	@Test
	public void buscarTodosListaVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt listaVacia = new ListaInt();

		ListaInt aparicionesElem = lista.buscarTodos(6);

		assertEquals(listaVacia, aparicionesElem);
	}

	@Test
	public void buscarTodosSinAparicionesListaLlenaTest() {
		ListaInt lista = new ListaInt();
		ListaInt listaVacia = new ListaInt();
		lista.agregar(1);
		lista.agregar(173);
		lista.agregar(99382);

		ListaInt aparicionesElem = lista.buscarTodos(999);

		assertEquals(listaVacia, aparicionesElem);
	}

	@Test
	public void buscarTodosConAparicionesListaLlenaTest() {
		ListaInt lista = new ListaInt();
		ListaInt listaVacia = new ListaInt();
		lista.agregar(828);
		lista.agregar(1);
		lista.agregar(82);
		lista.agregar(1);
		listaVacia.agregar(1);
		listaVacia.agregar(3);

		ListaInt aparicionesElem = lista.buscarTodos(1);

		assertEquals(listaVacia, aparicionesElem);
	}

	@Test
	public void anexarUnaListaNoVaciaEnListaVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt lista2 = new ListaInt();
		lista2.agregar(14);
		lista2.agregar(3);
		lista2.agregar(8);

		lista.anexar(lista2);

		assertEquals(lista2, lista);
	}

	@Test
	public void anexarUnaListaVaciaEnListaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt lista2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		lista.agregar(14);
		lista.agregar(3);
		lista.agregar(8);
		listaEsperada.agregar(14);
		listaEsperada.agregar(3);
		listaEsperada.agregar(8);

		lista.anexar(lista2);

		assertEquals(listaEsperada, lista);
	}

	public void anexarUnaListaVaciaEnListaVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt lista2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();

		lista.anexar(lista2);

		assertEquals(listaEsperada, lista);
	}

	@Test
	public void anexarUnaListaNoVaciaEnListaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt lista2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		lista.agregar(14);
		lista.agregar(8);
		lista2.agregar(20);
		lista2.agregar(1000);
		listaEsperada.agregar(14);
		listaEsperada.agregar(8);
		listaEsperada.agregar(20);
		listaEsperada.agregar(1000);

		lista.anexar(lista2);

		assertEquals(listaEsperada, lista);
	}

	@Test
	public void concatenarListasVaciasTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resEsperado = new ListaInt();

		ListaInt resultado = ListaInt.concatenar(l1, l2);

		assertEquals(resEsperado, resultado);
	}

	@Test
	public void concatenarListasNoVaciasTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resEsperado = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(3);
		l2.agregar(4);
		resEsperado.agregar(1);
		resEsperado.agregar(2);
		resEsperado.agregar(3);
		resEsperado.agregar(4);

		ListaInt resultado = ListaInt.concatenar(l1, l2);

		assertEquals(resEsperado, resultado);
	}

	@Test
	public void reversaListaVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt listaEsperada = new ListaInt();

		ListaInt resultado = lista.reversa();

		assertEquals(listaEsperada, resultado);
	}

	@Test
	public void reversaListaNoVaciaTest() {
		ListaInt lista = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		lista.agregar(1);
		lista.agregar(100);
		lista.agregar(24);
		listaEsperada.agregar(24);
		listaEsperada.agregar(100);
		listaEsperada.agregar(1);

		ListaInt resultado = lista.reversa();

		assertEquals(listaEsperada, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void combinarListasOrdenadasUnaListaNoOrdenadaTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		l2.agregar(1000);
		l2.agregar(3);

		ListaInt.combinarListasOrdenadas(l1, l2);
	}

	@Test
	public void combinarListasOrdenadasListasNoVaciasTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		l1.agregar(0);
		l1.agregar(400);
		l2.agregar(3);
		l2.agregar(1000);
		listaEsperada.agregar(0);
		listaEsperada.agregar(3);
		listaEsperada.agregar(400);
		listaEsperada.agregar(1000);

		ListaInt resultado = ListaInt.combinarListasOrdenadas(l1, l2);

		assertEquals(listaEsperada, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dameElementosEnPosicionesListaDePosicionesNoValidasTest() {
		ListaInt lista = new ListaInt(); 
		ListaInt posiciones = new ListaInt();
		lista.agregar(88);
		lista.agregar(107);
		posiciones.agregar(1);
		posiciones.agregar(-1);

		lista.dameElementosEnPosiciones(posiciones);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dameElementosEnPosicionesListaDePosicionesConDuplicadosTest() {
		ListaInt lista = new ListaInt(); 
		ListaInt posiciones = new ListaInt();
		lista.agregar(88);
		lista.agregar(99);
		posiciones.agregar(1);
		posiciones.agregar(1);

		lista.dameElementosEnPosiciones(posiciones);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dameElementosEnPosicionesListaDePosicionesNoOrdenadaTest() {
		ListaInt lista = new ListaInt(); 
		ListaInt posiciones = new ListaInt();
		lista.agregar(54);
		lista.agregar(3);
		posiciones.agregar(1);
		posiciones.agregar(0);

		lista.dameElementosEnPosiciones(posiciones);
	}

	@Test
	public void dameElementosEnPosicionesListaDePosicionesVaciaTest() {
		ListaInt lista = new ListaInt(); 
		ListaInt posiciones = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		lista.agregar(98);
		lista.agregar(44);

		ListaInt resultado = lista.dameElementosEnPosiciones(posiciones);

		assertEquals(listaEsperada, resultado);
	}

	@Test
	public void dameElementosEnPosicionesOkTest() {
		ListaInt lista = new ListaInt(); 
		ListaInt posiciones = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		lista.agregar(99);
		lista.agregar(55);
		lista.agregar(7);
		posiciones.agregar(1);
		posiciones.agregar(2);
		listaEsperada.agregar(55);
		listaEsperada.agregar(7);

		ListaInt resultado = lista.dameElementosEnPosiciones(posiciones);

		assertEquals(listaEsperada, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void interseccionUnaListaConDuplicadosTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(4);
		l2.agregar(4);

		ListaInt.interseccion(l1, l2);
	}

	@Test
	public void interseccionUnaListaVaciaTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);

		ListaInt resultado = ListaInt.interseccion(l1, l2);

		assertEquals(listaEsperada, resultado);
	}

	@Test
	public void interseccionListasNoVaciasInterseccionVaciaTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(4);
		l2.agregar(5);

		ListaInt resultado = ListaInt.interseccion(l1, l2);

		assertEquals(listaEsperada, resultado);
	}

	@Test
	public void interseccionListasNoVaciasInterseccionNoVaciaTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt listaEsperada = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(5);
		l2.agregar(1);
		l2.agregar(7);
		l2.agregar(2);
		listaEsperada.agregar(1);
		listaEsperada.agregar(2);

		ListaInt resultado = ListaInt.interseccion(l1, l2);

		assertEquals(listaEsperada, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void restaUnaListaConRepetidos() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(4);
		l2.agregar(4);

		ListaInt.resta(l1, l2);
	}

	@Test
	public void restaPrimeraListaVacia() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l2.agregar(4);
		l2.agregar(1);

		ListaInt resultado = ListaInt.resta(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void restaSegundaListaVacia() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l1.agregar(1);
		l1.agregar(4);
		resultadoEsperado.agregar(1);
		resultadoEsperado.agregar(4);

		ListaInt resultado = ListaInt.resta(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void restaListasLlenas() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l1.agregar(1);
		l1.agregar(4);
		l1.agregar(7);
		l2.agregar(4);
		l2.agregar(10);
		resultadoEsperado.agregar(1);
		resultadoEsperado.agregar(7);

		ListaInt resultado = ListaInt.resta(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void restaSimetricaUnaListaConDuplicadosTest() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		l1.agregar(1);
		l1.agregar(2);
		l2.agregar(4);
		l2.agregar(4);

		ListaInt.restaSimetrica(l1, l2);
	}

	@Test
	public void restaSimetricaPrimeraListaVacia() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l2.agregar(4);
		l2.agregar(1);
		resultadoEsperado.agregar(4);
		resultadoEsperado.agregar(1);

		ListaInt resultado = ListaInt.restaSimetrica(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void restaSimetricaSegundaListaVacia() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l1.agregar(4);
		l1.agregar(1);
		resultadoEsperado.agregar(4);
		resultadoEsperado.agregar(1);

		ListaInt resultado = ListaInt.restaSimetrica(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void restaSimetricaListasLlenas() {
		ListaInt l1 = new ListaInt();
		ListaInt l2 = new ListaInt();
		ListaInt resultadoEsperado = new ListaInt();
		l1.agregar(1);
		l1.agregar(4);
		l1.agregar(7);
		l2.agregar(4);
		l2.agregar(10);
		resultadoEsperado.agregar(1);
		resultadoEsperado.agregar(7);
		resultadoEsperado.agregar(10);

		ListaInt resultado = ListaInt.restaSimetrica(l1, l2);

		assertEquals(resultadoEsperado, resultado);
	}

	private ListaInt lista1EsperadaIntercambiarColasPosicionesDistintasDeCero() {
		ListaInt lista = new ListaInt();
		lista.agregar(2);
		lista.agregar(4);
		lista.agregar(5);
		lista.agregar(7);
		return lista;
	}

	private ListaInt lista2EsperadaIntercambiarColasPosicionesDistintasDeCero() {
		ListaInt lista = new ListaInt();
		lista.agregar(1);
		lista.agregar(3);
		lista.agregar(6);
		lista.agregar(8);
		return lista;
	}

	private ListaInt lista1EsperadaIntercambiarColasPosicionesIgualCero() {
		ListaInt lista = new ListaInt();
		lista.agregar(2);
		lista.agregar(4);
		lista.agregar(6);
		lista.agregar(8);
		return lista;
	}

	private ListaInt lista2EsperadaIntercambiarColasPosicionesIgualCero() {
		ListaInt lista = new ListaInt();
		lista.agregar(1);
		lista.agregar(3);
		lista.agregar(5);
		lista.agregar(7);
		return lista;
	}

}
