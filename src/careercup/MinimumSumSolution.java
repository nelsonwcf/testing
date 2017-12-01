import java.util.HashMap;

public class MinimumSumSolution {
  private static int getMinimumSumLevel(graphs.Node root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    HashMap<Integer, Integer> dict = new HashMap<>();
    auxGMSL(root, 1, dict);

    int minLevel = Integer.MAX_VALUE;
    int minSum = Integer.MAX_VALUE;

    for (int i : dict.keySet()) {
      int aux = dict.get(i);
      if (minSum > aux) {
        minSum = aux;
        minLevel = i;
      }
    }

    return minLevel;
  }

  private static void auxGMSL(graphs.Node n, int level, HashMap<Integer, Integer> dict) {
    if (!dict.containsKey(level)) {
      dict.put(level, n.value);
    } else {
      dict.put(level, dict.get(level) + n.value);
    }

    if (n.left != null) {
      auxGMSL(n.left, level + 1, dict);
    }

    if (n.right != null) {
      auxGMSL(n.right, level + 1, dict);
    }
  }

  public static void main(String[] args) {
    graphs.Node root = new graphs.Node(10);
    root.left = new graphs.Node(4);
    root.right = new graphs.Node(7);
    root.left.left = new graphs.Node(2);
    root.left.right = new graphs.Node(3);
    root.right.left = new graphs.Node(4);

    System.out.println(getMinimumSumLevel(root));
  }
}

class Node {
  int value;
  graphs.Node left;
  graphs.Node right;

  Node(int v) {
    value = v;
    left = null;
    right = null;
  }
}