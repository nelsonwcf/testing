package scraps;

import java.util.ArrayList;
import java.util.HashSet;


// This algorithm doesn't work correctly.
public class PermutationsWithoutRepetitionSolution {
  public static ArrayList<ArrayList<Character>> generateAnagrams(String str) {
    if (str == null || str.isEmpty()) {
      return new ArrayList<>();
    }

    ArrayList<Character> charString = new ArrayList<>();
    for (Character c : str.toCharArray()) {
      charString.add(c);
    }

    return recAnag(charString, new ArrayList<Character>(), new ArrayList<ArrayList<Character>>());
  }

  private static ArrayList<ArrayList<Character>> recAnag(ArrayList<Character> stringList, ArrayList<Character> auxList, ArrayList<ArrayList<Character>> savedResults) {
    if (stringList.isEmpty()) {
      savedResults.add(new ArrayList<>(auxList));
      return savedResults;
    }

    HashSet<Character> sawBefore = new HashSet<>();

    for (int i = 0; i < stringList.size(); i++) {
      Character c = stringList.remove(i);
      if (!sawBefore.contains(c)) {
        sawBefore.add(c);
        auxList.add(c);
        recAnag(stringList, auxList, savedResults);
        auxList.remove(auxList.size() - 1);
        stringList.add(i, c);
      }
    }

    return savedResults;
  }

  public static void main(String[] args) {
    String str = "daaa";
    System.out.println(generateAnagrams(str).toString());
  }
}
