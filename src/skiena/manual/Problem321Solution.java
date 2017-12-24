package skiena.manual;

import custom.structures.BinarySearchTree;
import custom.structures.BinaryTreeNode;

public class Problem321Solution {
  static boolean compareBinaryTrees(BinarySearchTree bt1, BinarySearchTree bt2) {
    BinaryTreeNode runner1 = bt1.head;
    BinaryTreeNode runner2 = bt2.head;

    if (runner1 != null && runner2 != null || runner1 == null && runner2 == null) {
      return recursiveCompareBinaryTrees(runner1, runner2);
    }
    return false;
  }

  private static boolean recursiveCompareBinaryTrees(BinaryTreeNode n1, BinaryTreeNode n2) {
    if (n1 == null && n2 != null || n1 != null && n2 == null) {
      return false;
    }

    if (n1 == null && n2 == null) {
      return true;
    }

    if (n1.value == n2.value) {
      return recursiveCompareBinaryTrees(n1.left, n2.left) && recursiveCompareBinaryTrees(n1.right, n2.right);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> bt1 = new BinarySearchTree<>();
    BinarySearchTree<Integer> bt2 = new BinarySearchTree<>();

    System.out.println(compareBinaryTrees(bt1, bt2));
  }
}
