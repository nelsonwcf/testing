package careercup;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class KPalindromeSolution {
  static private boolean isKPalindrome(@NotNull String str, int k) {
    if (str.length() == 0) {
      return false;
    }
    if (str.length() == 1) {
      return true;
    }
    char[] array = str.toCharArray();
    return isKPalindromeAux(array, k, 0, array.length - 1);
  }

  static private boolean isKPalindromeAux(char[] array, int k, int left, int right) {
    if (k == 0) {
      for (int i = 0; i <= (right - left + 1) / 2; i++) {
        if (array[left + i] != array[right - i]) {
          return false;
        }
      }
      return true;
    }
    int i = 0;
    while (array[right - i] == array[left + i]) {
      if (right - i < left + i) {
        return true;
      }
      i++;
    }
    return
        isKPalindromeAux(array, k - 1, left + i + 1, right - i) ||
        isKPalindromeAux(array, k - 1, left + i, right - i - 1);
  }

  public static void main(String[] args) {
    String s = "aradbcara";
    int k = 1;
    System.out.println(isKPalindrome(s,2));
  }


}
