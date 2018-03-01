package hackerrank;

import java.util.Scanner;

public class PickingNumbersSolution {
  static int pickingNumbers(int[] a) {
    int[] freqDist = new int[100 + 2];
    int longestSequence = 0;
    for (int n : a) {
      freqDist[n]++;
      int sequenceL = freqDist[n] + freqDist[n - 1];
      int sequenceU = freqDist[n] + freqDist[n + 1];
      int max = Math.max(sequenceL, sequenceU);
      longestSequence = longestSequence < max ? max : longestSequence;
    }
    return longestSequence;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int result = pickingNumbers(a);
    System.out.println(result);
    in.close();
  }
}
