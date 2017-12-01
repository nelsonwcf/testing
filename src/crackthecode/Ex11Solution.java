import java.util.HashSet;

public class Ex11Solution {

    // My quick solution.
    // Time Complexity: O(n) Space Complexity: O(n)
    static boolean isUnique(String str) {
        if (str == null || str.isEmpty())
            return true;
        else {
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < str.length(); i++)
                hs.add(str.charAt(i));
            if (hs.size() == str.length())
                return true;
        }
        return false;
    }

    static boolean isUnique_v2(String str) {
        if (str == null || str.isEmpty())
            return true;
        else {
            for (int i = 0; i < str.length(); i++)
                for (int j = i + 1; j < str.length(); j++)
                    if (str.charAt(i) == str.charAt(j))
                        return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String str = "1234abcdefg";
        System.out.println(isUnique_v2(str));
    }
}