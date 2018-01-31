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
    HashMap<Integer, ArrayList<Pair<Integer, Integer>>> leftMap = new HashMap<>();
    HashMap<Integer, ArrayList<Pair<Integer, Integer>>> rightMap = new HashMap<>();
    int counter = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int l = arr.length - 1 - i;
        int k = l - 1;
        if (arr[i] + arr[j] + arr[k] == arr[l]) {
          counter++;
        }
      }
    }
          /*
          int sumLeft = arr[i] + arr[j];
          int sumRight = arr[l] - arr[k];

          if (!leftMap.containsKey(sumLeft)) {
            leftMap.put(sumLeft, new ArrayList<>());
            leftMap.get(sumLeft).add(new Pair<>(i, j));
          } else {
            leftMap.get(sumLeft).add(new Pair<>(i, j));
          }
          if (!rightMap.containsKey(sumRight)) {
            rightMap.put(sumRight, new ArrayList<>());
            rightMap.get(sumRight).add(new Pair<>(k, l));
          } else {
            rightMap.get(sumRight).add(new Pair<>(k, l));
          }
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
*/


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

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 3, 1, 5};
    System.out.println(getNumberOfTuplesBrute(arr));
  }
}
