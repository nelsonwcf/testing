package skiena.manual;

import custom.structures.LinkedList;
import custom.structures.SimpleNode;

public class Problem320Solution {
  static SimpleNode getMidNode(LinkedList ll) {
    if (ll == null) {
      return null;
    }

    int listSize = 1;
    SimpleNode n = ll.head;
    while (n.next != null) {
      n = n.next;
      listSize++;
    }

    n = ll.head;
    for (int i = 0; i < (listSize - 1) / 2; i++) {
      n = n.next;
    }

    return n;
  }

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();

    ll.add(1);
    ll.add(2);
    ll.add(3);
    ll.add(4);


    System.out.println(getMidNode(ll).value);

  }
}
