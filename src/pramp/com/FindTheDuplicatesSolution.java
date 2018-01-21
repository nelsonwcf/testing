package pramp.com;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class FindTheDuplicatesSolution {
  // regular solution: runtime complexity: O (N + M), space complexity: O min(N,M)
  static int[] findDuplicates(int[] arr1, int[] arr2) {
    if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
      return new int[0];
    }

    // create to indexes, one for each array
    int i1 = 0;
    int i2 = 0;

    // dynamic array;
    ArrayList<Integer> al = new ArrayList<>();

    // compare the value of each index in each array:
    while (i1 < arr1.length && i2 < arr2.length) {
      // add the value to the solution if they are equal and increment both
      if (arr1[i1] == arr2[i2]) {
        al.add(arr1[i1]);
        i1++;
        i2++;
      }
      // increment the smaller if they are different
      else {
        if (arr1[i1] < arr2[i2]) {
          i1++;
        } else {
          i2++;
        }
      }
    }

    // return the array
    int[] result = new int[al.size()];
    for (int i = 0; i < al.size(); i++) {
      result[i] = al.get(i);
    }

    return result;
  }

  // if arr2.length >>>>> arr1.length
  // different solution, with runtime complexity: O (N * LOG M), space complexity: O (N)
  static int[] findDuplicatesAlt(int[] arr1, int[] arr2) {
    if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
      return new int[0];
    }

    // dynamic array for solution
    ArrayList<Integer> al = new ArrayList<>();

    // for each value in the smallest array, binary search it in the biggest array
    // if found, add it to List
    for (int i = 0; i < arr1.length; i++) {
      if (binarySearch(arr2, arr1[i])) {
        al.add(arr1[i]);
      }
    }

    // return the array
    int[] result = new int[al.size()];
    for (int i = 0; i < al.size(); i++) {
      result[i] = al.get(i);
    }

    return result;
  }

  // iterative, because java don't have tail optimization (java sucks at recursion)
  // and we don't need unecessary stack memory
  private static boolean binarySearch(@NotNull int[] arr, int value) {
    int left = 0;
    int right = arr.length - 1;
    int mid = (left + right) / 2;

    while (left <= right) {
      if (arr[mid] == value) {
        return true;
      } else {
        if (value < arr[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      mid = (left + right) / 2;
    }

    return false;
  }
}