package pilas;

import java.util.LinkedList;

public class PilaInt {

	private LinkedList<Integer> pila;

	public PilaInt() {
		this.pila = new LinkedList<Integer>();
	}

	public boolean estaVacia() {
		return pila.isEmpty();
	}

	public void apilar(int n) {
		pila.addLast(n);
	}

	public Integer desapilar() {
		if (!estaVacia())
			return null;
		return pila.removeLast();
	}

	public Integer tope() {
		if (estaVacia())
			return null;
		return pila.getLast();
	}

}
