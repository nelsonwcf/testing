package custom.structures;

public class CustomBinaryTreeNode<T extends Comparable<T>> extends CustomNode<T> {
  public T value;
  public CustomNode<T> left;
  public CustomNode<T> right;

  public CustomBinaryTreeNode(T v) {
    value = v;
    left = null;
    right = null;
  }
}
