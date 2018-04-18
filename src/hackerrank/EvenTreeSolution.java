package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EvenTreeSolution {
  static class Node {
    static final int PARENT = 0;

    ArrayList<Pair<Node, Integer>> neighbor;
    int value;

    Node(int value) {
      this.value = value;
      neighbor = new ArrayList<>();
    }

    Node(int value, Node parent) {
      this(value);
      neighbor.add(new Pair<>(parent, 0));
    }
  }

  static class Tree {

  }



  static int evenTree(int n, int m, int[][] tree) {
    return 0;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();


  }
}