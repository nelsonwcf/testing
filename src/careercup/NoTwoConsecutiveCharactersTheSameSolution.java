package careercup;

import java.util.*;

public class NoTwoConsecutiveCharactersTheSameSolution {
  static String possibleIntercalation(String str) {

    // Bucketsorting by frequencies
    int[] freqArr = new int[128];
    Arrays.fill(freqArr, 0);

    for (int i = 0; i < str.length(); i++) {
      freqArr[(int) str.charAt(i)]++;
    }

    TreeMap<Integer, TreeSet<Character>> hm = new TreeMap<>((a, b) -> a.compareTo(b) * -1);
    for (int i = 0; i < 128; i++) {
      if (freqArr[i] > 0) {
        if (!hm.containsKey(freqArr[i])) {
          TreeSet<Character> ts = new TreeSet<>();
          ts.add((char) i);
          hm.put(freqArr[i], ts);
        } else {
          hm.get(freqArr[i]).add((char) i);
        }
      }
    }
    StringBuilder aux = new StringBuilder();
    for (TreeSet<Character> t : hm.values()) {
      for (char c : t) {
        while (freqArr[(int) c] > 0) {
          aux.append(c);
          freqArr[(int) c]--;
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length() - 1; i++) {
      char c = aux.charAt(0);
      aux.deleteCharAt(0);

      boolean foundOne = false;
      int j = 0;
      while (j < aux.length()  && !foundOne) {
        if (aux.charAt(0) == c) {
          result.append(c);
          foundOne = true;
        }
        else {
          aux = rotateString(aux, 1);
        }
        j++;
      }
      if (!foundOne && aux.length() > 1) {
        return "";
      }
    }
    result.append(aux);
    return result.toString();
  }

  private static StringBuilder rotateString(StringBuilder str, int pos) {
    if (str == null || str.length() == 1) {
      return str;
    }
    pos = pos % str.length();

    StringBuilder sb = new StringBuilder();
    sb.append(str.substring(pos, str.length())).append(str.substring(0, pos));
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(possibleIntercalation("baa"));
  }

}