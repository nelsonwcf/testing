package pramp;

public class PancakeSortSolution {
  static int[] pancakeSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // for each element in the arr, starting from end to beginning, do O(n)
    for (int i = arr.length - 1; i > 0; i--) {

      // find the highest element in the array O(n)
      int highestIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (arr[highestIndex] < arr[j]) {
          highestIndex = j;
        }
      }

      // reverses the order of the arrays up to the highest element
      flip(arr, highestIndex);

      // reverses the order of the array up to the current element
      flip(arr, i);
    }
    return arr;
  }

  // reverse the order of the array up to the k-th element
  private static void flip(int[] arr, int k) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    int i = 0;
    while (i < k) {
      int aux = arr[i];
      arr[i] = arr[k];
      arr[k] = aux;
      i++;
      k--;
    }
  }
}
