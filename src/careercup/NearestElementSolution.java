package careercup;

import custom.structures.BinarySearchTree;
import custom.structures.BinaryTreeNode;

import java.util.function.Supplier;

public class NearestElementSolution {
  static int[] getNearestElements(BinarySearchTree bst, int element) {
    if (bst == null || bst.size == 0) {
      return null;
    }

    return null;
  }

  static <T extends Comparable<T>> T getNextSmallerElement(BinaryTreeNode<T> node) {
    T nodeValue = node.value;

    if (node.left != null) {
      node = node.left;
      while (node.right != null) {
        node = node.right;
      }
      return node.value;
    }
    else {
      while (node != null && node.value.compareTo(nodeValue) >= 0) {
        node = node.parent;
      }
      return node.value;
    }
  }

  static int getNextBiggerElement(BinaryTreeNode node) {
    return 0;

  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> bsp = new BinarySearchTree<>();
    bsp.add(10);


    System.out.println(getNextSmallerElement(bsp.head));
  }
}