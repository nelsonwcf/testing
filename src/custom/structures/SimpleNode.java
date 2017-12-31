package custom.structures;

public class SimpleNode<T> {
  public T value;
  public SimpleNode<T> next;

  public SimpleNode() {
    next = null;
  }

  public SimpleNode(T obj) {
    value = obj;
    next = null;
  }
}
