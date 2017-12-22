package skiena.manual;

import java.util.Arrays;
import java.util.HashMap;

public class Problem824Solution {
    // Iterative version - doesn't need memoization
/*  static int findMinimumCoins(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return 0;
    }

    int localAmount = amount;

    int min = 0;
    for (int i = 0; i < coins.length; i++) {
      while (localAmount - coins[i] >= 0) {
        localAmount = localAmount - coins[i];
        min++;
        if (localAmount == 0)
          return min;
      }
    }
    return 0;
  }*/

  // Recursive version with Memoization
  static int findMimCoins(int[] coinSize, int amount) {
    if (coinSize == null || coinSize.length == 0) {
      return 0;
    }

    int[] memory = new int[amount + 1];
    Arrays.fill(memory, amount);
    return recfmc(coinSize, amount, memory);
  }

  private static int recfmc(int[] coinSize, int amount, int[] memory) {
    if (amount >= 0 && memory[amount] < memory[0]) {
      return memory[amount];
    }

    for (int i = 0; i < coinSize.length; i++) {
      if (amount == coinSize[i]) {
        return 1;
      }
    }

    boolean hasOptionLeft = false;
    for (int i = 0; i < coinSize.length; i++) {
      if (amount - coinSize[i] > 0) {
        hasOptionLeft = true;
      }
      if (!hasOptionLeft) {
        return memory[0];
      }
    }

    int[] coinMin = new int[coinSize.length];
    Arrays.fill(coinMin, memory[0]);

    for (int i = 0; i < coinSize.length; i++) {
      coinMin[i] = recfmc(coinSize, amount - coinSize[i], memory);
    }
    int min = memory[0];
    for (int i = 0; i < coinSize.length; i++) {
      if (coinMin[i] < min) {
        min = coinMin[i];
      }
    }
    memory[amount] = 1 + min;
    return 1 + min;
  }

  public static void main(String[] args) {
    int[] coinSize = {100,50,25,10,5,2,1};
    int value = 100000;
    System.out.println(findMimCoins(coinSize, value));
  }
}
