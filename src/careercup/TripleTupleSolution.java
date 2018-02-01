package careercup;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TripleTupleSolution {
  static int getNumberOfTuple(int[] arr) {
    if (arr == null || arr.length < 4) {
      return 0;
    }

    // create the left hashMap O(n^2)
    HashMap<Integer, HashMap<Integer, Integer>> leftMap = new HashMap<>();
    HashMap<Integer, HashMap<Integer, Integer>> rightMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int sumLeft = arr[i] + arr[j];
        int sumRight = arr[j] - arr[i];

        if (!leftMap.containsKey(sumLeft)) {
          leftMap.put(sumLeft, new HashMap<>());
          leftMap.get(sumLeft).put();
        } else {
          leftMap.get(sumLeft).add(new Pair<>(i, j));
        }
        if (!rightMap.containsKey(sumRight)) {
          rightMap.put(sumRight, new ArrayList<>());
          rightMap.get(sumRight).add(new Pair<>(i, j));
        } else {
          rightMap.get(sumRight).add(new Pair<>(i, j));
        }
      }
    }

    // count matches
    int tuples = 0;
    for (Integer i : leftMap.keySet()) {
      if (rightMap.containsKey(i)) {
        tuples += leftMap.get(i).size() * rightMap.get(i).size();
      }
    }


    return tuples;
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
    int[] arr = {1, 1, 1, 3, 1, 5};
    System.out.println("returned: " +  getNumberOfTuple(arr));
    System.out.println("expected: " + getNumberOfTuplesBrute(arr));
  }
}
