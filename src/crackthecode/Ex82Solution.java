package crackthecode;

import java.util.HashMap;

public class Ex82Solution {
    static HashMap<String, Boolean> hm = new HashMap<>();

    static boolean robotPath(int[][] grid, int start_row, int start_column, int end_row, int end_column) {
        boolean path;

        if (hm.containsKey(Integer.toString(start_row) + "_" + Integer.toString(start_column)))
            return hm.get(Integer.toString(start_row) + "_" + Integer.toString(start_column));
        if (start_row > end_row || start_column > end_column)
            return false;
        else if (grid[start_row][start_column] == 1)
            return false;
        else if (start_row == end_row && start_column == end_column)
            path = true;
        else {
            path = robotPath(grid, start_row + 1, start_column, end_row, end_column) || robotPath(grid, start_row, start_column + 1, end_row, end_column);
        }
        return path;
    }

    static public void main(String args[]) {
        int[][] grid = {{0, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int end_row = grid[0].length - 1, end_column = grid.length - 1;

        System.out.println(robotPath(grid, 0, 0, end_row, end_column));
    }

}
