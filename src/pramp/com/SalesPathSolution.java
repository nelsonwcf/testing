package pramp.com;

public class SalesPathSolution {
  static int recursiveCalls = 0;

  static int getCheapestCost(Node rootNode) {
    recursiveCalls++;
    if (rootNode.children == null) {
      return rootNode.cost;
    }

    int minPath = Integer.MAX_VALUE;
    for (int i = 0; i < rootNode.children.length; i++) {
      if (minPath < rootNode.children[i].cost) {
        continue;
      }
      int aux = getCheapestCost(rootNode.children[i]);
      if (minPath > aux) {
        minPath = aux;
      }
    }

    return rootNode.cost + minPath;
  }

  public static void main(String[] args) {
    Node root = new Node(0);
    root.children = new Node[3];
    root.children[0] = new Node(5);
    root.children[1] = new Node(3);
    root.children[2] = new Node(6);
    root.children[0].children = new Node[1];
    root.children[0].children[0] = new Node(4);

    root.children[1].children = new Node[2];
    root.children[1].children[0] = new Node(2);
    root.children[1].children[1] = new Node(0);

    root.children[2].children = new Node[2];
    root.children[2].children[0] = new Node(1);
    root.children[2].children[1] = new Node(5);

    root.children[1].children[0].children = new Node[1];
    root.children[1].children[0].children[0] = new Node(1);

    root.children[1].children[0].children[0].children = new Node[1];
    root.children[1].children[0].children[0].children[0] = new Node(1);

    root.children[1].children[1].children = new Node[1];
    root.children[1].children[1].children[0] = new Node(10);

    System.out.println(getCheapestCost(root));
    System.out.println(recursiveCalls);

  }
}

class Node {
  int cost;
  Node[] children;
  Node parent;

  Node(int cost) {
    this.cost = cost;
    children = null;
    parent = null;
  }
}