package careercup;

import java.util.ArrayList;
import java.util.HashMap;

public class TripleTupleSolution {
  static int getNumberOfTuple(int[] arr) {
    if (arr == null || arr.length < 4) {
      return 0;
    }

    // create the two hashMap used to track the pairs (i,j) and (k,l)
    HashMap<Integer, ArrayList<Integer>> leftMap = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> rightMap = new HashMap<>();
    // traverse the array -> O(n^2)
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // leftSum holds the combination (i,j)
        int leftSum = arr[i] + arr[j];
        // populate the (i,j) hashmap with sums and position of j (to be matched later)
        // the hashMap will hold the sums and treeMap the sorted frequencies
        if (!leftMap.containsKey(leftSum)) {
          leftMap.put(leftSum, new ArrayList<>());
        }
        leftMap.get(leftSum).add(j);

        // rightSum holds the combination (k,l)
        int rightSum = arr[j] - arr[i];
        // populate the (k,l) hashMap with sums and position of i (to be matched later)
        // the hashMap will hold the sums and treeMap the sorted frequencies
        if (!rightMap.containsKey(rightSum)) {
          rightMap.put(rightSum, new ArrayList<>());
        }
        rightMap.get(rightSum).add(i);
      }
    }

    // look if any leftMap key exists in rightMap
    // if it does, compare elements of each ArrayList
    // incrementing counter when rightMap element is greater than lefMap element
    // complexity here is O(n^3)
    int counter = 0;
    for (Integer sum : leftMap.keySet()) {
      if (rightMap.containsKey(sum)) {
        for (Integer j : leftMap.get(sum)) {
          for (Integer i : rightMap.get(sum)) {
            if (j < i) {
              counter++;
            }
          }
        }
      }
    }

    return counter;
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
    int[] arr = {1,2,4,8,16,32,64,128,256,512,1024};
    System.out.println(getNumberOfTuplesBrute(arr));
    System.out.println(getNumberOfTuple(arr));
  }
}
