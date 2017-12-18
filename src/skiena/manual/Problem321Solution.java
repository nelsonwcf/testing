package skiena.manual;

import custom.structures.CustomBinarySearchTree;
import custom.structures.CustomBinaryTreeNode;

public class Problem321Solution {
  static boolean compareBinaryTrees(CustomBinarySearchTree bt1, CustomBinarySearchTree bt2) {
    CustomBinaryTreeNode runner1 = bt1.head;
    CustomBinaryTreeNode runner2 = bt2.head;

    if (runner1 != null && runner2 != null || runner1 == null && runner2 == null) {
      return recursiveCompareBinaryTrees(runner1, runner2);
    }
    return false;
  }

  private static boolean recursiveCompareBinaryTrees(CustomBinaryTreeNode n1, CustomBinaryTreeNode n2) {
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
    CustomBinarySearchTree<Integer> bt1 = new CustomBinarySearchTree<>();
    CustomBinarySearchTree<Integer> bt2 = new CustomBinarySearchTree<>();

    System.out.println(compareBinaryTrees(bt1, bt2));
  }
}
