package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class MigratoryBirdsSolution {
  static int migratoryBirds(int n, int[] ar) {
    if (ar == null || ar.length == 0) {
      return 0;
    }

    HashMap<Integer, Integer> freqDist = new HashMap<>();
    for (int i = 0; i < ar.length; i++) {
      if (!freqDist.containsKey(ar[i])) {
        freqDist.put(ar[i],0);
      }

      int currentFreq = freqDist.get(ar[i]) + 1;
      freqDist.put(ar[i], currentFreq);
    }

    Integer id = ar[0];
    Integer freq = 0;
    for (Integer i : freqDist.keySet()) {
      Integer f = freqDist.get(i);
      if (f == freq) {
        id = i < id ? i : id;
      }

      if (f > freq) {
        id = i;
        freq = f;
      }
    }
    return id;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for(int ar_i = 0; ar_i < n; ar_i++){
      ar[ar_i] = in.nextInt();
    }
    int result = migratoryBirds(n, ar);
    System.out.println(result);
  }
}
