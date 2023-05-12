package recursividad;

public class EjerciciosRecursividad {

	public static int sumatoria(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("El número ingresado debe ser entero positivo");
		if (n == 1)
			return 1;
		return n + sumatoria(n - 1);
	}

	public static int sumatoriaPares(int n) {
		if (n < 2)
			throw new IllegalArgumentException("El número ingresado debe ser entero positivo");
		if (n == 2)
			return 2;
		if (!EjerciciosRecursividad.esPar(n))
			return sumatoriaPares(n - 1);
		return n + sumatoriaPares(n - 2);
	}

	public static double potencia(double x, int n) {
		if (x == 0 && n == 0)
			throw new IllegalArgumentException("La base y el exponente no pueden ser cero");
		if (n < 0)
			throw new IllegalArgumentException("Este método no trabaja con exponentes negativos");
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		return x * potencia(x, n - 1);
	}

	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("El número no puede ser negativo");
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	private static boolean esPar(int n) {
		return n % 2 == 0;
	}
}
