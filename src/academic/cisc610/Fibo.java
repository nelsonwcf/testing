package academic.cisc610;

import java.util.*;

public class Fibo {

	
	
	public static void main(String args[]) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		System.out.println(fibonacci(12,hm));

	}

	static int fibonacci(int n, HashMap<Integer,Integer> hm) {
		int res;
		if (hm.containsKey(n))
			return hm.get(n);
		
		if (n <= 2)
			return 1;
		else
			res = fibonacci(n - 1,hm) + fibonacci(n - 2,hm);
		hm.put(n, res);
		return res;
	}
}
