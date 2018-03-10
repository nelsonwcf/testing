package pramp;

import javafx.util.Pair;

import java.util.*;

public class ArrayQuadrupletSolution {

  // complexity: O(n^2), space: O(n^2)
  static int[] findArrayQuadruplet(int[] arr, int s) {
    if (arr == null || arr.length < 4) {
      return new int[0];
    }

    TreeMap<Integer, HashSet<Pair<Integer, Integer>>> sums = new TreeMap<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (!sums.containsKey(arr[i] + arr[j])) {
          sums.put(arr[i] + arr[j], new HashSet<>());
        }
        sums.get(arr[i] + arr[j]).add(new Pair<>(i, j));
      }
    }

    int[] result = new int[4];
    for (Integer n : sums.keySet()) {
      if (sums.containsKey(s - n)) {
        for (Pair<Integer, Integer> p1 : sums.get(n)) {
          for (Pair<Integer, Integer> p2 : sums.get(s - n)) {
            int i = p1.getKey();
            int j = p1.getValue();
            int k = p2.getKey();
            int l = p2.getValue();
            if (i != k && i != l && j != k && j != l) {
              result[0] = arr[i];
              result[1] = arr[j];
              result[2] = arr[k];
              result[3] = arr[l];
              return result;
            }
          }
        }
      }
    }
    return new int[0];
  }

  // complexity: O(n^3), space: O(1)
  static int[] findArrayQuadruplet_v2(int[] arr, int s) {
    if (arr == null || arr.length < 4) {
      return new int[0];
    }

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int k = j + 1;
        int l = arr.length - 1;
        int sum = s - (arr[i] + arr[j]);
        while (k < l) {
          if (arr[k] + arr[l] == sum) {
            int[] result = new int[4];
            result[0] = arr[i];
            result[1] = arr[j];
            result[2] = arr[k];
            result[3] = arr[l];
            return result;
          }

          if (arr[k] + arr[l] > sum) {
            l--;
          }
          else {
            k++;
          }
        }
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] array = {2, 7, 4, 0, 9, 5, 1, 3};
    int sum = 20;
    for (int i : findArrayQuadruplet(array, sum)) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
