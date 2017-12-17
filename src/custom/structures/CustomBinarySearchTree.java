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
          }

        }

      }
    }




  }

}
