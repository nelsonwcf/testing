package projecteuler.P33;

public class Ex33 {
	public static void main(String args[]) {
		int numerator = 1;
		int denominator = 1;

		for (int i = 10; i <= 99; i++)
			for (int j = 10; j <= 99; j++)
				if (isCurious(i, j)) {
					numerator *= i;
					denominator *= j;
				}
		
		int gcd = GCD(numerator,denominator);
		
		System.out.println(numerator / gcd + " " + denominator / gcd);
	}

	static boolean isCurious(int num, int den) {
		if (num < 0 || num > 99 || den < 0 || den > 99 || (double) num / den <= 0 || (double) num / den >= 1)
			return false;

		int a = num / 10;
		int b = num % 10;
		int c = den / 10;
		int d = den % 10;

		if (b != c)
			return false;

		double result = (double) a / d;
		double orig = (double) num / den;

		if (result == orig)
			return true;

		return false;
	}
	
	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}
}
