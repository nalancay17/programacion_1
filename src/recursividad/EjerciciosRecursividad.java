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

	public static int log(int n, int b) { //parcial 21/11/2018 turno mañana
		if (n < 0 || b < 0)
			throw new IllegalArgumentException("Los números a ingresar deben ser positivos");
		if (n == 0 && b == 0)
			throw new IllegalArgumentException("La división por cero no está definida");
		if (n == 0)
			return 0;
		return 1 + log(n/b, b);
	}

	public static String quitarCadena(String s, String t) { //final 16/05/2019
		if (s.length() == 0 || t.length() == 0)
			return s;
		if (s.charAt(0) == t.charAt(0))
			return quitarCadena(resto(s), resto(t));
		return s.charAt(0) + quitarCadena(resto(s), t);
	}

	public static String laMar(String s) { // parcial 11/7/2020 turno mañana
		if (s.length() == 0)
			return "";
		if (esVocal(s.charAt(0)))
			return "a" + laMar(resto(s));
		return "" + s.charAt(0) + s.charAt(0) + laMar(resto(s));
	}

	public static String eliminarVocalesRodeadasPorConsonantes(String s) { // recuperatorio parcial 25/07/2020
		if (s.length() <= 2)
			return s;
		if (!esVocal(s.charAt(0)) && esVocal(s.charAt(1)) && !esVocal(s.charAt(2)))
			return s.charAt(0) + eliminarVocalesRodeadasPorConsonantes(resto(resto(s)));
		return s.charAt(0) + eliminarVocalesRodeadasPorConsonantes(resto(s));
	}

	public static String letrasMayores(String s1, String s2) { // parcial 12/06/2019 turno mañana
		if (s1.length() == 0 || s2.length() == 0) {
			if (s1.length() > s2.length())
				return s1;
			return s2;
		}
		if (s1.charAt(0) > s2.charAt(0))
			return s1.charAt(0) + letrasMayores(resto(s1), resto(s2));
		return s2.charAt(0) + letrasMayores(resto(s1), resto(s2));
	}

	public static String eliminarVocalesYRevertir(String s) { // parcial 14/11/2019 turno noche
		if (s.length() == 0)
			return "";
		if (esVocal(s.charAt(0)))
			return eliminarVocalesYRevertir(resto(s));
		return eliminarVocalesYRevertir(resto(s)) + s.charAt(0);
	}

	public static String extremos(String s, int n, int m) { //recuperatorio 27/06/2019 turno noche
		if (n <= 0 && m <= 0)
			return "";
		if (n != 0)
			return s.charAt(0) + extremos(resto(s), n-1, m);
		return s.charAt(s.length() - m) + extremos(resto(s), n, m - 1);
	}

	public static String estaPrimero(String s1, String s2) { // parcial 12/06/2019 turno tarde
		if (s1.length() == 0)
			return s1;
		if (s2.length() == 0)
			return s2;
		if (s1.charAt(0) < s2.charAt(0))
			return s1;
		if (s2.charAt(0) < s1.charAt(0))
			return s2;
		return s1.charAt(0) + estaPrimero(resto(s1), resto(s2)); //el primer caracter es igual en ambos
	}

	public static String separarVocales(String s) { //parcial 13/11/2019 turno mañana
		if (s.length() == 0)
			return "";
		if (esVocal(s.charAt(0)))
			return separarVocales(resto(s)) + s.charAt(0);
		return s.charAt(0) + separarVocales(resto(s));
	}

	private static boolean esPar(int n) {
		return n % 2 == 0;
	}

	private static boolean esVocal(char c) {
		return c == 'a' || c == 'i' || c == 'u' || c== 'e' || c == 'o';
	}

	private static String resto(String s) {
		String nuevaS = "";
		for (int i = 1; i < s.length(); i++) {
			nuevaS += s.charAt(i);
		}
		return nuevaS;
	}

}
