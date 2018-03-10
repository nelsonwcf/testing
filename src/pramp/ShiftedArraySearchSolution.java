package pramp;

public class ShiftedArraySearchSolution {
  static int shiftedArrSearch(int[] shiftArr, int num) {
    if (shiftArr == null || shiftArr.length == 0) {
      return -1;
    }
    return shiftedArrSearchAux(shiftArr, num, 0, shiftArr.length - 1);
  }

  private static int shiftedArrSearchAux(int[] shiftArr, int num, int start, int end) {
    // base cases
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (shiftArr[mid] == num) {
      return mid;
    }

    // recursive cases
    if (shiftArr[start] < shiftArr[mid]) {
      if (num < shiftArr[mid] && num >= shiftArr[start]) {
        return shiftedArrSearchAux(shiftArr, num, start, mid - 1);
      }
      else {
        return shiftedArrSearchAux(shiftArr, num, mid + 1, end);
      }
    }
    else {
      if (num > shiftArr[mid] && num <= shiftArr[end]) {
        return shiftedArrSearchAux(shiftArr, num, mid + 1, end);
      }
      else {
        return shiftedArrSearchAux(shiftArr, num, start, mid - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] ar = {9,12,17,2,4,5,6};
    int n = 9;
    System.out.println(shiftedArrSearch(ar, n));
  }

}
