package pramp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KMessedArraySolution {
  static int[] sortKMessedArray(int[] arr, int k) {
    if (arr == null || arr.length <= 1 || k == 0) {
      return arr;
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>(k * 2 + 1);

    for (int i = 0; i < k * 2 + 1 && i < arr.length; i++) {
      heap.add(arr[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = heap.poll();
      if (i + k * 2 + 1 < arr.length) {
        heap.add(arr[i + k * 2 + 1]);
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] x = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
    int k = 2;

    System.out.println(Arrays.toString(sortKMessedArray(x,k)));
  }
}
