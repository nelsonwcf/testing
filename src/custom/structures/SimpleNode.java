package custom.structures;

public class SimpleNode<T extends Comparable<T>> {
  T value;
  SimpleNode<T> next;

  SimpleNode(T value) {
    this.value = value;
    this.next = null;
  }
}
