package skiena.manual;

import custom.structures.CustomLinkedList;
import custom.structures.CustomNode;

public class Problem32Solution {
  static void itReverseLinkedList(CustomLinkedList ll) {
    if (ll == null || ll.isEmpty() || ll.size == 1)
      return;

    CustomNode previous = null;
    CustomNode current = ll.head;
    CustomNode next = ll.head.next;

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
  static void recReverseLinkedList(CustomLinkedList ll) {
    reverseAux(ll.head);
  }

  static CustomNode reverseAux(CustomNode node) {
    CustomNode test;
    if (node.next != null) {
      test = reverseAux(node);
    }
    test.next = node;
  }

  static void recPrintLinkedList(CustomLinkedList ll) {
    if (ll == null || ll.isEmpty() || ll.size == 1) {
      return;
    }
    recursivePrint(ll.head);
  }

  static void recursivePrint(CustomNode n) {
    if (n.next != null) {
      recursivePrint(n.next);
    }

    System.out.print(n.value + " ");
  }

  public static void main(String[] args) {
    CustomLinkedList<Integer> ll = new CustomLinkedList<>();
    ll.add(2);
    ll.add(1);
    ll.print();
    recPrintLinkedList(ll);
  }
}
