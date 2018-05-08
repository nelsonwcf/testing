package hackerrank;

import java.util.Scanner;

public class Day29BitwiseANDSolution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    int max;

    for (int count = 0; count < t; count++) {
      max = 0;
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
          if ((i & j) > max && (i & j) < k) {
            max = (i & j);
          }
        }
      }
      System.out.println(max);
    }
  }
}
