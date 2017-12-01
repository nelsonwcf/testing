package src.careercup;

import java.util.*;

public class SmallestRangeSolution {

  static int findSmallestRange(int[] list1, int[] list2, int[] list3) {
    if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0 || list3 == null || list3.length == 0) {
      return -1;
    }

    // To use be able to use iterators instead of a lot of chained ifs
    ArrayList<Integer> array1 = new ArrayList<>();
    for (int i = 0; i < list1.length; i++) {
      array1.add(list1[i]);
    }
    Iterator it1 = array1.iterator();

    ArrayList<Integer> array2 = new ArrayList<>();
    for (int i = 0; i < list2.length; i++) {
      array2.add(list2[i]);
    }
    Iterator it2 = array2.iterator();

    ArrayList<Integer> array3 = new ArrayList<>();
    for (int i = 0; i < list3.length; i++) {
      array3.add(list1[3]);
    }
    Iterator it3 = array3.iterator();

    // Used to track which list to increment in O(1) time
    HashMap<Integer, Integer> order = new HashMap<>();

    int[] index = new int[] {0,0,0};
    int range = Integer.MAX_VALUE;

    while (index[0] != list1.length - 1 || index[1] != list2.length - 1 || index[2] != list3.length - 1) {
      int max = Math.max(list1[index[0]], Math.max(list2[index[1]], list3[index[2]]));
      int min = Math.min(list1[index[0]], Math.min(list2[index[1]], list3[index[2]]));

      if (range > max - min) {
        range = max - min;
      }

      if (list1[index[0]] <= list2[index[1]] && list1[index[0]] <= list3[index[2]]) {
        if (list2[index[1]] <= list3[index[2]]) {
          order.put(1, 0);
          order.put(2, 1);
          order.put(2, 2);
        } else {
          order.put(1, 0);
          order.put(2, 2);
          order.put(3, 3);
        }
      } else if (list2[index[1]] <= list1[index[0]] && list2[index[1]] <= list3[index[2]]) {
        if (list1[index[0]] <= list3[index[2]]) {
          order.put(1, 1);
          order.put(2, 0);
          order.put(3, 2);
        } else {
          order.put(1, 1);
          order.put(2, 2);
          order.put(3, 0);
        }
      } else if (list3[index[2]] <= list1[index[0]] && list3[index[2]] <= list2[index[1]]) {
        if (list1[index[0]] <= list2[index[1]]) {
          order.put(1, 2);
          order.put(2, 0);
          order.put(3, 1);
        } else {
          order.put(1, 2);
          order.put(2, 1);
          order.put(3, 0);
        }
      } else {
        System.out.println("The code shouldn't reach here.");
        System.exit(-1);
      }
    }
    
    for (int i = 1; i <= 3; i++) {
      if (index[order.get(i) < ]
    }
      

      





      /*
      // If list1 has the smallest element
      if (list1[index[0]] <= list2[index[1]] && list1[index[0]] <= list3[index[2]]) {
        if (index[0] < list1.length - 1) {
          index[0]++;
        } else {
          if (list2[index[1]] <= list3[index[2]]) {
            if (index[1] < list2.length - 1) {
              index[1]++;
            }
          } else {
            if (index[2] < list3.length - 1) {
              index[2]++;
            }
          }
        }
        // If list2 has the smallest element
      } else if (list2[index[1]] <= list1[index[0]] && list2[index[1]] <= list3[index[2]]) {
        if (index[1] < list2.length - 1) {
          index[1]++;
        } else {
          if (list1[index[0]] <= list3[index[2]]) {
            if (index[0] < list1.length - 1) {
              index[0]++;
            }
          } else {
            if (index[2] < list3.length - 1) {
              index[2]++;
            }
          }
        }
      } else {
        if (index[2] < list3.length - 1) {
          index[2]++;
        } else {
          if (list1[index[0]] <= list2[index[1]]) {
            if (index[0] < list1.length - 1) {
              index[0]++;
            }
          } else {
            if (index[1] < list2.length - 1) {
              index[1]++;
            }
          }
        }
      }
    }
    */
    return range;
  }

  public static void main(String[] args) {
    int[] list1 = new int[]{2, 5, 6, 9, 12};
    int[] list2 = new int[]{15, 16, 20, 25};
    int[] list3 = new int[]{-4, -1, 0, 1, 6};

    System.out.println(findSmallestRange(list1, list2, list3));
  }
}