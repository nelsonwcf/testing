package careercup;

import java.util.HashMap;

public class WaysOfBreakfastSolution {
  static final int NOTHING = 0;
  static final int BREAD_AND_BUTTER = 1;
  static final int PIZZA = 2;
  static final int BURGER = 3;

  static int getNumberOfBreakfastWays(int numberOfDays) {
    if (numberOfDays <= 0) {
      return 0;
    }

    return recBreakfast(numberOfDays, NOTHING, NOTHING, new HashMap<String,Integer>());
  }

  private static int recBreakfast(int days, int previousDay, int previousTwoDays, HashMap<String, Integer> memory) {
    if (memory.containsKey(days + "_" + previousDay + "_" + previousTwoDays)) {
      return memory.get(days + "_" + previousDay + "_" + previousTwoDays);
    }

    if (days == 1) {
      if (previousTwoDays == BURGER || previousDay == BURGER) {
        if (previousDay == PIZZA) {
          return 1;
        }
        else {
          return 2;
        }
      }
      else if (previousDay == PIZZA) {
        return 2;
      }
      else {
        return 3;
      }
    }
    int result = 0;

    if (previousDay == BURGER) {
      result = recBreakfast(days - 1, BREAD_AND_BUTTER, BURGER, memory) + recBreakfast(days - 1, PIZZA, BURGER, memory);
    }
    else if (previousTwoDays == BURGER) {
      if (previousDay == PIZZA) {
        result = recBreakfast(days - 1, BREAD_AND_BUTTER, PIZZA, memory);
      } else {
        result = recBreakfast(days - 1, PIZZA, BREAD_AND_BUTTER, memory) + recBreakfast(days - 1, BREAD_AND_BUTTER, BREAD_AND_BUTTER, memory);
      }
    }
    else if (previousDay == PIZZA) {
      result = recBreakfast(days - 1, BREAD_AND_BUTTER, PIZZA, memory) + recBreakfast(days - 1, BURGER, PIZZA, memory);
    }
    else {
      result = recBreakfast(days - 1, BREAD_AND_BUTTER, BREAD_AND_BUTTER, memory) + recBreakfast(days - 1, PIZZA, BREAD_AND_BUTTER, memory) + recBreakfast(days - 1, BURGER, BREAD_AND_BUTTER, memory);
    }
    memory.put(days + "_" + previousDay + "_" + previousTwoDays, result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(getNumberOfBreakfastWays(3));
  }
}
