package crackthecode;

public class Ex17Solution {

    // Time complexity is O(n)
    // Space complexity in this case was O(1)
    // Would make the algorithm simpler if it was
    // possible to use an auxiliary matrix
    // which would make space complexity O(n) as well
    static void rotateMatrix(int[][] image) {
        if (image == null || image.length <= 1)
            return;

        int tmp;
        int lastPos = image.length - 1;

        // Iterate on the "layers" of the matrix
        for (int i = 0; i < image.length / 2; i++) {
            // Shift the corners
            tmp = image[i][i];
            image[i][i] = image[i][lastPos - i];
            image[i][lastPos - i] = image[lastPos - i][lastPos - i];
            image[lastPos - i][lastPos - i] = image[lastPos - i][i];
            image[lastPos - i][i] = tmp;

            // Shift the middle elements
            for (int j = i + 1; j < image.length - i - 1; j++) {
                tmp = image[i][j];
                image[i][j] = image[j][lastPos - i];
                image[j][lastPos - i] = image[lastPos - i][lastPos - j];
                image[lastPos - i][lastPos - j] = image[lastPos - j][i];
                image[lastPos - j][i] = tmp;
            }
        }
        return;
    }

    public static void main(String args[]) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        rotateMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
