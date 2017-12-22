package skiena.manual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem715Solution {
  static HashSet<HashSet<String>> getCombinations(HashSet<String> set, int k) {
    if (set == null || set.isEmpty() || set.size() < k) {
      return new HashSet<>();
    }

    ArrayList<String> al = new ArrayList<>(set);
    HashSet<HashSet<String>> result = new HashSet<>();

    recComb(al, result, k);
    return result;
  }

  private static void recComb(ArrayList<String> list, HashSet<HashSet<String>> result, int k) {
    if (list.size() == k) {
      result.add(new HashSet<>(list));
    }

    for (int i = 0; i < list.size(); i++) {
      String sb = list.remove(i);
      recComb(list, result, k);
      list.add(i, sb);
    }
  }

  public static void main(String[] args) {
    HashSet<String> hs = new HashSet<>(Arrays.asList("Dragon", "Cake", "Bola", "Sword", "Female"));
    System.out.println(getCombinations(hs, 1).toString());
  }
}
