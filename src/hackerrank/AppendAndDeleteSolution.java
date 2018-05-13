package hackerrank;

import java.io.*;
import java.util.*;

public class AppendAndDeleteSolution {

  // s <- t
  static String appendAndDelete(String s, String t, int k) {
    int minimumOperations = 0;
    int sLength = s.length();
    int tLength = t.length();
    int i = 0;

    if (sLength > tLength) {
      minimumOperations = sLength - tLength;
    }

    while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
      i++;
    }

    minimumOperations += Math.abs(t.length() - i);
    if (minimumOperations <= k) {
      return "Yes";
    }
    return "No";
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    String t = scanner.nextLine();
    int k = scanner.nextInt();
    scanner.close();
    System.out.println(appendAndDelete(s, t, k));

  }
}