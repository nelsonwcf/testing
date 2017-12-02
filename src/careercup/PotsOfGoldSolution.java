package careercup;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PotsOfGoldSolution {

  //  static ArrayDeque<Integer> createListOfPots() {
//    ArrayDeque<Integer> pots = new ArrayDeque<>();
//
//    pots.addAll(Arrays.asList(3,2,9,7));
//    return pots;
//  }

  static int[] createPots() {
    int[] pots = new int[] {3,2,9,7};
    return pots;
  }

  static private int getMaxScore(int[] pots, int turn, int leftIndex, int rightIndex) {
    if (leftIndex > rightIndex) {
      return 0;
    }
    if (leftIndex - rightIndex == 0) {
      return turn == 0 ? 0 : pots[leftIndex];
    }

    return Math.max((turn == 1 ? pots[rightIndex] : 0) + getMaxScore(pots, turn == 0 ? 1 : 0,leftIndex, rightIndex - 1),
        (turn == 1 ? pots[leftIndex] : 0) + getMaxScore(pots, turn == 0 ? 1 : 0, leftIndex + 1, rightIndex));
  }

  public static void main(String[] args) {
    int[] pots = createPots();
    System.out.println(getMaxScore(pots,1,0,pots.length - 1));
  }

}