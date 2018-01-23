package pramp.com;

public class MaximumSubsetSumSolution {

  // sliding window implementation
  // runtime complexity: O(n)
  // space complexity: O(1)
  static int getMaximumSum(int[] arr) {
    if (arr == null) {
      throw new NullPointerException();
    }

    int currentTotal = 0;
    int maxTotal = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < currentTotal + arr[i]) {
        currentTotal += arr[i];
      }
      else {
        currentTotal = arr[i];
      }
      if (maxTotal < currentTotal) {
        maxTotal = currentTotal;
      }
    }
    return maxTotal;
  }
}
