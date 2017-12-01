package projecteuler.P35;

import java.util.Arrays;

public class Ex35 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i < 1000000; i++)
			if (isCircularPrime(i))
				count++;
		System.out.println(count);
	}

	static boolean isPrime(int n) {
		if (n >= -1 && n <= 1)
			return false;
		
		else if (n == 2)
			return true;
		
		else if (n % 2 == 0)
			return false;

		else {
			for (int i = 3; i <= Math.sqrt(n); i += 2)
				if (n % i == 0)
					return false;
		}

		return true;
	}

	static boolean isCircularPrime(int n) {
		if (!isPrime(n))
			return false;
		else {
			char c[] = Integer.toString(n).toCharArray();
			char tmp;

			for (int i = 1; i < c.length; i++) {
				tmp = c[c.length - 1];
				for (int j = c.length - 1; j > 0; j--)
					c[j] = c[j - 1];
				c[0] = tmp;
				if (!isPrime(Integer.parseInt(String.copyValueOf(c))))
					return false;
			}
			return true;
			
		}
	}
}
