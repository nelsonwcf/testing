package custom.structures;

import java.lang.reflect.Array;

public class MSort {
  public static <T extends Comparable<T>> T[] mergesort(T[] array) {
    T[] sortedArray;
    int left;
    int right;
    int mid;

    if (array == null || array.length <= 1) {
      return array;
    }

    sortedArray = array.clone();
    left = 0;
    right = array.length - 1;
    mid = (left + right);

    msort(arrayA, left, right, sortedArray);
    return sortedArray;
  }

  private static <T extends Comparable<T>> void msort(T[] array) {

  }

  @SuppressWarnings({"unchecked"})
  private static <T extends Comparable<T>> T[] merge(T[] arrayA, T[] arrayB {
    int leftA = 0;
    int leftB = 0;
    int rightA = arrayA.length - 1;
    int rightB = arrayB.length - 1;
    T[] result;

    // This is guaranteed to work since the output type is the same as the input type
    result = (T[]) Array.newInstance(arrayA.getClass().getComponentType(), arrayA.length + arrayB.length);

    while (leftA <= rightA && leftB <= rightB) {
      if (array[leftA].compareTo(array[leftB]) <= 0) {
        result[startPosition] = array[leftA];
        leftA++;
      } else {
        result[startPosition] = array[leftB];
        leftB++;
      }
      startPosition++;
    }

    while (leftA <= rightA) {
      result[startPosition] = array[leftA];
      leftA++;
      startPosition++;
    }

    while (leftB <= rightB) {
      result[startPosition] = array[leftB];
      leftB++;
      startPosition++;
    }
  }
}
