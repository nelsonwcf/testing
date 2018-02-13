package careercup;

import java.util.ArrayList;
import java.util.HashMap;

public class TripleTupleSolution {
  static int getNumberOfTuple(int[] arr) {
    if (arr == null || arr.length < 4) {
      return 0;
    }

    HashMap<Integer, ArrayList<Integer>> leftMap = new HashMap<>();
    for (int j = 1; j < arr.length; j++) {
      for (int i = 0; i < j; i++) {
        int leftSum = arr[i] + arr[j];
        if (!leftMap.containsKey(leftSum)) {
          leftMap.put(leftSum, new ArrayList<>());
        }
        leftMap.get(leftSum).add(j);
      }
    }

    int total = 0;
    for (int k = 0; k < arr.length; k++) {
      for (int l = k; l < arr.length; l++) {
        int rightSum = arr[l] - arr[k];
        if (leftMap.containsKey(rightSum)) {
          for (Integer j : leftMap.get(rightSum)) {
            if (j < k) {
              total += leftMap.get(rightSum).get(j);
            }
          }
        }
      }
    }

    /*
    // create the two hashMap used to track the pairs (i,j) and (k,l)
    HashMap<Integer, HashMap<Integer, Integer>> leftMap = new HashMap<>();
    // traverse the array -> runtime O(n^2), space O(n^2)
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // leftSum holds the combination (i,j)
        int leftSum = arr[i] + arr[j];
        if (!leftMap.containsKey(leftSum)) {
          leftMap.put(leftSum, new HashMap<>());
        }
        if (!leftMap.get(leftSum).containsKey(j)) {
          leftMap.get(leftSum).put(j, 1);
        } else {
          leftMap.get(leftSum).put(j, 1 + leftMap.get(leftSum).get(j));
        }
      }
    }


    int total = 0;
    for (int k = 0; k < arr.length; k++) {
      for (int l = k; l < arr.length; l++) {
        int rightSum = arr[l] - arr[k];
        if (leftMap.containsKey(rightSum)) {
          for (Integer j : leftMap.get(rightSum).keySet()) {
            if (j < k) {
              total += leftMap.get(rightSum).get(j);
            }
          }
        }
      }
    }
    */
    return total;
  }

  static int getNumberOfTuplesBrute(int[] arr) {
    if (arr == null || arr.length < 4) {
      return 0;
    }

    int counter = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          for (int l = k + 1; l < arr.length; l++) {
            if (arr[i] + arr[j] + arr[k] == arr[l]) {
              counter++;
            }
          }
        }
      }
    }
    return counter;
  }

  public static int binarySearchFirstLeft(int[] arr, int value) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int left = 0;
    int right = arr.length - 1;
    int mid = (left + right) / 2;

    while (left <= right) {
      if (arr[mid] == value) {
        if (mid - 1 >= 0 && arr[mid - 1] < value || mid - 1 < 0) {
          return mid;
        } else {
          right = mid - 1;
          mid = (left + right) / 2;
        }
      } else if (arr[mid] > value) {
        right = mid - 1;
        mid = (left + right) / 2;
      } else {
        left = mid + 1;
        mid = (left + right) / 2;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 1, 3, 5};
    System.out.println(getNumberOfTuplesBrute(arr));
//    System.out.println(getNumberOfTuple(arr));
  }
}
