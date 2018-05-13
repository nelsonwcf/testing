package hackerrank;

import java.util.Scanner;

public class Day28Regex {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    String[] names = new String[n];
    for (int i = 0; i < n; i++) {
      names[i] = scanner.nextLine();
    }

    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
    }
  }
}
