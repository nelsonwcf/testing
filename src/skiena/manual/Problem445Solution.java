package skiena.manual;

import java.util.ArrayList;

class Triplet {
  private int currentMax;
  private int currentMin;
  private int[] currentTriplet = new int[3];

  private int minMax;
  private int minMin;
  private int[] minTriplet = new int[3];

  public Triplet() {
    minMax = 0;
    minMin = 0;
    currentMax = 0;
    currentMin = 0;
  }

  public void update(int n, int index) {
    currentTriplet[index] = n;
    currentMax = Math.max(currentTriplet[0], Math.min(currentTriplet[1], currentTriplet[2]));
    currentMin = Math.min(currentTriplet[0], Math.min(currentTriplet[1], currentTriplet[2]));

    if (currentDistance() < minDistance()) {
      minTriplet[0] = currentTriplet[0];
      minTriplet[1] = currentTriplet[1];
      minTriplet[2] = currentTriplet[2];
    }
  }

  public int currentDistance() {
    return currentMax - currentMin;
  }

  public int minDistance() {
    return minMax - minMin;
  }

  public int[] getMinTriplet() {
    return minTriplet;
  }
}

public class Problem445Solution {
  static int getMinSnippet(ArrayList<Integer> wordIndex1,ArrayList<Integer> wordIndex2, ArrayList<Integer> wordIndex3) {
    if (wordIndex1 == null || wordIndex2 == null || wordIndex3 == null) {
      return -1;
    }

    // Indexes of each wordIndex
    int i1 = 0, i2 = 0, i3 = 0;
    int distance = 0;
    Triplet triplet = new Triplet();

    while (i1 < wordIndex1.size() && i2 < wordIndex2.size() && i3 < wordIndex3.size()) {

    }
  }


}
