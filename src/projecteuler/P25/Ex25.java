package projecteuler.P25;

import java.math.BigInteger;

public class Ex25 {
	public static void main(String args[]) {
		BigInteger fn0 = BigInteger.ONE;
		BigInteger fn1 = BigInteger.ONE;
		BigInteger temp = BigInteger.ZERO;

		int index = 3;
		temp = fn0.add(fn1);

		while (temp.toString().length() < 1000) {
			fn0 = fn1;
			fn1 = temp;
			temp = fn0.add(fn1);
			index++;
		}
		System.out.println(index);
	}
}
