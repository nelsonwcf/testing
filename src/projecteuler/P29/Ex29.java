package projecteuler.P29;

import java.math.BigInteger;
import java.util.HashSet;

public class Ex29 {
	public static void main(String args[]) {
		HashSet<BigInteger> hs = new HashSet<>();

		for (int a = 2; a <= 100; a++)
			for (int b = 2; b <= 100; b++) {
				BigInteger ba = BigInteger.valueOf(a);
				hs.add(ba.pow(b));
			}
		System.out.println(hs.size());
	}
}