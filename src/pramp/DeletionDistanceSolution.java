package pramp;

import java.util.HashMap;

public class DeletionDistanceSolution {
    static HashMap<String, Integer> hs = new HashMap<>();

    static int deletionDistance(String str1, String str2) {
        if (str1 == null || str2 == null)
            throw new RuntimeException();
        else
            return deletionDistanceAux(str1, str2);
    }


    // This example includes the technique called memoization
    static int deletionDistanceAux(String str1, String str2) {
        if (hs.containsKey(str1 + "_" + str2))
            return hs.get(str1 + "_" + str2);
        int result;

        if (str1.length() == 0)
            return str2.length();
        else if (str2.length() == 0)
            return str1.length();
        else if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1))
            result = deletionDistanceAux(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        else
            result = (1 + Math.min(
                    deletionDistanceAux(str1.substring(0, str1.length() - 1), str2),
                    deletionDistanceAux(str1, str2.substring(0, str2.length() - 1))
            ));
        hs.put(str1 + "_" + str2, result);
        return result;
    }

    public static void main(String args[]) {

        System.out.println(deletionDistance("abc", "def"));
    }
}
