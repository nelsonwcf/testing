package src.careercup;

public class ClosestValueSolution {
  private static int findClosestValue(int[] array, int value) {
    if (array == null || array.length == 0) {
      return -1;
    }
    if (array.length == 1) {
      return array[0];
    }

    int left = 0;
    int right = array.length - 1;
    int mid = (left + right) / 2;

    while (left <= right) {
      if (array[mid] == value) {
        return value;
      } else if (value > array[mid]) {
        left = mid + 1;
        mid = (left + right) / 2;
        if (left > right)
          return array[Math.min(mid + 1, array.length - 1)];
      } else {
        right = mid - 1;
        mid = (left + right) / 2;
        if (left > right)
          return array[Math.max(mid - 1, 0)];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = new int[] {2,2,5,6,7,8,8,9};
    System.out.println(findClosestValue(array, 3));

    // Code not working correctly
    System.out.println(findClosestValue(array, 4));

  }
}
