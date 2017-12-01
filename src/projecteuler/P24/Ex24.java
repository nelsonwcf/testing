package projecteuler.P24;

import java.util.*;

public class Ex24 {
	static int x = 0;
	static ArrayList<Character> al = new ArrayList<>();

	public static void main(String args[]) {
		String s = "0123456789";
		permute(s);
	}

	static void permute(String s) {
		char[] array = s.toCharArray();
		boolean[] bool = new boolean[s.length()];

		pp(array, bool, 0);
	}

	static void pp(char[] array, boolean[] bool, int level) {
		if (level == array.length - 1) {
			for (int i = 0; i < bool.length; i++)
				if (bool[i] == false)
					al.add(array[i]);
			x += 1;
			if (x == 1000000) {
				for (char c : al)
					System.out.print(c + " ");
			}
			al.remove(al.size() - 1);
		} else {
			for (int i = 0; i < array.length; i++)
				if (bool[i] == false) {
					bool[i] = true;
					al.add(array[i]);
					pp(array, bool, level + 1);
					al.remove(al.size() - 1);
					bool[i] = false;
				}
		}

	}
}