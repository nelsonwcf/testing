package academic.cisc610;

public class Demo1 {
	public static void main(String args[]) {
		String a = " aa";
		String b = "a a";
		
		System.out.println(perm(a,b));
	}
	
	static boolean perm(String a, String b) {
		if (a.length() != b.length())
			return false;
		
		StringBuilder sb = new StringBuilder(b);

		for (int i = 0; i < a.length(); i++) {
			boolean found = false;
			for (int j = 0; j < b.length(); j++) {
				if (sb.charAt(j) == a.charAt(i)) {
					found = true;
					sb.setCharAt(j, (char)0xFF);
					break;
				}
			}
			if (found == false)
				return false;
		}
		return true;
	}
}
