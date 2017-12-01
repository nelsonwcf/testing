package projecteuler.P20;

import java.util.*;

public class Ex20 {
	public static void main(String args[]) {
		// Start with number 100
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.addAll(Arrays.asList(0,0,1));
		
		for (int n = 99; n > 1; n--) {
			ArrayList<Integer> l = new ArrayList<>();
			int tmp = n;
			while (tmp > 0) {
				l.add(tmp % 10);
				tmp /= 10;
			}
			ar = arrayMultiplication(ar, new ArrayList<Integer>(l));
		}
		
		System.out.println(ar);
		
		int x = 0;
		for (int i : ar) {
			x += i;
		}
		System.out.println(x);
		
	}

	@SuppressWarnings("unchecked")
	static ArrayList<Integer> arrayMultiplication(ArrayList<Integer> ar, ArrayList<Integer> num) {
		
		ArrayList<Integer>[] ret = new ArrayList[num.size()];

		for (int i = 0; i < num.size(); i++) {
			ArrayList<Integer> tmp = new ArrayList<>(ar);
			
			// Add i zeros to the left -> multiplication
			for (int n = 0; n < i; n++) {
				tmp.add(0,0);
			}
			
			// Multiply by the unit
			int multiplier = num.get(i);
			int digit = 0;
			int carryover = 0;
			for (int j = 0; j < tmp.size(); j++) {
				digit = (tmp.get(j) * multiplier + carryover) % 10;
				carryover = (int) (tmp.get(j) * multiplier + carryover) / 10;
				tmp.set(j, digit);						
			}
			if (carryover > 0)
				tmp.add(carryover);
			
			ret[i] = tmp;
		}
		
		// Sum final return array
		// First create an array to hold all the values
		for (int i = 0; i < ret.length; i++) {
			while (ret[i].size() < ret[num.size() - 1].size())
				ret[i].add(0);
		}
		
		ArrayList<Integer> x = new ArrayList<>();
		
		int total = 0;
		int digit = 0;
		int carryover = 0;
		
		for (int i = 0; i < ret[0].size(); i++) {
			for (int j = 0; j < num.size(); j++) {
				total += ret[j].get(i);
			}
			digit = (total + carryover) % 10;
			carryover = (int) (total + carryover) / 10;
			x.add(digit);
			total = 0;
		}
		if (carryover > 0)
			x.add(carryover);
	
		return x;
	}

	static int sumArray(ArrayList<Integer> ar) {
		int total = 0;

		for (int i : ar) {
			total += i;
		}
		return total;
	}
}