package careercup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class NoTwoConsecutiveCharactersTheSameSolution {
  // Logic: if the highest frequency character count is lesser or equal
  // to the sum of all other frequencies + 1, it is possible to find a
  // permutation in which no two repeated characters exist
  static String stringIntercalation(String str) {
    if (str == null || str.length() <= 1) {
      return str;
    }

    // Frequency count
    HashMap<Character, Integer> freq = new HashMap<>();
    int maxFreq = 0;
    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      if (!freq.containsKey(str.charAt(i))) {
        freq.put(c, 1);
        if (maxFreq == 0) {
          maxFreq = 1;
        }
      } else {
        freq.put(c, freq.get(c) + 1);
        if (maxFreq < freq.get(c)) {
          maxFreq = freq.get(c);
        }
      }
    }

    // Check if such an array exists
    Integer total = 0;
    Character maxFreqChar = '\0';
    for (Character c : freq.keySet()) {
      if (maxFreq == freq.get(c)) {
        maxFreqChar = c;
      }
      total += freq.get(c);
    }
    total = total - maxFreq;
    if (maxFreq > total + 1) {
      return "";
    }

    // Get one possibility for this array
    StringBuilder sb = new StringBuilder();
    freq.remove(maxFreqChar);
    while (!freq.isEmpty()) {
      // Iterator required to modify Collection while iterating through it
      Iterator<Character> iter = freq.keySet().iterator();
      while (iter.hasNext()) {
        Character c = iter.next();
        sb.append(c);
        if (maxFreq > 0) {
          sb.append(maxFreqChar);
          maxFreq--;
        }
        if (freq.get(c) > 1) {
          freq.put(c, freq.get(c) - 1);
        } else {
          iter.remove();
        }
      }
    }
    if (maxFreq > 0) {
      sb.insert(0, maxFreqChar);
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    System.out.println(stringIntercalation("google"));
  }
}
