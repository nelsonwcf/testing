package pramp;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class SudokuSolverSolution {
  static boolean sudokuSolve(char[][] board) {

    // first pass - get all possible elements of each position
    // 829 operations -> O(1)
    HashMap<Pair<Integer, Integer>, ArrayList<Character>> dict = new HashMap<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          Pair<Integer, Integer> p = new Pair<>(i, j);
          dict.put(p, new ArrayList<>());
          for (int k = 0; k < 9; k++) {
            if (isValid((char) (k + '0'), i, j, board)) {
              dict.get(p).add((char) (k + '0'));
            }
          }
        }
      }
    }

    // recursive call to solve the board
    return recSudo(0, 0, board, dict);
  }

  static private boolean recSudo(int x, int y, char[][] board, HashMap<Pair<Integer, Integer>, ArrayList<Character>> map) {
    if (x > 8) {
      return true;
    }

    int newY;
    int newX;
    Pair<Integer, Integer> p = new Pair<>(x, y);
    if (y < 8) {
      newY = y + 1;
      newX = x;
    } else {
      newY = 0;
      newX = x + 1;
    }

    if (board[x][y] != '.') {
      return recSudo(newX, newY, board, map);
    }

    for (Character c : map.get(p)) {
      board[x][y] = c;
      boolean result = recSudo(newX, newY, board, map);
      if (result) {
        return true;
      }
      board[x][y] = '.';
    }

    return false;
  }

  static private boolean isValid(char n, int x, int y, char[][] board) {
    // is element valid in the row?
    for (int j = 0; j < 9; j++) {
      if (j != y && board[x][j] == n) {
        return false;
      }
    }

    // is element valid in the column?
    for (int i = 0; i < 9; i++) {
      if (i != x && board[i][y] == n) {
        return false;
      }
    }

    // is element valid in the block?
    int squareX = x / 3;
    int squareY = y / 3;

    for (int i = squareX * 3; i < (1 + squareX) * 3 - 1; i++) {
      for (int j = squareY * 3; j < (1 + squareY) * 3 - 1; j++) {
        if (i != x && j != y && board[i][j] == n) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] sudoku = {
        {'.', '.', '5', '.', '.', '2', '.', '.', '.'},
        {'.', '.', '9', '.', '4', '7', '.', '2', '.'},
        {'.', '.', '8', '.', '5', '6', '.', '.', '1'},
        {'.', '.', '.', '.', '.', '8', '3', '4', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
        {'.', '.', '.', '.', '3', '.', '1', '8', '.'},
        {'.', '2', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '9', '.', '.', '8', '.', '6', '7', '.'},
        {'3', '.', '6', '5', '7', '.', '.', '.', '.'}
    };
    char[][] sudoku2 = {
        {'.', '8', '9', '.', '4', '.', '6', '.', '5'},
        {'.', '7', '.', '.', '.', '8', '.', '4', '1'},
        {'5', '6', '.', '9', '.', '.', '.', '.', '8'},
        {'.', '.', '.', '7', '.', '5', '.', '9', '.'},
        {'.', '9', '.', '4', '.', '1', '.', '5', '.'},
        {'.', '3', '.', '9', '.', '6', '.', '1', '.'},
        {'8', '.', '.', '.', '.', '.', '.', '.', '7'},
        {'.', '2', '.', '8', '.', '.', '.', '6', '.'},
        {'.', '.', '6', '.', '7', '.', '.', '8', '.'}
    };
    System.out.println(sudokuSolve(sudoku2));
  }
}
