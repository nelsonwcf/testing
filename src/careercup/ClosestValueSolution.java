package careercup;

public class ClosestValueSolution {

  // Time complexity O(Log n) -> number of array element
  // Space complexity O(1)
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
        if (left > right) {
          left = Math.min(left, array.length - 1);
          return Math.abs(array[left] - value) < Math.abs(array[right] - value) ?
              array[left] : array[right];
        }
      } else {
        right = mid - 1;
        mid = (left + right) / 2;
        if (left > right) {
          right = Math.max(0, right);
          return Math.abs(array[left] - value) < Math.abs(array[right] - value) ?
              array[left] : array[right];
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = new int[] {2,2};
    System.out.println(findClosestValue(array, 2));
    System.out.println(findClosestValue(array, 1));
    System.out.println(findClosestValue(array, 3));

  }
}
