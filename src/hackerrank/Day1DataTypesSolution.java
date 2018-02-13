package hackerrank;

import java.util.Scanner;

public class Day1DataTypesSolution {

  public static void main(String[] args) {
    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    Scanner scan = new Scanner(System.in);

    /* Declare second integer, double, and String variables. */
    int i0;
    double d0;
    String s0;

    /* Read and save an integer, double, and String to your variables.*/
    // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
    i0 = i + scan.nextInt();
    d0 = d + scan.nextDouble();

    // necessary because nextDouble don't move to the next line
    scan.nextLine();
    s0 = s + scan.nextLine();

    /* Print the sum of both integer variables on a new line. */
    System.out.println(i0);

    /* Print the sum of the double variables on a new line. */
    System.out.println(d0);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
    System.out.println(s0);
  }
}
