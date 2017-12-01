package projecteuler.P27;

public class Ex27 {
	public static void main(String args[]) {
		boolean prime = true;
		int n = 0;
		int amax = 0, bmax = 0, nmax = 0;

		for (int a = -999; a < 1000; a++)
			for (int b = -1000; b <= 1000; b++) {
				while (isPrime((int) Math.pow(n, 2) + a * n + b)) {
					n++;
				}
				n--;
				amax = n > nmax ? a : amax;
				bmax = n > nmax ? b : bmax;
				nmax = n > nmax ? n : nmax;
				n = 0;
			}
		System.out.println(amax + " " + bmax + " " + nmax);
		System.out.println("Product: " + amax * bmax);
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i = i + 2)
			if (n % i == 0) {
				return false;
			}

		return true;
	}
}
