package hackerrank;

import java.util.HashMap;
import java.util.HashSet;

public class TheCoinChangeProblemSolution {
  static long getWays(long n, long[] c) {
    if (c == null || c.length == 0 || n == 0) {
      return 0;
    }

    // build the frequency map
    HashMap<Long, Integer> aux = new HashMap<>();
    for (int i = 0; i < c.length; i++) {
      aux.put(c[i], 0);
    }

    // result will be contained here
    HashSet<HashMap<Long, Integer>> result = new HashSet<>();
    HashMap<Integer,Integer> memo = new HashMap<>();

    getWaysAux(n, c, result, aux, memo);

    return result.size();
  }

  private static void getWaysAux(long n, long[] c, HashSet<HashMap<Long, Integer>> result, HashMap<Long, Integer> aux,HashMap<Integer,Integer> memo ) {
    if (n == 0) {
      result.add(aux);
      return;
    }

    if (n < 0) {
      return;
    }

    for (int i = 0; i < c.length; i++) {
      aux.put(c[i], aux.get(c[i]) + 1);
      getWaysAux(n - c[i], c, result, aux);
      aux.put(c[i], aux.get(c[i]) - 1);
    }
  }

  public static void main(String[] args) {
    long[] c = {1, 2, 3};
    long n = 4;
    System.out.println(getWays(n, c));
  }
}
