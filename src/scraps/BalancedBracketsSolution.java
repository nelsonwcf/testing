package scraps;

import java.util.ArrayDeque;

public class BalancedBracketsSolution {
  static boolean balancedBrackets(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }

    ArrayDeque<Character> par = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(') {
        par.addFirst(c);
      } else if (c == ')') {
        if (!par.isEmpty() && par.peekFirst() == '(') {
          par.removeFirst();
        } else {
          return false;
        }
      }
    }
    if (par.isEmpty()) {
      return true;
    }
    return false;
  }
}
