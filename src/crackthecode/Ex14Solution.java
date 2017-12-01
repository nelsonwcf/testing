import java.util.HashMap;

public class Ex14Solution {

    // Time Complexity O(n)
    // Space Complexity O(n)
    // There is a way to improve the space complexity to 1 byte if we consider case insensitive
    // palindromes written in languages that hold up to 64 characters using a byte and bit
    // manipulation.
    static boolean isPermPal(String str) {
        if (str == null)
            return false;
        else if (str.length() == 0)
            return true;
        else {
            str = str.toLowerCase();
            HashMap<Character, Integer> hm = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c != ' ')
                    if (!hm.containsKey(c))
                        hm.put(c, 1);
                    else
                        hm.put(c, hm.get(c) + 1);
            }

            boolean previous_odd = false;
            for (int i : hm.values())
                if (i % 2 == 1)
                    if (!previous_odd)
                        previous_odd = true;
                    else
                        return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String str = "Tact coa";
        System.out.println(isPermPal(str));
    }
}
