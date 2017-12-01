package projecteuler.P17;

import java.util.*;

public class Ex17 {
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	static final String A = "and";
	static final String H = "";
	static final String S = "";

	public static void main(String args[]) {
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
		map.put(100, "hundred");
		map.put(1000, "onethousand");

		 int total = 0;
		 for (int n = 1; n <= 1000; n++) {
		 total += name_count(n);
		 }
		 System.out.println(total);
		

	}

	static int name_count(int n) {

		int md = n % 100;
		int dv = (int) n / 100;

		// Numbers x01 to x19
		if (md > 0 & md < 20) {
			if (dv == 0) {
				System.out.println(map.get(md));
				System.out.println(map.get(md).length());
				return map.get(md).length();
			} else {
				System.out.println(map.get(dv) + S + map.get(100) + A + map.get(md));
				System.out.println(
						map.get(dv).length() + S.length() + map.get(100).length() + A.length() + map.get(md).length());
				return map.get(dv).length() + S.length() + map.get(100).length() + A.length() + map.get(md).length();
			}
		}

		int md10 = md % 10;
		int dv10 = (int) 10 * (md / 10);

		// Numbers x20 to x99
		if (md >= 20) {
			if (dv == 0) {
				if (md10 == 0) {
					System.out.println(map.get(md));
					System.out.println(map.get(md).length());
					return map.get(md).length();
				} else {
					System.out.println(map.get(dv10) + H + map.get(md10));
					System.out.println(map.get(dv10).length() + H.length() + map.get(md10).length());
					return map.get(dv10).length() + H.length() + map.get(md10).length();
				}

			} else {
				if (md10 == 0) {
					System.out.println(map.get(dv) + S + map.get(100) + A + map.get(md));
					System.out.println(map.get(dv).length() + S.length() + map.get(100).length() + A.length()
							+ map.get(md).length());
					return map.get(dv).length() + S.length() + map.get(100).length() + A.length()
							+ map.get(md).length();
				} else {
					System.out.println(map.get(dv) + S + map.get(100) + A + map.get(dv10) + H + map.get(md10));
					System.out.println(map.get(dv).length() + S.length() + map.get(100).length() + A.length()
							+ map.get(dv10).length() + H.length() + map.get(md10).length());
					return map.get(dv).length() + S.length() + map.get(100).length() + A.length()
							+ map.get(dv10).length() + H.length() + map.get(md10).length();
				}
			}
		}
		
		if (n == 1000) {
			System.out.println(map.get(1000));
			System.out.println(map.get(1000).length());
			return map.get(1000).length();
		}

			System.out.println(map.get(dv) + map.get(100));
			System.out.println(map.get(dv).length() + map.get(100).length());
			return map.get(dv).length() + map.get(100).length();
		}

	}
