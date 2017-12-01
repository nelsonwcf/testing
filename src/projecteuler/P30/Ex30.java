package projecteuler.P30;

public class Ex30 {
	public static void main(String args[]) {
		long sum = 0L;
		for (int i = 2; i <= 999999; i++)
			if (isFifthPower(i)) {
				sum += (long) i;
				System.out.println(i);
			}
		System.out.println(sum);
	}

	static boolean isFifthPower(int n) {
		int sum = 0;
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			sum += (int) Math.pow(Character.getNumericValue(s.charAt(i)), 5);
		}
		if (sum == n)
			return true;
		return false;
	}
}
