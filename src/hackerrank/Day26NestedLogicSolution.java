package hackerrank;

import java.util.Scanner;

public class Day26NestedLogicSolution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int day = scanner.nextInt();
    int month = scanner.nextInt();
    int year = scanner.nextInt();
    int dueDay = scanner.nextInt();
    int dueMonth = scanner.nextInt();
    int dueYear = scanner.nextInt();

    int fine = 0;
    if (year < dueYear || year == dueYear && month < dueMonth || year == dueYear && month == dueMonth && day <= dueDay) {
      fine = 0;
    }

    if (year == dueYear && month == dueMonth && day > dueDay) {
      fine = (day - dueDay) * 15;
    }

    if (year == dueYear && month > dueMonth) {
      fine = (month - dueMonth) * 500;
    }

    if (year > dueYear) {
      fine = 10000;
    }

    System.out.println(fine);
  }
}
