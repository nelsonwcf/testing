package careercup;

import java.util.ArrayList;
import java.util.HashMap;

public class TripleTupleSolution {
  // calculate arr[i] + arr[j] and put in a map,
  // check if arr[l] - arr[k] is in the map
  // and if so, j < k.
  // Runtime: O(n^2); Space: O(n^2)
  static int getNumberOfTuple(int[] arr) {
    if (arr == null || arr.length < 4) {
      return 0;
    }

    // hashmap to hold sum of arr[i] + arr[j]
    HashMap<Integer, ArrayList<Integer>> leftMap = new HashMap<>();
    // traverse the matrix vertically so that the js add to the list
    // will be sorted
    for (int j = 1; j < arr.length; j++) {
      for (int i = 0; i < j; i++) {
        int leftSum = arr[i] + arr[j];
        if (!leftMap.containsKey(leftSum)) {
          // al holds the current index in position 0
          // current index points to the first effective element
          ArrayList<Integer> al = new ArrayList<>();
          al.add(1);
          leftMap.put(leftSum, al);
        }
        // add the j of the sum to the list under the sum key
        leftMap.get(leftSum).add(j);
      }
    }

    int total = 0;
    for (int k = 0; k < arr.length; k++) {
      for (int l = k + 1; l < arr.length; l++) {
        int rightSum = arr[l] - arr[k];
        if (leftMap.containsKey(rightSum)) {
          ArrayList<Integer> al = leftMap.get(rightSum);
          int index = al.get(0);
          // check if exist an element in the list so that j < k
          // if it does, increments it until finding one element
          // that is not or the end of the list
          while (index < al.size() && al.get(index) < k) {
            index++;
          }
          // update the index of the list
          al.set(0, index);

          // sum all positions in which j < k, excluding position 0 (index)
          total += index - 1;
        }
      }
    }
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

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 9, 9, 1, 5, 19};
    System.out.println(getNumberOfTuplesBrute(arr));
    System.out.println(getNumberOfTuple(arr));
  }
}
