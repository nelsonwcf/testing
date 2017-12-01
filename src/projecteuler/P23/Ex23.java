package projecteuler.P23;

public class Ex23 {
	public static void main(String args[]) {
		boolean[] b = abundantVector(100);
		
		for (int i = 1; i <= 100; i++)
			System.out.println(i + ": " + b[i]);
		
	}
	
	static boolean[] abundantVector(int n) {
		boolean[] a = new boolean[n+1];
		
		for (int i = 1; i <= 100; i++) {
			a[i] = isAbundant(i);
		}
		
		return a;
		
		
	}
	
	static boolean isAbundant(int n) {
		int total = 0;
		for (int i = 1; i < n / 2; i++)
			if (n % i == 0)
				total += i;
		
		if (total == n)
			return true;
		
		return false;
	}
}