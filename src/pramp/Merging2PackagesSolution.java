package pramp;

import java.util.HashMap;

public class Merging2PackagesSolution {
  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }

    int[] result = new int[2];
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (hm.containsKey(limit - arr[i])) {
        int complementIndex = hm.get(limit - arr[i]);
        result[0] = complementIndex <= i ? i : complementIndex;
        result[1] = complementIndex <= i ? complementIndex : i;
        return result;
      }
      else {
        hm.put(arr[i],i);
      }
    }
    return new int[0];
  }
}
