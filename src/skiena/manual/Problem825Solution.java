package skiena.manual;

import java.util.Arrays;

public class Problem825Solution {
  public static int[] getMaximumSum(int[] arr) {
    int[] aggr = new int[arr.length + 1];
    int i = 0;
    int j = 0;
    int max;
    int min;

    aggr[0] = arr[0];
    max = aggr[0];
    min = 0;
    i = -1;
    for (int index = 0; index < arr.length; index++) {
      aggr[index] = aggr[index - 1] + arr[index];
      if (max < aggr[index]) {
        max = aggr[index];
        j = index;
      }
      if (min > aggr[index]) {
        min = aggr[index];
        i = index;
      }
    }
    return new int[]{i+1,j};
  }

  public static void main(String[] args) {
    int[] array = {10, 2, 9, -5, 11, -3, 1, 1, 18, -16};
    System.out.println(Arrays.toString(getMaximumSum(array)));

  }
}
