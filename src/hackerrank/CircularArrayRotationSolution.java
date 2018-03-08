package hackerrank;

import java.util.Scanner;

public class CircularArrayRotationSolution {
  static int k;

  // runtime: O(n), space: O(1)
  static int[] circularArrayRotation(int[] a, int[] m) {
    k = a.length - (k % a.length);
    int first = 0;
    int runner = 0;
    int aux = a[first];

    for (int i = 0; i < a.length; i++) {
      if (adjInd(runner + k, a.length) == first) {
        a[runner] = aux;
        first = adjInd(++first, a.length);
        runner = first;
        aux = a[first];
      }
      else {
        a[runner] = a[adjInd(runner + k, a.length)];
        runner = adjInd(runner + k, a.length);
      }
    }

    int[] result = new int[m.length];
    for (int i = 0; i < m.length; i++) {
      result[i] = a[m[i]];
    }

    return result;
  }

  static int adjInd(int index, int size) {
    return (size + (index % size)) % size;
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

