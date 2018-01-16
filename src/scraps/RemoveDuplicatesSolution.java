package scraps;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesSolution {
  static int[] removeDuplicates(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    HashSet<Integer> hs = new HashSet<>();

    int j = 0;
    int i = 0;
    while (j < arr.length) {
      while (hs.contains(arr[j])) {
        j++;
      }
      hs.add(arr[j]);
      arr[i] = arr[j];
      i++;
      j++;
    }

    while (i < arr.length) {
      arr[i] = 0;
      i++;
    }

    return arr;
  }

  public static void main(String[] args) {
    int[] x = {2, 2, 4, 7, 8, 8, 10, -1, -1, -1, 3, 4, 5};
    System.out.println(Arrays.toString(removeDuplicates(x)));
  }
}