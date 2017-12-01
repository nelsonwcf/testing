package custom.structures;

public class QuickSortDemo {
	static <T extends Comparable<T>> void quicksort(T[] array) {
		// Empty or one element arrays are already sorted
		if (array.length > 1)
			qsort(array, 0, array.length - 1);
	}

	static <T extends Comparable<T>> void qsort(T[] array, int left, int right) {
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

	public static void main(String args[]) {
		Integer[] array = { 7, 2, 13, 9, 26, 22, 1, 4, 3, 5, 11, 8, 2 }; // {1,2,3,4,5,7,8,9,11,13,22,26}

		quicksort(array);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}

}
