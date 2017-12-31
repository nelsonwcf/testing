package scraps;

import custom.structures.LinkedList;

public class LinkedListIteratorTest {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(10);
    ll.add(20);
    ll.add(19);
    ll.add(11);

    for (Integer i : ll) {
      System.out.print(i + " ");
    }
  }

}
