package pramp;

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
    for (int anArr : arr) {
      if (anArr < currentTotal + anArr) {
        currentTotal += anArr;
      }
      else {
        currentTotal = anArr;
      }
      if (maxTotal < currentTotal) {
        maxTotal = currentTotal;
      }
    }
    return maxTotal;
  }
}
