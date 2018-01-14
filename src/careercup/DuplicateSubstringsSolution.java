package careercup;

import java.util.HashMap;

public class DuplicateSubstringsSolution {
  /*
  Time Complexity: O(String size x k size)
  Space Complexity: O(String size x k size)
  */
  static void printDuplicateStrings(String str, int k) {
    if (str == null || str.length() == 0 || k <= 0) {
      return;
    }

    HashMap<String, Integer> substrings = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      StringBuilder aux = new StringBuilder();
      if (i <= str.length() - k) {
        for (int j = i; j < i + k; j++) {
          aux.append(str.toLowerCase().charAt(j));
        }
        if (!substrings.containsKey(aux.toString())) {
          substrings.put(aux.toString(), 1);
        } else {
          substrings.put(aux.toString(), substrings.get(aux.toString()) + 1);
        }
      }
    }

    for (String s : substrings.keySet()) {
      if (substrings.get(s) > 1) {
        System.out.println(s + " " + substrings.get(s));
      }
    }
  }
}
