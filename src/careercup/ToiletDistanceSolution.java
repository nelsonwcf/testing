package careercup;

import java.util.Arrays;

public class ToiletDistanceSolution {
  static int sumOfOccupiedToilets(int toilets, int people) {
    if (people >= toilets) {
      return (toilets * (1 + toilets)) / 2;
    }

    int[] currentDistances = new int[toilets];
    Arrays.fill(currentDistances, Integer.MAX_VALUE);
    int sum = 0;
    int maxDistIndex = 0;

    for (int i = 0; i < people; i++) {
      int pos = maxDistIndex;
      currentDistances[pos] = 0;
      sum += pos + 1;
      maxDistIndex = 0;
      for (int j = 0; j < currentDistances.length; j++) {
        currentDistances[j] = Math.min(Math.abs(pos - j), currentDistances[j]);
        if (maxDistIndex < currentDistances[j]) {
          maxDistIndex = currentDistances[j];
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(sumOfOccupiedToilets(5, 5));
  }
}
