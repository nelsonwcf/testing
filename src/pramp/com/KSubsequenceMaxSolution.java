package pramp.com;

import custom.structures.CircularQueue;

public class KSubsequenceMaxSolution {
  // runtime complexity: O(n)
  // space complexity: O(k)
  // fixed size circular queue used to make any operation constant time
  static int[] getMaxSumKthSubset(int[] arr, int k) {
    if (k == 0 || arr == null || arr.length == 0 || arr.length < k) {
      return new int[0];
    }

    int[] result = new int[arr.length - k + 1];
    CircularQueue<Integer> cq = new CircularQueue<>(k);

    // for each element in the array, check previous elements in the queue
    // are smaller than the current one. if so, replace them by the current one
    // this way, the last element in the queue will always be the maximum element
    // of that subset.
    for (int i = 0; i < arr.length; i++) {
      int removed = 0;
      while (!cq.isEmpty() && cq.getFirst() < arr[i]) {
        cq.removeFirst();
        removed++;
      }
      for (int j = 0; j < removed + 1; j++) {
        cq.addFirst(arr[i]);
      }
      // subsets needs k elements for the first result so waits until
      // k elements have been processed and add the maximum to the result
      // on the i - (k - 1) position.
      if (i >= (k - 1)) {
        result[i - (k - 1)] = cq.removeLast();
      }
    }

    return result;
  }
}
