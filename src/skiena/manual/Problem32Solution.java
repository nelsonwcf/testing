package skiena.manual;

import custom.structures.LinkedList;
import custom.structures.SimpleNode;

public class Problem32Solution {
  static void itReverseLinkedList(LinkedList ll) {
    if (ll == null || ll.isEmpty() || ll.size == 1)
      return;

    SimpleNode previous = null;
    SimpleNode current = ll.head;
    SimpleNode next = ll.head.next;

    ll.current = ll.head;

    while (next != null) {
      current.next = previous;
      previous = current;
      current = next;
      next = next.next;
    }

    current.next = previous;
    ll.head = current;
  }

  // solution here: https://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
  static void recReverseLinkedList(LinkedList ll) {
    ll.current = ll.head;
    ll.head = reverseCustomNode(ll.head);
  }

  static SimpleNode reverseCustomNode(SimpleNode n) {
    if (n == null) {
      return null;
    }
    if (n.next == null) {
      return n;
    }

    SimpleNode aux = n.next;
    n.next = null;
    SimpleNode reversedList = reverseCustomNode(aux);
    aux.next = n;
    return reversedList;
  }

  static void recPrintLinkedList(LinkedList ll) {
    if (ll == null || ll.isEmpty() || ll.size == 1) {
      return;
    }
    recursivePrint(ll.head);
  }

  static void recursivePrint(SimpleNode n) {
    if (n.next != null) {
      recursivePrint(n.next);
    }

    System.out.print(n.value + " ");
  }

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(5);
    ll.add(4);
    ll.add(3);
    ll.add(2);
    ll.add(1);
    recReverseLinkedList(ll);
    ll.print();
  }
}
