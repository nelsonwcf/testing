package careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SumOfIntegersSubsetSolution {
  static HashSet<ArrayList<Integer>> getListOfSums(ArrayList<Integer> list, int sum) {
    HashSet<ArrayList<Integer>> result = new HashSet<>();

    if (list == null || list.isEmpty() || sum < 0)
      return result;

    recGetListOfSums(list, sum, new ArrayList<Integer>(), result);
    return result;
  }

  private static void recGetListOfSums(ArrayList<Integer> list, int sum, ArrayList<Integer> aux, HashSet<ArrayList<Integer>> result) {
    int length;

    if (sum == 0) {
      result.add(new ArrayList<>(aux));
      return;
    }

    if (sum < 0) {
      return;
    }

    length = list.size();

    for (int i = 0; i < length; i++) {
      int current = list.remove(i);
      aux.add(new Integer(current));
      recGetListOfSums(list, sum - current, aux, result);
      aux.remove(aux.size() - 1);
      list.add(i, new Integer(current));
    }
  }

  public static void main(String[] args) {
    int sum = 3;
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,5,10,5));
    System.out.println(getListOfSums(list, sum));
  }
}