package custom.structures;

public class CustomBinarySearchTree<T extends Comparable<T>> {
  public int size;
  public CustomBinaryTreeNode<T> head;

  public CustomBinarySearchTree() {
    size = 0;
    head = null;
  }

  public void add(T v) {
    if (size == 0) {
      head = new CustomBinaryTreeNode<T>(v);
      size++;
      return;
    } else {
      CustomBinaryTreeNode<T> runner = head;
      boolean foundNode = false;

      while (foundNode == false) {
        if (v.compareTo(runner.value) <= 0) {
          if (runner.left != null) {
            runner = runner.left;
          } else {
            runner.left = new CustomBinaryTreeNode<>(v);
            foundNode = true;
          }
        } else {
          if (runner.right != null) {
            runner = runner.right;
          } else {
            runner.right = new CustomBinaryTreeNode<>(v);
            foundNode = true;
          }
        }
      }
    }
  }

  public void inOrderPrint() {
    recPrint(head);
  }

  private void recPrint(CustomBinaryTreeNode n) {
    if (n == null) {
      return;
    }

    recPrint(n.left);
    System.out.println(n.value);
    recPrint(n.right);
  }

  public static void main(String[] args) {
    CustomBinarySearchTree<Integer> bstree = new CustomBinarySearchTree<>();
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
