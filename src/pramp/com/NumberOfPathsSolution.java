package pramp.com;

import javafx.util.Pair;

import java.util.HashMap;

public class NumberOfPathsSolution {
  static int numOfPathsToDest(int n) {
    if (n <= 0) {
      return 0;
    }

    HashMap<Pair<Integer, Integer>, Integer> hm = new HashMap<>();
    return recSol(n, 0, 0, hm);
  }

  private static int recSol(int n, int x, int y, HashMap<Pair<Integer, Integer>, Integer> hm) {
    Pair<Integer, Integer> p = new Pair<>(x, y);

    if (hm.containsKey(p)) {
      return hm.get(p);
    }

    if (x == n - 1 && y == n - 1) {
      return 1;
    }

    if (x > n - 1 || y > n - 1 || y > x) {
      return 0;
    }

    int result = recSol(n, x + 1, y, hm) + recSol(n, x, y + 1, hm);
    hm.put(new Pair<>(x, y), result);

    return result;
  }
}
