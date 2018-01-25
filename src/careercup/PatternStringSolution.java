package careercup;

public class PatternStringSolution {
  // space complexity: O(1); runtime complexity: O(n^2)
  static String getPeriod(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int patternEnd = 0; // points to the "current" end of the pattern since we don't know if there is a pattern yet
    int runner = 1;
    while (runner < s.length()) {
      // if char at runner != first char of string, is new addition to possible pattern
      // so set the patternEnd pointer to this character and increment runner
      if (s.charAt(0) != s.charAt(runner)) {
        patternEnd = runner;
        runner++;
      }
      // if char at runner == first char, check for the pattern match
      else {
        // if pattern match, set runner to the next character after the pattern
        if (pattMatch(s, patternEnd, runner)) {
          runner = runner + patternEnd + 1;
        }
        // if pattern doesn't match, move patternEnd to runner since it's a new addition
        // and increment runner
        // note: one improvement is to move the runner to the position patternEnd
        // to the position of the char that mismatched and runner to the next char
        // it is just increased for simplicity
        else {
          patternEnd = runner;
          runner++;
        }
      }
    }

    // if pattern is smaller than half of the string length, a pattern was found
    if ((patternEnd < s.length() / 2)) {
      return s.substring(0, patternEnd + 1);
    }
    // else, the pattern is the string, which means there is no pattern
    return "";
  }

  // instead of using substring, which increase the space complexity to O(n)
  // space complexity O(1); runtime complexity O(n)
  static private boolean pattMatch(String s, int patternEnd, int frontRunner) {
    for (int i = 0; i <= patternEnd; i++) {
      if (frontRunner == s.length() || s.charAt(frontRunner) != s.charAt(i)) {
        return false;
      }
      frontRunner++;
    }
    return true;
  }
}
