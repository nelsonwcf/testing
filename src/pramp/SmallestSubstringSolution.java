package pramp;

import java.util.HashMap;

public class SmallestSubstringSolution {

  // Time complexity O(n), n -> str size
  // Space complexity O(m), m -> arr size
  static String getShortestUniqueSubstring(char[] arr, String str) {
    if (arr == null || arr.length == 0) {
      return str.substring(0, 1);
    }

    if (str == null || str.length() == 0 || str.length() < arr.length) {
      return "";
    }

    HashMap<Character, Integer> map = new HashMap<>();
    int frontRunner = 0;
    int backRunner = 0;
    int minBackRunner = 0;
    int minFrontRunner = 0;
    int charactersFound = 0;
    int size = Integer.MAX_VALUE;

    // Initialize HashMap with the values from arr
    for (char c : arr) {
      map.put(c, 0);
    }

    while (frontRunner < str.length()) {
      // Add or Increment element in map
      if (map.containsKey(str.charAt(frontRunner))) {
        if (map.get(str.charAt(frontRunner)) == 0) {
          charactersFound++;
        }
        map.put(str.charAt(frontRunner), map.get(str.charAt(frontRunner)) + 1);
      }

      // Checking if all characters were found and if moving backRunner won't eliminate
      // one required character
      if (charactersFound == arr.length) {

        // If just found size is smaller than previous size; update size and min runners
        while (!map.containsKey(str.charAt(backRunner)) || map.get(str.charAt(backRunner)) > 1) {
          if (map.containsKey(str.charAt(backRunner))) {
            map.put(str.charAt(backRunner), map.get(str.charAt(backRunner)) - 1);
          }
          backRunner++;
        }
        if (frontRunner - backRunner + 1 < size) {
          size = frontRunner - backRunner + 1;
          minBackRunner = backRunner;
          minFrontRunner = frontRunner;
        }
      }
      frontRunner++;
    }
    return charactersFound == arr.length ? str.substring(minBackRunner, minFrontRunner + 1) : "";
  }


  public static void main(String[] args) {
    char[] array = {'A', 'B', 'C'};
    String str = "ADOBECODEBANCDDD";

    System.out.println(getShortestUniqueSubstring(array, str));

  }
}
