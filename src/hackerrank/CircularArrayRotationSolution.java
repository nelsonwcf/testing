package hackerrank;

import java.util.Scanner;

public class CircularArrayRotationSolution {
  static int k;

  static int[] circularArrayRotation(int[] a, int[] m) {
    int r = k % a.length;
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = a[(i + r) % a.length];
    }
    return b;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    k = in.nextInt();
    int q = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int[] m = new int[q];
    for (int m_i = 0; m_i < q; m_i++) {
      m[m_i] = in.nextInt();
    }
    int[] result = circularArrayRotation(a, m);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");


    in.close();
  }
}

