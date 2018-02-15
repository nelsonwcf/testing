package hackerrank;

import java.util.*;

public class BigSortingSolution {
//  // using big numbers timeouts the test so this is not a good solution
//  static class naturalStrComp implements Comparator<String> {
//    @Override
//    public int compare(String o1, String o2) {
//      BigInteger b1 = new BigInteger(o1);
//      BigInteger b2 = new BigInteger(o2);
//      return b1.compareTo(b2);
//    }
//  }

//  // bucketsort works faster but not still no fast enoug
//  // problem seems to be the manipulation of the huge integer
//  static String[] bigSorting(String[] arr) {
//    if (arr == null || arr.length <= 1) {
//      return arr;
//    }
//
//    // get the size of the longest array
//    int maxSize = 0;
//    for (int i = 0; i < arr.length; i++) {
//      if (maxSize < arr[i].length()) {
//        maxSize = arr[i].length();
//      }
//    }
//
//    // create ten dynamically-sized buckets, one for each digit
//    ArrayDeque<String>[] buckets = new ArrayDeque[10];
//    for (int i = 0; i < buckets.length; i++) {
//      buckets[i] = new ArrayDeque<String>();
//    }
//    ArrayDeque<String> done = new ArrayDeque<>();
//
//    // iterates through the array maxSize times sorting the elements
//    // by each digit, one at a time
//    for (int i = 0; i < maxSize; i++) {
//      // in each iteration, put the elements in the right buckets
//      for (int j = 0; j < arr.length; j++) {
//        String aux = arr[j];
//        if (aux.length() - 1 - i >= 0) {
//          buckets[Character.getNumericValue(aux.charAt(aux.length() - 1 - i))].addFirst(aux);
//        } else {
//          done.addFirst(aux);
//        }
//      }
//      // then add elements back starting from the first bucket
//      int index = 0;
//      while (!done.isEmpty()) {
//        arr[index] = done.removeLast();
//        index++;
//      }
//      for (int k = 0; k < 10; k++) {
//        while (!buckets[k].isEmpty()) {
//          arr[index] = buckets[k].removeLast();
//          index++;
//        }
//      }
//    }
//    return arr;
//  }

  // different approach: sort the array by size first then sort block using a general sort
  static String[] bigSorting(String[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // create a sorted distFreq
    TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i].length())) {
        map.put(arr[i].length(), new TreeMap<>());
      }

      if (!map.get(arr[i].length()).containsKey(arr[i])) {
        map.get(arr[i].length()).put(arr[i], 0);
      }

      map.get(arr[i].length()).put(arr[i], map.get(arr[i].length()).get(arr[i]) + 1);
    }

    // add the values in sorted order to the array
    int index = 0;
    for (Integer key : map.keySet()) {
      for (String s : map.get(key).keySet()) {
        while (map.get(key).get(s) > 0) {
          arr[index] = s;
          map.get(key).put(s, map.get(key).get(s) - 1);
          index++;
        }
      }
    }

    return arr;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] arr = new String[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.next();
    }
    String[] result = bigSorting(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");


    in.close();
  }
}