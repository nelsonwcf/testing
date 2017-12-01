package projecteuler.P16;

import java.util.*;

public class Ex16 {
	public static void main(String argsp[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int carry = 0;

		a.add(2);

		for (int n = 1; n < 1000; n++) {
			int size = a.size();

			for (int i = 0; i < size; i++) {
				int cur = a.get(i) * 2 + carry;
				carry = 0;
				if (cur < 10) {
					a.set(i, cur);
				} else {
					a.set(i, cur % 10);
					if (i + 1 < a.size())
						carry = 1;
					else
						a.add(1);
				}
			}
		}
		int total = 0;
		for (int j = 0; j < a.size(); j++)
			total += a.get(j);
			System.out.print(total);
	}
}