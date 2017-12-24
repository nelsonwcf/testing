package custom.structures;

public class LinkedList<T extends Comparable<T>> {
  public int size;
  public SimpleNode<T> head;
  public SimpleNode<T> current;

  public LinkedList() {
    size = 0;
    head = null;
    current = null;
  }

  public void add(T obj) {
    if (size == 0) {
      head = new SimpleNode<>(obj);
      current = head;
      size++;
      return;
    }

    current.next = new SimpleNode<>(obj);
    current = current.next;
    size++;
  }

  public void print() {
    SimpleNode<T> runner = head;
    while (runner != null) {
      System.out.print(runner.value + " ");
      runner = runner.next;
    }
    System.out.println();
  }
  
  public boolean isEmpty() {
    if (size > 0) {
      return false;
    }
    return true;
  }
}
