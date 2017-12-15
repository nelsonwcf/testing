package skiena.manual;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem31Solution {
  static int isBalanced(String str) {
    if (str == null || str.isEmpty()) {
      return -1;
    }

    // Traverse the string adding parenthesis to stack
    ArrayDeque<Character> parenthesesStack = new ArrayDeque<>();
    ArrayDeque<Integer> indexStack = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      if(c == '(') { // Opening parentheses can always be added
        parenthesesStack.push(c);
        indexStack.push(i);
      } else if (c == ')') { // Closing parenthesis can only be added after an opening one
        if (!parenthesesStack.isEmpty() && parenthesesStack.peek() == '(') {
          parenthesesStack.pop(); // Remove the closing of parenthesis
          indexStack.pop();
        } else {
          return i;
        }
      }
    }
    if (parenthesesStack.isEmpty()) {
      return -1;
    }
    return indexStack.pop();
  }

  public static void main(String args[]) {
    String s = "()(())())";
    System.out.println(isBalanced(s));
  }
}
