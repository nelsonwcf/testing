package pramp;

public class BasicRegexParserSolution {
  static boolean isMatch(String text, String pattern) {
    return text != null && pattern != null && isMatchAux(text, pattern);
  }

  private static boolean isMatchAux(String text, String pattern) {
    // case 0a: if text is empty and pattern is empty then pattern matched
    if (text.isEmpty() && pattern.isEmpty()) {
      return true;
    }

    // case 0b: if text is not empty and pattern is empty then pattern didn't match
    if (!text.isEmpty() && pattern.isEmpty()) {
      return false;
    }

    boolean hasStar = pattern.length() >= 2 && pattern.charAt(1) == '*';

    // case 1: next character in pattern is a simple char
    if (!hasStar && pattern.charAt(0) != '.') {
      return pattern.charAt(0) == text.charAt(0) && isMatchAux(text.substring(1, text.length()), pattern.substring(1, pattern.length()));
    }

    // case 2: next character in pattern is a dot
    if (!hasStar && pattern.charAt(0) == '.') {
      return isMatchAux(text.substring(1, text.length()), pattern.substring(1, pattern.length()));
    }

    // case 3: next character in pattern is a char with star
    if (hasStar && pattern.charAt(0) != '.') {
      int i = 0;
      boolean match = isMatchAux(text, pattern.substring(2, pattern.length()));
      while (!match && i < text.length() && text.charAt(i) == pattern.charAt(0)) {
        match = isMatchAux(text.substring(i + 1, text.length()), pattern.substring(2, pattern.length()));
        i++;
      }
      return match;
    }

    // case 4: next character in pattern is a dot with star
    if (hasStar && pattern.charAt(0) == '.') {
      int i = 0;
      boolean match = isMatchAux(text, pattern.substring(2, pattern.length()));
      while (!match && i < text.length()) {
        match = isMatchAux(text.substring(i + 1, text.length()), pattern.substring(2, pattern.length()));
        i++;
      }
      return match;
    }
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    String text = "abcabc";
    String pattern = "abca*b*c*";
    System.out.println(isMatch(text, pattern));
  }
}
