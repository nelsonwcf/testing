package scraps;

import java.util.ArrayList;

public class NonRecursiveCartesianProductSolution {
  static ArrayList<String> getCartesianProduct(String[][] str) {

    ArrayList<String> al = new ArrayList<>();

    al.add("");
    for (int row = 0; row < str.length; row++) {
      ArrayList<String> aux = new ArrayList<>();
      for (int column = 0; column < str[row].length; column++) {
        for (String s : al) {
          aux.add(s + " " + str[row][column]);
        }
      }
      al = aux;
    }
    return al;
  }

  public static void main(String[] args) {
    String[][] input = {{"grey", "black"}, {"fox", "dog"}};
    System.out.println(getCartesianProduct(input).toString());
  }
}
