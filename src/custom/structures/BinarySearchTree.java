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
            foundNode = true;
          }
        } else {
          if (runner.right != null) {
            runner = runner.right;
          } else {
            runner.right = new BinaryTreeNode<>(v);
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

  public static void main(String[] args) {
    BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
    bstree.add(5);
    bstree.add(2);
    bstree.add(3);
    bstree.add(10);
    bstree.add(8);
    bstree.add(6);
    bstree.add(11);
    bstree.inOrderPrint();
  }
}
