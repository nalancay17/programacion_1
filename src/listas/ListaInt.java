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
		if(isVacia())
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

	private boolean existeIndice(int indice) {
		return 0 <= indice && indice < largo();
	}

}
