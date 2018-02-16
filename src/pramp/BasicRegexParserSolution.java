package pramp;

public class BasicRegexParserSolution {
  static boolean isMatch(String text, String pattern) {
    if (text == null || pattern == null) {
      return false;
    }

    return isMatchAux(text, pattern);
  }

  private static boolean isMatchAux(String text, String pattern) {
    if (text.isEmpty() && pattern.isEmpty()) {
      return true;
    }

    if (!text.isEmpty() && pattern.isEmpty()) {
      return false;
    }

    if (pattern.length() < 2 || pattern.charAt(1) != '*') {
      if (pattern.charAt(0) != '.') {
        if (pattern.charAt(0) == text.charAt(0)) {
          return isMatchAux(text.substring(1, text.length()), pattern.substring(1, pattern.length()));
        }
        else {
          return false;
        }
      }
      else {
        return isMatchAux(text.substring(1, text.length()), pattern.substring(1, pattern.length()));
      }
    }
    else {
      int i = 0;
      boolean match = isMatch(text, pattern.substring(2, pattern.length()));
      while (i < text.length() && text.charAt(i) == ) {

      }
    }
  }
}
