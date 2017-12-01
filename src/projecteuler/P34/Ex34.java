package projecteuler.P34;

import java.util.HashMap;

public class Ex34 {
	public static void main(String args[]) {
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('0', 1);
		hm.put('1', 1);
		hm.put('2', 1 * 2);
		hm.put('3', 1 * 2 * 3);
		hm.put('4', 1 * 2 * 3 * 4);
		hm.put('5', 1 * 2 * 3 * 4 * 5);
		hm.put('6', 1 * 2 * 3 * 4 * 5 * 6);
		hm.put('7', 1 * 2 * 3 * 4 * 5 * 6 * 7);
		hm.put('8', 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8);
		hm.put('9', 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9);

		int total = 0;
		for (int i = 3; i < 100000000; i++)
			if(isCurious(i, hm))
				total += i;
		
		System.out.println(total);
	}

	static boolean isCurious(int n, HashMap<Character, Integer> hm) {
		if (n <= 2)
			return false;
		else {

			char[] c = Integer.toString(n).toCharArray();

			int sum = 0;
			for (Character x : c)
				sum += hm.get(x);

			if (sum == n)
				return true;
			return false;
		}
	}
}
