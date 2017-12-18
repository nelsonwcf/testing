package skiena.manual;

import custom.structures.CustomBinarySearchTree;
import custom.structures.CustomBinaryTreeNode;
import custom.structures.CustomLinkedList;

public class Problem322Solution {
  static <T extends Comparable<T>> CustomLinkedList<T> tree2List(CustomBinarySearchTree<T> bt) {
    if (bt == null || bt.head == null) {
      return null;
    }

    return tree2ListAux(bt.head, new CustomLinkedList<T>());
  }

  private static <T extends Comparable<T>> CustomLinkedList<T> tree2ListAux(CustomBinaryTreeNode<T> node, CustomLinkedList<T> list) {
    if (node == null) {
      return list;
    }
    tree2ListAux(node.left, list);
    list.add(node.value);
    tree2ListAux(node.right, list);
    return list;
  }

  public static void main(String[] args) {
    CustomBinarySearchTree<Integer> bt = new CustomBinarySearchTree<>();
    bt.add(3);
    bt.add(1);
    bt.add(10);
    bt.add(5);

    bt.inOrderPrint();

    CustomLinkedList<Integer> list = tree2List(bt);
    list.print();


  }
}
