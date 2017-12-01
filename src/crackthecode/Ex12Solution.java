import java.util.HashMap;

public class Ex12Solution {

    // Simple problem. Complexity O(n+m), Space O(n+m)
    // Could be made space O(1) if it was clear the strings
    // could only hold ASCII characters.
    static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (!hm.containsKey(str1.charAt(i))) {
                hm.put(str1.charAt(i), 1);
            } else {
                hm.put(str1.charAt(i), hm.get(str1.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!hm.containsKey(str2.charAt(i)))
                return false;
            else if (hm.get(str2.charAt(i)) == 1)
                hm.remove(str2.charAt(i));
            else
                hm.put(str2.charAt(i), hm.get(str2.charAt(i)) - 1);

        }
        return true;
    }

    public static void main(String args[]) {
        String str1 = "abcdd";
        String str2 = "dabcc";

        System.out.println(isPermutation(str1, str2));
    }
}