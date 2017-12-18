package custom.structures;

public class CustomBinaryTreeNode<T extends Comparable<T>> {
  public T value;
  public CustomBinaryTreeNode<T> left;
  public CustomBinaryTreeNode<T> right;

  public CustomBinaryTreeNode(T v) {
    value = v;
    left = null;
    right = null;
  }
}
