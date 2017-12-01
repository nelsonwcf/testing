package projecteuler.P22;

import java.io.*;

public class Ex22 {
	static int inversions;

	public static void main(String args[]) {

		String[] s0 = null;

		try (BufferedReader f0 = new BufferedReader(new FileReader("input/p022_names.txt"))) {
			StringBuilder s = new StringBuilder();
			int aux = 0;

			while ((aux = f0.read()) != -1) {
				if (aux != '"')
					s.append((char) aux);
			}
			s0 = s.toString().split(",");

		} catch (IOException e) {
			System.out.println("File no found.");
		}

		quicksort(s0);

		for (int i = 0; i < 40; i++)
			System.out.println(s0[i]);

		int total = 0;
		int n = 1;
		for (String ss : s0) {
			total += n++ * wordValue(ss);
		}

		System.out.println(total);

	}

	static int wordValue(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int t = 0;
		for (String c : s.split(""))
			t += ((byte) c.charAt(0)) - 64;

		return t;

	}

	static <T extends Comparable<T>> void quicksort(T[] array) {
		// Empty or one element arrays are already sorted
		if (array.length > 1)
			qsort(array, 0, array.length - 1);
	}

	static <T extends Comparable<T>> void qsort(T[] array, int left, int right) {
		if (left < right) {
			int l = left;
			int r = right;
			T p = array[(l + r) / 2];

			while (l <= r) {
				while (array[l].compareTo(p) < 0)
					l++;
				while (array[r].compareTo(p) > 0)
					r--;
				if (l <= r) {
					T tmp = array[l];
					array[l] = array[r];
					array[r] = tmp;
					l++;
					r--;
				}
			}
			qsort(array, left, r);
			qsort(array, l, right);
		}
	}
}
