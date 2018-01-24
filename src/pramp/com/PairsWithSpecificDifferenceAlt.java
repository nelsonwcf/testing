package pramp.com;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithSpecificDifferenceAlt {
  // this version has a complexity of O(n*log n)
  // but space complexity of O(1)
  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    if (arr == null || arr.length <= 1) {
      return new int[0][0];
    }

    Arrays.sort(arr);
    int i = 1;
    int j = 0;

    ArrayList<Pair<Integer, Integer>> auxResult = new ArrayList<>();

    // remember to take care of incrementing counters in while loops
    // at the end only
    while (i < arr.length && j < i) {
      if (arr[i] - arr[j] == k) {
        auxResult.add(new Pair<>(arr[i], arr[j]));
        i++;
        j++;
      } else if (arr[i] - arr[j] < k) {
        i++;
      } else {
        j++;
      }
    }

    int[][] result = new int[auxResult.size()][2];
    i = 0;
    for (Pair<Integer, Integer> p : auxResult) {
      int x = p.getKey();
      int y = p.getValue();
      result[i][0] = x;
      result[i][1] = y;
      i++;
    }

    return result;
  }
}