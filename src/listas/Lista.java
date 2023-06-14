package listas;

public class Lista<T extends Comparable<T>> {

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
		if (!existeIndice(indice))
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
		if (!existeIndice(indice) && indice != largo())
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
					actual = actual.siguiente;
				}
				actual.siguiente.siguiente = primero;
				primero = actual.siguiente;
				actual.siguiente = null;
			}
		}
	}

	public boolean isOrdenada() {
		if (isVacia())
			return true;
		Nodo<T> actual = primero;
		Nodo<T> siguiente = primero.siguiente;
		while (actual != null && siguiente != null) {
			if (actual.elemento.compareTo(siguiente.elemento) > 0)
				return false;
			actual = actual.siguiente;
			siguiente = actual.siguiente;
		}
		return true;
	}

	public void insertarOrdenado(T elem) {
		if (isOrdenada()) {
			if (isVacia())
				agregar(elem);
			else {
				int indice = 0;
				Nodo<T> actual = primero;

				while (actual != null && elem.compareTo(actual.elemento) > 0) {
					actual = actual.siguiente;
					indice++;
				}
				agregar(elem, indice);
			}
		}
	}

	public static <T extends Comparable<T>>void intercambiarColas(Lista<T> l1, int pos1, Lista<T> l2, int pos2) {
		if (l1.isVacia() || l2.isVacia())
			throw new IllegalArgumentException("Las listas no pueden estar vacías");
		if (!l1.existeIndice(pos1) || !l2.existeIndice(pos2))
			throw new IllegalArgumentException("Alguna de las posiciones no existe");

		Nodo<T> actual1 = l1.primero;
		Nodo<T> actual2 = l2.primero;
		int pos1Aux = 0;
		int pos2Aux = 0;

		while (pos1Aux < pos1) {
			actual1 = actual1.siguiente;
			pos1Aux++;
		}
		while (pos2Aux < pos2) {
			actual2 = actual2.siguiente;
			pos2Aux++;
		}
		T aux;
		while (actual1 != null && actual2 != null) {
			aux = actual1.elemento;
			actual1.elemento = actual2.elemento;
			actual2.elemento = aux;
			actual1 = actual1.siguiente;
			actual2 = actual2.siguiente;
		}
	}

	public Lista<Integer> buscarTodos(T elem) {
		Nodo<T> actual = primero;
		Lista<Integer> aparicionesElem = new Lista<Integer>();
		int pos = 0;
		while (actual != null) {
			if (actual.elemento.equals(elem))
				aparicionesElem.agregar(pos);
			actual = actual.siguiente;
			pos++;
		}
		return aparicionesElem;
	}

	public void anexar(Lista<T> otraLista) {
		if (this.isVacia())
			primero = otraLista.primero;
		else {
			Nodo<T> actual = primero;
			while (actual != null && actual.siguiente != null)
				actual = actual.siguiente;
			actual.siguiente = otraLista.primero;
		}
	}

	public static <T extends Comparable<T>> Lista<T> concatenar(Lista<T> l1, Lista<T> l2) {
		Lista<T> nueva = new Lista<T>();
		nueva.anexar(l1);
		nueva.anexar(l2);
		return nueva;
	}

	public Lista<T> reversa() {
		Lista<T> nueva = new Lista<T>();
		Nodo<T> actual = primero;
		int it = 0;
		while (it < largo()) {
			nueva.agregar(actual.elemento, 0);
			actual = actual.siguiente;
			it++;
		}
		return nueva;
	}

	public static <T extends Comparable<T>> Lista<T> combinarListasOrdenadas(Lista<T> l1, Lista<T> l2) {
		if (!l1.isOrdenada() || !l2.isOrdenada())
			throw new IllegalArgumentException("Las listas deben estar ordenadas");

		Nodo<T> actualL2 = l2.primero;
		Lista<T> nueva = new Lista<T>();
		nueva.anexar(l1);

		while (actualL2 != null) {
			T elemActual = actualL2.elemento;
			nueva.insertarOrdenado(elemActual);
			actualL2 = actualL2.siguiente;
		}
		return nueva;
	}

	public Lista<T> dameElementosEnPosiciones(Lista<Integer> posiciones) {
		if (!contieneTodosIndicesValidos(posiciones))
			throw new IllegalArgumentException("La lista contiene posiciones no válidas");
		if (!posiciones.isSinDuplicados())
			throw new IllegalArgumentException("La lista no puede tener posiciones repetidas");
		if (!posiciones.isOrdenada())
			throw new IllegalArgumentException("La lista de posiciones debe estar ordenada");

		Lista<T> nueva = new Lista<T>();
		Nodo<Integer> actual = posiciones.primero;
		int pos;
		T elemEnPos;
		while (actual != null) {
			pos = actual.elemento;
			elemEnPos = obtener(pos);
			nueva.agregar(elemEnPos);
			actual = actual.siguiente;
		}
		return nueva;
	}

	public static <T extends Comparable<T>> Lista<T> interseccion(Lista<T> l1, Lista<T> l2) {
		if (!l1.isSinDuplicados() || !l2.isSinDuplicados())
			throw new IllegalArgumentException("Las lsitas no deben contener elementos repetidos dentro de ellas");

		Lista<T> nueva = new Lista<T>();
		Nodo<T> actualL1 = l1.primero;
		T elem;

		while (actualL1 != null) {
			elem = actualL1.elemento;
			if (l2.contieneElem(elem))
				nueva.agregar(elem);
			actualL1 = actualL1.siguiente;
		}
		return nueva;
	}

	public static <T extends Comparable<T>> Lista<T> resta(Lista<T> l1, Lista<T> l2) {
		if (!l1.isSinDuplicados() || !l2.isSinDuplicados())
			throw new IllegalArgumentException("Dentro de cada lista no debe haber elementos duplicados");

		Lista<T> nueva = new Lista<T>();
		Nodo<T> actualL1 = l1.primero;
		T elemL1;

		while (actualL1 != null) {
			elemL1 = actualL1.elemento;
			if (!l2.contieneElem(elemL1))
				nueva.agregar(elemL1);
			actualL1 = actualL1.siguiente;
		}
		return nueva;
	}

	@Override
	public int hashCode() {
	    int result = 17;
	    Nodo<T> nodoActual = primero;

	    while (nodoActual != null) {
	        result = 31 * result + nodoActual.elemento.hashCode();
	        nodoActual = nodoActual.siguiente;
	    }
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;

	    Lista<?> other = (Lista<?>) obj;

	    if (this.largo() != other.largo())
	        return false;

	    Nodo<T> nodoActual = this.primero;
	    Nodo<?> nodoOtro = other.primero;

	    while (nodoActual != null && nodoOtro != null) {
	        if (!nodoActual.elemento.equals(nodoOtro.elemento))
	            return false;
	        nodoActual = nodoActual.siguiente;
	        nodoOtro = nodoOtro.siguiente;
	    }
	    return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Nodo<T> actual = primero;
		while (actual != null) {
			sb.append(actual.elemento);
			if (actual.siguiente != null)
				sb.append(", ");
			actual = actual.siguiente;
		}
		sb.append("]");
		return sb.toString();
	}

	private boolean existeIndice(int indice) {
		return indice >= 0 && indice < largo();
	}

	private boolean contieneTodosIndicesValidos(Lista<Integer> lista) {
		Nodo<Integer> actual = lista.primero;
		while (actual != null) {
			if (!existeIndice(actual.elemento))
				return false;
			actual = actual.siguiente;
		}
		return true;
	}

	private boolean contieneElem(T elem) {
		Nodo<T> actual = primero;
		while (actual != null) {
			if (actual.elemento.equals(elem))
				return true;
			actual = actual.siguiente;
		}
		return false;
	}

}
