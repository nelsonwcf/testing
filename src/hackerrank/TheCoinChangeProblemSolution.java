package hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TheCoinChangeProblemSolution {
  static long getWays(long n, long[] c) {
    if (c == null || c.length == 0 || n == 0) {
      return 0;
    }

    HashMap<Long, Long> memo = new HashMap<>();
    getWaysAux(n, c, memo, 0);
    return memo.get(n);
  }

  private static long getWaysAux(long n, long[] c, HashMap<Long, Long> memo, int currIndex) {
    if (memo.containsKey(n)) {
      return memo.get(n);
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

    memo.put(n, total);

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
