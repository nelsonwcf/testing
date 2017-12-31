package custom.structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    SimpleNode aux = head;

    sb.append("[ ");
    while (aux != null) {
      sb.append(aux.value);
      aux = aux.next;
      if (aux != null) {
        sb.append(", ");
      }
    }

    sb.append(" ]");
    return sb.toString();
  }

  public boolean isEmpty() {
    if (size > 0) {
      return false;
    }
    return true;
  }

//  @Override
//  public Iterator<T> iterator() {
//    if (size > 0) {
//      T[] values = (T[]) Array.newInstance(head.value.getClass(), size);
//      SimpleNode aux = head;
//      int i = 0;
//      while (aux != null) {
//        values[i] = (T) aux.value;
//        i++;
//        aux = aux.next;
//      }
//      return Arrays.asList(values).iterator();
//    }
//    return new ArrayList<T>().iterator();
//  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator {
    private SimpleNode<T> currentNode;

    public LinkedListIterator() {
      currentNode = new SimpleNode<T>();
      currentNode.next = head;
    }

    @Override
    public boolean hasNext() {
      return currentNode.next != null;
    }

    @Override
    public T next() {
      currentNode = currentNode.next;
      return currentNode.value;
    }
  }

}
