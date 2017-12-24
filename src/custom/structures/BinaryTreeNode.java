package custom.structures;

public class BinaryTreeNode<T extends Comparable<T>> {
  public T value;
  public BinaryTreeNode<T> left;
  public BinaryTreeNode<T> right;
  public BinaryTreeNode<T> parent;

  public BinaryTreeNode(T v) {
    value = v;
    left = null;
    right = null;
    parent = null;
  }
}
