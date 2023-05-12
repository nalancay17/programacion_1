package listas;

public class Lista<T> {

	private Nodo<T> primero;

	public boolean isVacia() {
		return this.primero == null;
	}

	public int largo() {
		int cantNodos = 0;
		Nodo<T> actual = this.primero;
		while (actual != null) {
			cantNodos++;
			actual = actual.siguiente;
		}
		return cantNodos;
	}

	public void agregar(T elem) {
		Nodo<T> nuevoNodo = new Nodo<T>();
		nuevoNodo.elemento = elem;

		if (isVacia())
			primero = nuevoNodo;
		else {
			Nodo<T> actual = primero;
			while (actual.siguiente != null)
				actual = actual.siguiente;
			actual.siguiente = nuevoNodo;
		}
	}

	public T obtener(int posicion) {
		if (isVacia())
			throw new NullPointerException("La lista está vacía");
		if (posicion < 0 || posicion >= largo())
			throw new IllegalArgumentException("La posición no existe");

		Nodo<T> actual = primero;
		int aux = 0;
		while (aux != posicion) {
			actual = actual.siguiente;
			aux++;
		}
		return actual.elemento;
	}

}
