package careercup;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSubsetsSolution {

  // If the array contains repeat characters, an additional pass
  // is needed to add the characters to a set to remove the repeated ones
  public static String[] findAllSubsets(char[] array) {
    if (array == null || array.length == 0) {
      return new String[0];
    }

    ArrayList<StringBuilder> subset = new ArrayList<>();
    subset.add(new StringBuilder(""));
    for (char c : array) {
      int last = subset.size();
      for (int i = 0; i < last; i++) {
        subset.add(new StringBuilder(subset.get(i)).append(c));
      }
    }
    String[] result = new String[subset.size()];
    for (int i = 0; i < subset.size(); i++) {
      result[i] = subset.get(i).toString();
    }
    return result;
  }

  public static void main(String[] args) {
    char[] array = {'a','b','c'};
    System.out.println(Arrays.toString(findAllSubsets(array)));
  }
}
