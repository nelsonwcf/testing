package careercup;

public class SmallestRangeSolution {

  private static int findSmallestRange(int[] list1, int[] list2, int[] list3) {
    if (list1 == null || list1.length == 0 ||
        list2 == null || list2.length == 0 ||
        list3 == null || list3.length == 0) {
      return -1;
    }

    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int range = Integer.MAX_VALUE;

    while (i1 < list1.length && i2 < list2.length && i3 < list3.length) {
      int max = Math.max(list1[i1], Math.max(list2[i2], list3[i3]));
      int min = Math.min(list1[i1], Math.min(list2[i2], list3[i3]));

      if (range > max - min) {
        range = max - min;
      }

      if (list1[i1] == min) {
        i1++;
      } else if (list2[i2] == min) {
        i2++;
      } else {
        i3++;
      }
    }
    return range;
  }

  public static void main(String[] args) {
    int[] list1 = new int[]{4, 10, 15, 24, 26};
    int[] list2 = new int[]{0, 9, 12, 20};
    int[] list3 = new int[]{5, 18, 22, 30};

    System.out.println(findSmallestRange(list1, list2, list3));
  }
}