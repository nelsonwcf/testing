package scraps;

import java.util.Arrays;

public class NegativeOfPositiveSolution {
  static int[] signalSortNonStable(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    int currentPos = 0;
    while (currentPos < arr.length && arr[currentPos] < 0) {
      currentPos++;
    }

    int negativeCursor = currentPos;
    while (currentPos < arr.length && negativeCursor < arr.length) {
      while (arr[currentPos] < 0 && currentPos < arr.length) {
        currentPos++;
      }
      while (negativeCursor < arr.length && arr[negativeCursor] >= 0) {
        negativeCursor++;
      }
      if (currentPos >= arr.length || negativeCursor >= arr.length) {
        return arr;
      }

      int aux = arr[negativeCursor];
      arr[negativeCursor] = arr[currentPos];
      arr[currentPos] = aux;
    }
    return arr;
  }

  static int[] signalSortStable(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    int[] negatives = new int[arr.length];
    int neg = 0;
    int[] nonnegatives = new int[arr.length];
    int nonneg = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        negatives[neg] = arr[i];
        neg++;
      }
      else {
        nonnegatives[nonneg] = arr[i];
        nonneg++;
      }
    }

    int arrIndex = 0;
    for (int i = 0; i < neg; i++) {
      arr[arrIndex] = negatives[i];
      arrIndex++;
    }

    for (int i = 0; i < nonneg; i++) {
      arr[arrIndex] = nonnegatives[i];
      arrIndex++;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] array = {4,-3};
    System.out.println(Arrays.toString(signalSortNonStable(array)));
  }
}
