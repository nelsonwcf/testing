package projecteuler.P26;

import java.util.HashSet;

public class Ex26 {
	public static void main(String args[]) {
		int currSize = 0;
		int maxSize = 0;
		int maxNumber = 0;
		
		for (int i = 1; i < 1000; i++) {
			currSize = acycDiv(i);
			maxSize = maxSize > currSize ? maxSize : currSize;
			maxNumber = maxSize > currSize ? maxNumber : i;
		}
		System.out.println(maxSize);
		System.out.println(maxNumber);
	}

	// Returns a String representing the periodic cycle of a division
	static Integer acycDiv(int d) {
		HashSet<String> repeatedDividend = new HashSet<>();
		HashSet<String> repeatedDividendSec = new HashSet<>();
		boolean secondCycle = false;
		String dividend = "1", divisor = Integer.toString(d);
		StringBuilder quotient = new StringBuilder(), activeDividend = new StringBuilder();
		int i = 0, size = 0;

		// This deals with the integer part
		for (i = 0; i < dividend.length(); i++) {
			activeDividend.append(dividend.charAt(i));
			quotient.append((Integer) Integer.parseInt(activeDividend.toString()) / Integer.parseInt(divisor));
			activeDividend.replace(0, activeDividend.length(),
					Integer.toString(Integer.parseInt(activeDividend.toString()) - Integer.parseInt(divisor)
							* Integer.parseInt(Character.toString(quotient.toString().charAt(i)))));
		}
		i++;
		quotient.append(".");
		while (Integer.parseInt(activeDividend.toString()) != 0) {
			activeDividend.append("0");
			if (repeatedDividendSec.contains(activeDividend.toString()))
				break;
			if (repeatedDividend.contains(activeDividend.toString())) {
				secondCycle = true;
				size++;
			}
			if (!secondCycle) 
				repeatedDividend.add(activeDividend.toString());
			else
				repeatedDividendSec.add(activeDividend.toString());				
			quotient.append((Integer) Integer.parseInt(activeDividend.toString()) / Integer.parseInt(divisor));
			activeDividend.replace(0, activeDividend.length(),
					Integer.toString(Integer.parseInt(activeDividend.toString()) - Integer.parseInt(divisor)
							* Integer.parseInt(Character.toString(quotient.toString().charAt(i)))));
			i++;
		}

		return size;
	}

}
