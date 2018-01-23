package careercup;

public class MaximumSubsetSumSolution {
  static int getMaximumSum(int[] arr) {
    if (arr == null) {
      throw new NullPointerException();
    }

    int begin = 0;
    int end = 0;

    int currentTotal = arr[begin];
    while (end < arr.length - 1) {
      end++;
      if (arr[end] > currentTotal + arr[end]) {
        begin = end;
        currentTotal = arr[end];
      }
      else {
        currentTotal = 0;
        for (int i = begin; i <= end; i++)
        currentTotal += arr[i];
      }
    }

    return currentTotal;
  }

  public static void main(String[] args) {
    int[] arr = {2, 5, -8, 3, 9, -2, -4, 0, 2, 6, -3, -5, 0, -4, 2, 3, 1};
    System.out.println(getMaximumSum(arr));
  }
}
