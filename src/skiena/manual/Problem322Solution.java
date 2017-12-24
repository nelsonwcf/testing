package skiena.manual;

import custom.structures.BinarySearchTree;
import custom.structures.BinaryTreeNode;
import custom.structures.LinkedList;

public class Problem322Solution {
  static <T extends Comparable<T>> LinkedList<T> tree2List(BinarySearchTree<T> bt) {
    if (bt == null || bt.head == null) {
      return null;
    }

    return tree2ListAux(bt.head, new LinkedList<T>());
  }

  private static <T extends Comparable<T>> LinkedList<T> tree2ListAux(BinaryTreeNode<T> node, LinkedList<T> list) {
    if (node == null) {
      return list;
    }
    tree2ListAux(node.left, list);
    list.add(node.value);
    tree2ListAux(node.right, list);
    return list;
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> bt = new BinarySearchTree<>();
    bt.add(3);
    bt.add(1);
    bt.add(10);
    bt.add(5);

    bt.inOrderPrint();

    LinkedList<Integer> list = tree2List(bt);
    list.print();


  }
}
