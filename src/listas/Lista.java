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

	public T obtener(int indice) {
		if (isVacia())
			throw new NullPointerException("La lista está vacía");
		if (indice < 0 || indice >= largo())
			throw new IllegalArgumentException("La posición no existe");

		Nodo<T> actual = primero;
		int aux = 0;
		while (aux != indice) {
			actual = actual.siguiente;
			aux++;
		}
		return actual.elemento;
	}

	public void agregar(T elem, int indice) {
		if (indice < 0 || indice > largo())
			throw new IllegalArgumentException("La posición no es válida");

		Nodo<T> nuevo = new Nodo<T>();
		nuevo.elemento = elem;

		if (indice == 0) {
			nuevo.siguiente = primero;
			primero = nuevo;
		} else {
			Nodo<T> actual = primero;
			int aux = 0;

			while (aux < indice - 1) {
				actual = actual.siguiente;
				aux++;
			}
			nuevo.siguiente = actual.siguiente;
			actual.siguiente = nuevo;
		}
	}

	public boolean isSinDuplicados() {
		if (isVacia())
			return true;

		Nodo<T> actual = primero;
		Nodo<T> siguiente = actual.siguiente;

		while (actual != null && siguiente != null) {
			while (siguiente != null) {
				if (actual.elemento.equals(siguiente.elemento))
					return false;
				siguiente = siguiente.siguiente;
			}
			actual = actual.siguiente;
			siguiente = actual.siguiente;
		}
		return true;
	}

	public void rotarDerecha() {
		if (!isVacia() && !(largo() == 1)) {
			if (primero.siguiente == null) {
				primero.siguiente = primero;
				primero = primero.siguiente;
			} else {
				Nodo<T> actual = primero;
				while (actual.siguiente != null && actual.siguiente.siguiente != null) {
					System.out.println(actual.elemento);
					actual = actual.siguiente;
				}
				actual.siguiente.siguiente = primero;
				primero = actual.siguiente;
				actual.siguiente = null;
			}
		}
	}
}
