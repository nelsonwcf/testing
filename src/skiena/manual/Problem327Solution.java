package skiena.manual;

import custom.structures.CustomLinkedList;
import custom.structures.CustomNode;

public class Problem327Solution {
  static int detectLinkedlistLoop(CustomLinkedList list) {
    if (list == null || list.size == 0) {
      return 0;
    }

    int pos = 1;
    CustomNode fastRunner = list.head;
    CustomNode slowRunner = list.head;


  }
}

//                  s
//                  f
// -> A -> B -> C ->D ->B ->C ->D ->B ->C ->D ->B