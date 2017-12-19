package skiena.manual;

import custom.structures.CustomLinkedList;
import custom.structures.CustomNode;
import sun.awt.image.ImageWatched;

public class Problem327Solution {
  static int detectLinkedlistLoop(CustomLinkedList list) {
    if (list == null || list.size == 0) {
      return 0;
    }

    int pos = 1;
    CustomNode fastRunner = list.head;
    CustomNode slowRunner = list.head;

    // Moving runners until fastRunner reaches the end or both runners meet
    while (fastRunner != null) {
      fastRunner = fastRunner.next;
      if (fastRunner != null) {
        fastRunner = fastRunner.next;
      } else {
        return 0;
      }
      slowRunner = slowRunner.next;
      if (fastRunner == slowRunner) {
        break;
      }
    }

    // Found a loop
    int loopSize = 0;
    do {
      fastRunner = fastRunner.next;
      loopSize++;
    } while (fastRunner != slowRunner);

    // Finding the intersection
    fastRunner = list.head;
    for (int i = 0; i < loopSize; i++) {
      fastRunner = fastRunner.next;
    }
    slowRunner = list.head;

    int loopPosition = 1;
    while (fastRunner != slowRunner) {
      fastRunner = fastRunner.next.next;
      slowRunner = slowRunner.next;
      loopPosition++;
    }

    return loopPosition;
  }

  public static void main(String[] args) {
    CustomLinkedList<Integer> ll = new CustomLinkedList<>();
    ll.add(1);
    ll.add(2);
    ll.head.next.next = ll.head.next;
    System.out.print(detectLinkedlistLoop(ll));
  }
}