public class Ex83Solution {
    static int magicIndex(int[] array) {
        return mIA(array, 0, array.length - 1);
    }

    /* Simpler code for distinct elements only
    static int mIA(int[] array, int left, int right) {
        int mid = (left + right) / 2;

        if (left > right)
            return -1;
        else if (array[mid] == mid)
            return mid;
        else if (array[mid] < mid)
            return mIA(array, mid + 1, right);
        else
            return mIA(array, left, mid - 1);
    }
    */

    // More complex code to allow non-distinct elements
    // When there is no guarantee for distinct elements
    // Both sides have to be searched, but not in its
    // entirety.
    static int mIA(int[] array, int left, int right) {
        // Base case for when the index is not found
        if (left > right)
            return -1;

        int midIndex = (left + right) / 2;
        int midValue = array[midIndex];

        // Base case for when the index is found
        if (midValue == midIndex)
            return midIndex;

        // Search the left part of the array
        // If found of the left part, return
        int leftIndex = Math.min(midIndex - 1, midValue);
        int foundLeft = mIA(array, left, leftIndex);
        if (foundLeft >= 0)
            return foundLeft;

        // Else search the right part of the Array
        // Return either the found value or -1
        int rightIndex = Math.max(midIndex + 1, midValue);
        int foundRight = mIA(array, rightIndex, right);

        return right;
    }

    public static void main(String args[]) {
        int[] array = {-2, -2, -2, 3};
        System.out.println(magicIndex(array));
    }
}
