package custom.structures;

public class SimpleNode<T> {
  public T value;
  public SimpleNode next;

  public SimpleNode(T obj) {
    value = obj;
  }
}
