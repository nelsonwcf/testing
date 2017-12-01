package projecteuler.P32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ex32 {
	public static void main(String args[]) {

		HashSet<Integer> hi = new HashSet<>();
		for (int i = 1; i <= 9876; i++)
			for (int j = 1; j <= 9876; j++)
				if (isPanDigital(i,j,i*j))
					hi.add(i*j);
		
		int sum = 0;
		for (Integer x : hi)
			sum += x;
		
		System.out.println(sum);
		
	}

	static boolean isPanDigital(int f1, int f2, int prod) {
		HashSet<Character> ref = new HashSet<>();
		ref.addAll(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		
		ArrayList<Character> al = new ArrayList<>();
		for (Character c : Integer.toString(f1).toCharArray())
			al.add(c);
		for (Character c : Integer.toString(f2).toCharArray())
			al.add(c);
		for (Character c : Integer.toString(prod).toCharArray())
			al.add(c);
		
		for (Character c : ref) {
			if(!al.remove(c))
				return false;
		}
		
		if (!al.isEmpty())
			return false;
		
		return true;
	}
}
