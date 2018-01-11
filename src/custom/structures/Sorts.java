package custom.structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorts<T extends Comparable<T>> {
  public static <T extends Comparable<T>> void quicksort(T[] array) {
    // Empty or one element arrays are already sorted
    if (array.length > 1)
      qsort(array, 0, array.length - 1);
  }

  private static <T extends Comparable<T>> void qsort(T[] array, int left, int right) {
    if (left < right) {
      int l = left;
      int r = right;
      T p = array[(l + r) / 2];

      while (l <= r) {
        while (array[l].compareTo(p) < 0)
          l++;
        while (array[r].compareTo(p) > 0)
          r--;
        if (l <= r) {
          T tmp = array[l];
          array[l] = array[r];
          array[r] = tmp;
          l++;
          r--;
        }
      }
      qsort(array, left, r);
      qsort(array, l, right);
    }
  }

  public static <T extends Comparable<T>> T[] mergesort(T[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }

    return msort(array);
  }

  private static <T extends Comparable<T>> T[] msort(T[] array) {
    T[] arrayA;
    T[] arrayB;
    int left = 0;
    int right = array.length - 1;
    int mid = (left + right) / 2;

    if (array.length == 1) {
      return array;
    }

    if (array.length == 2) {
      return merge(Arrays.copyOfRange(array, 0, 1), Arrays.copyOfRange(array, 1, 2));
    }

    arrayA = Arrays.copyOfRange(array, 0, mid);
    arrayB = Arrays.copyOfRange(array, mid, right + 1);

    return merge(msort(arrayA), msort(arrayB));
  }

  @SuppressWarnings({"unchecked"})
  private static <T extends Comparable<T>> T[] merge(T[] arrayA, T[] arrayB) {
    int leftA = 0;
    int leftB = 0;
    int rightA = arrayA.length - 1;
    int rightB = arrayB.length - 1;
    int startPosition = 0;
    T[] result;

    // This is guaranteed to work since the output type is the same as the input type
    result = (T[]) Array.newInstance(arrayA.getClass().getComponentType(), arrayA.length + arrayB.length);

    while (leftA <= rightA && leftB <= rightB) {
      if (arrayA[leftA].compareTo(arrayB[leftB]) <= 0) {
        result[startPosition] = arrayA[leftA];
        leftA++;
      }
      else {
        result[startPosition] = arrayB[leftB];
        leftB++;
      }
      startPosition++;
    }

    while (leftA <= rightA) {
      result[startPosition] = arrayA[leftA];
      leftA++;
      startPosition++;
    }

    while (leftB <= rightB) {
      result[startPosition] = arrayB[leftB];
      leftB++;
      startPosition++;
    }

    return result;
  }

  public static <T extends Comparable<T>> void bubblesort(T[] array) {
    boolean repeat = true;

    while (repeat) {
      repeat = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i + 1].compareTo(array[i]) < 0) {
          T tmp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = tmp;
          repeat = true;
        }
      }
    }
  }


  public static int[] radixSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // Position zero of each array contains the position of last element +1;
    int[][] radixesTable = new int[10][arr.length + 1];
    for (int i = 0; i < 10; i++) {
      radixesTable[i][0] = 1;
    }

    // Store how many digits the largest number has
    int maxValue = Integer.MIN_VALUE;

    // First step: traverse array storing each element in the right index in radixesTable
    for (int i = 0; i < arr.length; i++) {
      maxValue = maxValue < arr[i] ? arr[i] : maxValue;
      int index = arr[i] % 10;
      radixesTable[index][radixesTable[index][0]++] = arr[i];
    }

    int j = 0;
    for (int i = 0; i < 10; i++) {
      int k = 1;
      while (k < radixesTable[i][0]) {
        arr[j] = radixesTable[i][k];
        j++;
        k++;
      }
    }

    return arr;
  }

  public static void main(String[] args) {
    int[] i = {2,1,4,3,9,7,4,2,7,5,1};
    System.out.println(Arrays.toString(radixSort(i)));
  }
}
