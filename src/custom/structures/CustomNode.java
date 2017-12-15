package custom.structures;

public class CustomNode<T extends Comparable<T>> {
  public T value;
  public CustomNode next;

  public CustomNode(T obj) {
    value = obj;
  }
}
