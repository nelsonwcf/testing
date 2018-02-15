package hackerrank;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.Scanner;

public class TheCoinChangeProblemSolution {

  static long getWays(long n, long[] c) {
    if (c == null || c.length == 0 || n == 0) {
      return 0;
    }

    // space complexity of O(n * c.length)
    HashMap<Pair, Long> memo = new HashMap<>();
    return getWaysAux(n, c, memo, 0);
  }

  // will have to check n elements c.length times
  // runtime complexity O(n * c.length)
  private static long getWaysAux(long n, long[] c, HashMap<Pair, Long> memo, int currIndex) {
    Pair p = new Pair<>(n, currIndex);
    if (memo.containsKey(p)) {
      return memo.get(p);
    }

    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return 0;
    }

    long total = 0;
    for (int i = currIndex; i < c.length; i++) {
      total += getWaysAux(n - c[i], c, memo, i);
    }

    memo.put(p, total);
    return total;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    long[] c = new long[m];
    for (int c_i = 0; c_i < m; c_i++) {
      c[c_i] = in.nextLong();
    }
    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
    long ways = getWays(n, c);
    System.out.println(ways);
  }
}
