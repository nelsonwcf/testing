package careercup;

public class PatternStringSolution {
  static boolean isPeriodic(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    StringBuilder sb = new StringBuilder();
    int i = 1;
    sb.append(s.charAt(i));
    while (i < s.length()) {
      // start matching the pattern
      // if the current character of s is equal to the first character of sb
      int j = 0;
      while (j < sb.length() && sb.charAt(j) == s.charAt(i)) {
        // check if the next character at sb exist and if so, if they a equal


      }
    }
  }
}
