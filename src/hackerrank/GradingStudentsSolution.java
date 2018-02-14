package hackerrank;

import java.util.*;

public class GradingStudentsSolution {

  static int[] solve(int[] grades) {
    if (grades == null || grades.length == 0) {
      return grades;
    }

    for (int i = 0; i < grades.length; i++) {
      if (grades[i] >= 38) {
        int nextMultiple = grades[i] % 5 == 0 ? grades[i] + 5 : (grades[i] / 5) * 5 + 5;
        if (nextMultiple - grades[i] < 3) {
          grades[i] = nextMultiple;
        }
      }
    }

    return grades;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] grades = new int[n];
    for (int grades_i = 0; grades_i < n; grades_i++) {
      grades[grades_i] = in.nextInt();
    }
    int[] result = solve(grades);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");


  }
}
