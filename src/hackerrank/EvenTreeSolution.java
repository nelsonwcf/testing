package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class EvenTreeSolution {
  static class Node {
    // parent will the first node in the list
    static final int PARENT = 0;

    // pairs will contain the node who is child and total nodes behind that edge
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

    void addNode(Node n) {
      neighbor.add(new Pair<>(n, 0));
    }
  }

  static class Tree {
    Node head;
    int size;

    Tree() {
      head = null;
      size = 0;
    }

    void addEdge(Node parent, Node child) {
      parent.addNode(child);
    }

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