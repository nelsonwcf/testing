package scraps;

import java.util.TreeMap;

public class TreeMapTest {
  public static void main(String[] args) {
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    tm.put(1,1);
    tm.put(2,2);
    tm.put(4,4);
    tm.put(3,3);
    tm.put(9,9);
    tm.put(8,8);
    for (int n : tm.keySet())
      System.out.println(n);
  }
}
