package hackerrank;

import java.util.Scanner;

public class FormingAMagicSquareSolution {
  static class MagicSquare {
    private int[][] magicSquare = {{2,7,6}, {9,5,1}, {4,3,8}};

    void rotateACW() {
      int aux = magicSquare[0][0];
      magicSquare[0][0] = magicSquare[0][2];
      magicSquare[0][2] = magicSquare[2][2];
      magicSquare[2][2] = magicSquare[2][0];
      magicSquare[2][0] = aux;
      aux = magicSquare[0][1];
      magicSquare[0][1] = magicSquare[1][2];
      magicSquare[1][2] = magicSquare[2][1];
      magicSquare[2][1] = magicSquare[1][0];
      magicSquare[1][0] = aux;
    }

    void rotateCW() {
      int aux = magicSquare[0][0];
      magicSquare[0][0] = magicSquare[2][0];
      magicSquare[2][0] = magicSquare[2][2];
      magicSquare[2][2] = magicSquare[0][2];
      magicSquare[0][2] = aux;
      aux = magicSquare[0][1];
      magicSquare[0][1] = magicSquare[1][0];
      magicSquare[1][0] = magicSquare[2][1];
      magicSquare[2][1] = magicSquare[1][2];
      magicSquare[1][2] = aux;
    }

    void mirrorUp() {
      int[] aux = magicSquare[2];
      magicSquare[2] = magicSquare[0];
      magicSquare[0] = aux;
    }

    int[][] getMagicSquare() {
      return magicSquare;
    }
  }

  static int formingMagicSquare(int[][] s) {
    if (s == null || s.length == 0) {
      return -1;
    }
    MagicSquare magicSquare = new MagicSquare();
    int[][] sq;

    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      sq = magicSquare.getMagicSquare();
      int cost = getCost(s,sq);
      minCost = cost < minCost ? cost : minCost;
      magicSquare.rotateCW();
    }
    magicSquare.mirrorUp();
    for (int i = 0; i < 4; i++) {
      sq = magicSquare.getMagicSquare();
      int cost = getCost(s,sq);
      minCost = cost < minCost ? cost : minCost;
      magicSquare.rotateCW();
    }

    return minCost;
  }

  private static int getCost(int[][] a, int[][] b) {
    int cost = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        cost += Math.abs(a[i][j] - b[i][j]);
      }
    }
    return cost;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] s = new int[3][3];
    for(int s_i = 0; s_i < 3; s_i++){
      for(int s_j = 0; s_j < 3; s_j++){
        s[s_i][s_j] = in.nextInt();
      }
    }
    int result = formingMagicSquare(s);
    System.out.println(result);
    in.close();
  }
}