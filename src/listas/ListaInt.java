package listas;

public class ListaInt {

	private NodoInt primero;

	public boolean isVacia() {
		return primero == null;
	}

	public int largo() {
		int largo = 0;
		NodoInt actual = primero;
		while (actual != null) {
			largo++;
			actual = actual.siguiente;
		}
		return largo;
	}

	public void agregar(int n) {
		NodoInt nuevo = new NodoInt();
		nuevo.elemento = n;
		if (isVacia())
			primero = nuevo;
		else {
			NodoInt actual = primero;
			while (actual.siguiente != null) {
				actual = actual.siguiente;
			}
			actual.siguiente = nuevo;
		}
	}

	public int obtener(int indice) {
		if (isVacia())
			throw new IllegalArgumentException("La lista está vacía");
		if (!existeIndice(indice))
			throw new IllegalArgumentException("El índice no existe");
		int posActual = 0;
		NodoInt actual = primero;
		while (indice != posActual) {
			posActual++;
			actual = actual.siguiente;
		}
		return actual.elemento;
	}

	public void agregar(int elem, int indice) {
		if (!existeIndice(indice) && indice != largo())
			throw new IllegalArgumentException("La posición no es válida");

		NodoInt nuevo = new NodoInt();
		nuevo.elemento = elem;
		if (indice == 0) {
			nuevo.siguiente = primero;
			primero = nuevo;
		} else {
			int pos = 0;
			NodoInt actual = primero;
			while (pos != indice - 1) {
				pos++;
				actual = actual.siguiente;
			}
			nuevo.siguiente = actual.siguiente;
			actual.siguiente = nuevo;
		}
	}

	public boolean isSinDuplicados() {
		NodoInt actual = primero;
		NodoInt aux;
		while (actual != null) {
			aux = actual.siguiente;
			while (aux != null) {
				if (actual.elemento == aux.elemento)
					return false;
				aux = aux.siguiente;
			}
			actual = actual.siguiente;
		}
		return true;
	}

	public void rotarDerecha() {
		if (isVacia() || primero.siguiente == null)
			return;
		NodoInt actual = primero;
		while (actual.siguiente != null && actual.siguiente.siguiente != null) {
			actual = actual.siguiente;
		}
		actual.siguiente.siguiente = primero;
		primero = actual.siguiente;
		actual.siguiente = null;
	}

	public boolean isOrdenada() {
		if (isVacia() || primero.siguiente == null)
			return true;
		NodoInt actual = primero;
		while (actual.siguiente != null) {
			if (actual.elemento > actual.siguiente.elemento)
				return false;
			actual = actual.siguiente;
		}
		return true;
	}

	public void insertarOrdenado(int elem) {
		if (isOrdenada()) {
			if (isVacia())
				agregar(elem);
			else {
				int indice = 0;
				NodoInt actual = primero;

				while (actual != null && elem > actual.elemento) {
					actual = actual.siguiente;
					indice++;
				}
				agregar(elem, indice);
			}
		}
	}

	public static void intercambiarColas(ListaInt l1, int pos1, ListaInt l2, int pos2) {
		if (!l1.existeIndice(pos1) || !l2.existeIndice(pos2))
			throw new IllegalArgumentException("Las posiciones no son válidas");

		NodoInt actual1 = l1.primero;
		NodoInt actual2 = l2.primero;
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
		int aux;
		while (actual1 != null && actual2 != null) {
			aux = actual1.elemento;
			actual1.elemento = actual2.elemento;
			actual2.elemento = aux;
			actual1 = actual1.siguiente;
			actual2 = actual2.siguiente;
		}
	}

	public ListaInt buscarTodos(int elem) {
		ListaInt posiciones = new ListaInt();
		NodoInt actual = primero;
		int pos = 0;
		while (actual != null) {
			if (actual.elemento == elem)
				posiciones.agregar(pos);
			actual = actual.siguiente;
			pos++;
		}
		return posiciones;
	}

	public void anexar(ListaInt lista) {
		if (isVacia())
			primero = lista.primero;
		else {
			NodoInt actual = primero;
			while (actual.siguiente != null) {
				actual = actual.siguiente;
			}
			actual.siguiente = lista.primero;
		}
	}

	public static ListaInt concatenar(ListaInt l1, ListaInt l2) {
		ListaInt nueva = new ListaInt();
		nueva.anexar(l1);
		nueva.anexar(l2);
		return nueva;
	}

	public ListaInt reversa() {
		ListaInt nueva = new ListaInt();
		NodoInt actual = primero;
		int it = 0;
		while (it < largo()) {
			nueva.agregar(actual.elemento, 0);
			actual = actual.siguiente;
			it++;
		}
		return nueva;
	}

	public static ListaInt combinarListasOrdenadas(ListaInt l1, ListaInt l2) {
		if (!l1.isOrdenada() || !l2.isOrdenada())
			throw new IllegalArgumentException("Las listas no están ordenadas");
		NodoInt actualL2 = l2.primero;
		ListaInt nueva = new ListaInt();
		nueva.anexar(l1);

		while (actualL2 != null) {
			int elemActual = actualL2.elemento;
			nueva.insertarOrdenado(elemActual);
			actualL2 = actualL2.siguiente;
		}
		return nueva;
	}

	public ListaInt dameElementosEnPosiciones(ListaInt posiciones) {
		if (!contieneTodosIndicesValidos(posiciones))
			throw new IllegalArgumentException("La lista contiene posiciones no válidas");
		if (!posiciones.isSinDuplicados())
			throw new IllegalArgumentException("La lista no puede tener posiciones repetidas");
		if (!posiciones.isOrdenada())
			throw new IllegalArgumentException("La lista de posiciones debe estar ordenada");

		ListaInt nueva = new ListaInt();
		NodoInt actual = posiciones.primero;
		int pos;
		int elemEnPos;
		while (actual != null) {
			pos = actual.elemento;
			elemEnPos = obtener(pos);
			nueva.agregar(elemEnPos);
			actual = actual.siguiente;
		}
		return nueva;
	}

	public static ListaInt interseccion(ListaInt l1, ListaInt l2) {
		if (!l1.isSinDuplicados() || !l2.isSinDuplicados())
			throw new IllegalArgumentException("Las lsitas no deben contener elementos repetidos dentro de ellas");

		ListaInt nueva = new ListaInt();
		NodoInt actualL1 = l1.primero;
		int elem;

		while (actualL1 != null) {
			elem = actualL1.elemento;
			if (l2.contieneElem(elem))
				nueva.agregar(elem);
			actualL1 = actualL1.siguiente;
		}
		return nueva;
	}

	public static ListaInt resta(ListaInt l1, ListaInt l2) {
		if (!l1.isSinDuplicados() || !l2.isSinDuplicados())
			throw new IllegalArgumentException("Dentro de cada lista no debe haber elementos duplicados");

		ListaInt nueva = new ListaInt();
		NodoInt actualL1 = l1.primero;
		int elemL1;

		while (actualL1 != null) {
			elemL1 = actualL1.elemento;
			if (!l2.contieneElem(elemL1))
				nueva.agregar(elemL1);
			actualL1 = actualL1.siguiente;
		}
		return nueva;
	}

	public static ListaInt restaSimetrica(ListaInt l1, ListaInt l2) {
		if (!l1.isSinDuplicados() || !l2.isSinDuplicados())
			throw new IllegalArgumentException("Dentro de cada lista no debe haber elementos duplicados");

		return concatenar(resta(l1, l2), resta(l2, l1));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		NodoInt actual = primero;
		while (actual != null) {
			sb.append(actual.elemento);
			if (actual.siguiente != null)
				sb.append(", ");
			actual = actual.siguiente;
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int result = 17;
		NodoInt actual = primero;

		while (actual != null) {
			result = 31 * result + actual.elemento;
			actual = actual.siguiente;
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		ListaInt other = (ListaInt) obj;

		if (this.largo() != other.largo())
			return false;

		NodoInt actual = this.primero;
		NodoInt otro = other.primero;

		while (actual != null && otro != null) {
			if (actual.elemento != otro.elemento)
				return false;
			actual = actual.siguiente;
			otro = otro.siguiente;
		}
		return true;
	}

	private boolean existeIndice(int indice) {
		return 0 <= indice && indice < largo();
	}

	private boolean contieneTodosIndicesValidos(ListaInt lista) {
		NodoInt actual = lista.primero;
		while (actual != null) {
			if (!existeIndice(actual.elemento))
				return false;
			actual = actual.siguiente;
		}
		return true;
	}

	private boolean contieneElem(int elem) {
		NodoInt actual = primero;
		while (actual != null) {
			if (actual.elemento == elem)
				return true;
			actual = actual.siguiente;
		}
		return false;
	}

}
