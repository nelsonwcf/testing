package careercup;

import java.util.Random;

public class PotsOfGoldSolution {

  static private int[] createPots() {
    Random n = new Random();
    int size = n.nextInt(20) + 1;
    int[] pots = new int[size];

    for (int i = 0; i < size; i++) {
      pots[i] = n.nextInt(10) + 1;
      System.out.print(pots[i] + " ");
    }
    System.out.println();


    return pots;
  }

  // Assumes two-players, A and B.
  static private int getMaxScore(int[] pots, int turn, int leftIndex, int rightIndex, boolean firstCall) {
    if (leftIndex == rightIndex) {
      return turn == 0 ? 0 : pots[leftIndex];
    }

    int result, right, left;

    if (turn == 1) {
      right = pots[rightIndex] + getMaxScore(pots, 0, leftIndex, rightIndex - 1, false);
      left = pots[leftIndex] + getMaxScore(pots, 0, leftIndex + 1, rightIndex, false);
      result =  Math.max(right, left);
    } else {
      right = getMaxScore(pots, 1, leftIndex, rightIndex - 1, false);
      left = getMaxScore(pots, 1, leftIndex + 1, rightIndex, false);
      result = Math.min(right, left);
    }

    if (!firstCall) {
      return result;
    }

    return turn == 1 ?
        (right > left ?
            pots[rightIndex] : pots[leftIndex])
        : -1;
  }

  public static void main(String[] args) {
    int[] pots = createPots();
    System.out.println(getMaxScore(pots, 1, 0, pots.length - 1, false));
    System.out.println(getMaxScore(pots, 1, 0, pots.length - 1, true));
  }

}