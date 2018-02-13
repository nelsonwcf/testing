package pramp;

import javafx.util.Pair;
import java.util.ArrayDeque;

public class IslandCountSolution {
  static int getNumberOfIslands(int[][] binaryMatrix) {
    if (binaryMatrix == null || binaryMatrix.length == 0) {
      return 0;
    }

    int totalIslands = 0;

    for (int i = 0; i < binaryMatrix.length; i++) {
      for (int j = 0; j < binaryMatrix[0].length; j++) {
        if (binaryMatrix[i][j] == 1) {
          totalIslands++;
          markIsland(binaryMatrix, i, j);
        }
      }
    }

    return totalIslands;
  }

  static void markIsland(int[][] bm, int row, int column) {
    if (row < 0 || row > bm.length - 1) {
      return;
    }

    if (column < 0 || column > bm[0].length - 1) {
      return;
    }

    if (bm[row][column] == 1) {
      bm[row][column] = 0;
      markIsland(bm, row - 1, column);
      markIsland(bm, row, column + 1);
      markIsland(bm, row + 1, column);
      markIsland(bm, row, column - 1);
    }
  }

  static int getNumberOfIslandsAlt(int[][] binaryMatrix) {
    if (binaryMatrix == null || binaryMatrix.length == 0) {
      return 0;
    }

    ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

    int totalIslands = 0;

    for (int i = 0; i < binaryMatrix.length; i++) {
      for (int j = 0; j < binaryMatrix[0].length; j++) {
        if (binaryMatrix[i][j] == 1) {
          totalIslands++;
          queue.addFirst(new Pair<>(i, j));
          while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.removeLast();
            int row = p.getKey();
            int column = p.getValue();
            binaryMatrix[row][column] = 0;
            if (row - 1 > 0 && binaryMatrix[row - 1][column] == 1) {
              queue.addFirst(new Pair<>(row - 1, column));
            }
            if (column + 1 < binaryMatrix[0].length && binaryMatrix[row][column + 1] == 1) {
              queue.addFirst(new Pair<>(row, column + 1));
            }
            if (row + 1 < binaryMatrix.length && binaryMatrix[row + 1][column] == 1) {
              queue.addFirst(new Pair<>(row + 1, column));
            }
            if (column - 1 > 0 && binaryMatrix[row][column - 1] == 1) {
              queue.addFirst(new Pair<>(row, column - 1));
            }
          }
        }
      }
    }
    return totalIslands;
  }
}
