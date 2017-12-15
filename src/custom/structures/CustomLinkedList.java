package custom.structures;

public class CustomLinkedList<T extends Comparable<T>> {
  public int size;
  public CustomNode<T> head;
  public CustomNode<T> current;

  public CustomLinkedList() {
    size = 0;
    head = null;
    current = null;
  }

  public void add(T obj) {
    if (size == 0) {
      head = new CustomNode<>(obj);
      current = head;
      size++;
      return;
    }

    current.next = new CustomNode<>(obj);
    current = current.next;
    size++;
  }

  public void print() {
    CustomNode<T> runner = head;
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
