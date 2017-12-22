package skiena.manual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem714Solution {
  static String[] getPermutations(String str) {
    if (str == null || str.length() == 0) {
      return new String[0];
    }

    ArrayList<Character> al = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      al.add(str.charAt(i));
    }

    HashSet<String> result = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    recPerm(al, result, sb);
    String[] output = result.toArray(new String[0]);

    return output;
  }

  private static void recPerm(ArrayList<Character> al, HashSet<String> res, StringBuilder aux) {
    if (al.isEmpty()) {
      res.add(aux.toString());
      return;
    }

    for (int i = 0; i < al.size(); i++) {
      char c = al.get(i);
      aux.append(al.get(i));
      al.remove(i);
      recPerm(al, res, aux);
      al.add(i, c);
      aux.deleteCharAt(aux.length() - 1);
    }
  }

  public static void main(String[] args) {
    String str = "ovo";
    System.out.println(Arrays.toString(getPermutations(str)));
  }
}
