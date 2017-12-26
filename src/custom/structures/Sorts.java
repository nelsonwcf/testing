package custom.structures;

// Mergesort and Bubblesort seem to be broken after being generalized
public class Sorts<T extends Comparable<T>> {

  static <T extends Comparable<T>> void quicksort(T[] array) {
    // Empty or one element arrays are already sorted
    if (array.length > 1)
      qsort(array, 0, array.length - 1);
  }

  private static <T extends Comparable<T>> void qsort(T[] array, int left, int right) {
    if (left < right) {
      int l = left;
      int r = right;
      T p = array[(l + r) / 2];

      while (l <= r) {
        while (array[l].compareTo(p) < 0)
          l++;
        while (array[r].compareTo(p) > 0)
          r--;
        if (l <= r) {
          T tmp = array[l];
          array[l] = array[r];
          array[r] = tmp;
          l++;
          r--;
        }
      }
      qsort(array, left, r);
      qsort(array, l, right);
    }
  }

  static <T extends Comparable<T>> int[] mergesort(T[] a, int p, int q) {
    if (p == q) {
      int[] n = new int[1];
      //n[0] = a[p];
      return n;
    } else {
      return msort(mergesort(a, p, (p + q) / 2), mergesort(a, (p + q) / 2 + 1, q));
    }
  }

  private static <T extends Comparable<T>> int[] msort(int[] a, int[] b) {
    int[] x = new int[a.length + b.length];
    int ap = 0, bp = 0, xp = 0;

    while (xp < x.length) {
      if (ap < a.length && bp < b.length) {
        x[xp++] = a[ap] < b[bp] ? a[ap++] : b[bp++];
      } else if (ap < a.length) {
        x[xp++] = a[ap++];
      } else if (bp < b.length) {
        x[xp++] = b[bp++];
      }
    }

    return x;
  }

  static <T extends Comparable<T>> void bubblesort(T[] a) {
    boolean repeat = true;

    while (repeat == true) {
      repeat = false;
      for (int i = 0; i < a.length - 1; i++) {
        if (a[i + 1].compareTo(a[i]) < 0) {
          T tmp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = tmp;
          repeat = true;
        }
      }
    }
  }
}
