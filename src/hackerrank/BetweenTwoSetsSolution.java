package hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BetweenTwoSetsSolution {
  static int getTotalX(int[] a, int[] b) {
    if (a == null || a.length == 0 || b == null || b.length == 0) {
      return 0;
    }

    ArrayList<Integer> list = new ArrayList<>();
    for (int n = 2; n <= Math.sqrt(b[0]); n++) {
      if (b[0] % n == 0) {
        list.add(n);
      }
    }
    Iterator<Integer> it = list.iterator();
    for (int i = 1; i < b.length; i++) {
      while (it.hasNext()) {
        int n = it.next();
        if (b[i] % n != 0) {
          it.remove();
        }
      }
    }

    it = list.iterator();
    for (int i = 0; i < a.length; i++) {
      while (it.hasNext()) {
        int n = it.next();
        if (n % a[i] != 0) {
          it.remove();
        }
      }
    }
    return list.size();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int[] b = new int[m];
    for (int b_i = 0; b_i < m; b_i++) {
      b[b_i] = in.nextInt();
    }
    int total = getTotalX(a, b);
    System.out.println(total);
    in.close();
  }
}
