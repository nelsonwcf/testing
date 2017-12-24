package custom.structures;

public class BinarySearchTree<T extends Comparable<T>> {
  public int size;
  public BinaryTreeNode<T> head;

  public BinarySearchTree() {
    size = 0;
    head = null;
  }

  public void add(T v) {
    if (size == 0) {
      head = new BinaryTreeNode<T>(v);
      head.parent = null;
      size++;
      return;
    } else {
      BinaryTreeNode<T> runner = head;
      boolean foundNode = false;

      while (foundNode == false) {
        if (v.compareTo(runner.value) <= 0) {
          if (runner.left != null) {
            runner = runner.left;
          } else {
            runner.left = new BinaryTreeNode<>(v);
            runner.left.parent = runner;
            foundNode = true;
          }
        } else {
          if (runner.right != null) {
            runner = runner.right;
          } else {
            runner.right = new BinaryTreeNode<>(v);
            runner.right.parent = runner;
            foundNode = true;
          }
        }
      }
    }
  }

  public void inOrderPrint() {
    recPrint(head);
    System.out.println();
  }

  private void recPrint(BinaryTreeNode n) {
    if (n == null) {
      return;
    }

    recPrint(n.left);
    System.out.print(n.value + " ");
    recPrint(n.right);
  }
}
