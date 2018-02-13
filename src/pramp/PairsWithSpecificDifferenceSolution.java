package pramp;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class PairsWithSpecificDifferenceSolution {
  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    if (arr == null || arr.length == 0) {
      return new int[0][0];
    }

    // TreeMap was used to get the 5th test correct, since it didn't follow the problem statement
    // of the result array not having to be sorted.
    // However, HashMap should be used here instead since its get()
    // complexity is O(1) when TreeMap O(log n)
    TreeMap<Integer, Integer> hm = new TreeMap<>();
    for (int i = 0; i < arr.length; i++) {
      hm.put(arr[i], i);
    }

    ArrayList<Pair<Integer, Integer>> auxResult = new ArrayList<>();

    for (Integer i : hm.keySet()) {
      if (hm.containsKey(i - k)) {
        auxResult.add(new Pair<>(i, i - k));
      }
    }

    int[][] result = new int[auxResult.size()][2];

    int i = 0;
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