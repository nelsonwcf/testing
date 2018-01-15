package scraps;

import java.util.ArrayList;
import java.util.HashSet;

public class StringCombinationSolution {
  static HashSet<ArrayList<String>> getAllCombinations(String[][] input) {
    if (input == null || input.length == 0) {
      return new HashSet<>();
    }

    ArrayList<String> aux = new ArrayList<>();
    HashSet<ArrayList<String>> results = new HashSet<>();

    rec(input, 0, aux, results);
    return results;
  }

  private static void rec(String[][] input, int currentSet, ArrayList<String> aux, HashSet<ArrayList<String>> results) {
    if (currentSet > input.length - 1) {
      results.add(new ArrayList<>(aux));
      return;
    }

    for (int i = 0; i < input[currentSet].length; i++) {
      aux.add(input[currentSet][i]);
      rec(input, currentSet + 1, aux, results);
      aux.remove(aux.size() - 1);
    }
  }

  public static void main(String[] args) {
    String[][] input = {{"grey", "black"}, {"fox", "dog"}, {"jumped", "ran", "growled"}};
    System.out.println(getAllCombinations(input).toString());
  }
}
