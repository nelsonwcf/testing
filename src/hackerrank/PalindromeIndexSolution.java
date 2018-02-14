package hackerrank;

public class PalindromeIndexSolution {

  // runtime complexity: O(n), space complexity: O(1)
  static int palindromeIndex(String s) {
    if (s.length() <= 1) {
      return -1;
    }

    int index = -1;
    int i = 0;
    int j = s.length() - 1;
    // traverses the array from both sides
    // if characters are equal, move to the next
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      }
      else {
        // if one character was already found, no palindrome is available removing only one character
        if (index != -1) {
          return -1;
        }

        // saves current indices
        int iAux = i;
        int jAux = j;
        // when s[i] != s[j], checks if the next characters of each index is equal to other index character
        // if s[i+1] == s[j] && s[j-1] == s[i], we don't know which element to remove
        // the while traverse the string until it either reaches the middle element or it finds
        // a case in which s[i+1] == s[j] && s[j-1] == s[i] is false
        while (i <= j && s.charAt(j - 1) == s.charAt(i) && s.charAt(i + 1) == s.charAt(j)) {
          j--;
          i++;
        }
        // if the traversing reached the end while j - 1 = i and i + 1 = j, any iAux or jAux is a solution
        if (i > j) {
          return iAux;
        }
        // if they are not equal, find which one has to be removed
        // if j - 1 == i, the element at jAux is removed
        else if (s.charAt(j - 1) == s.charAt(i)) {
          index = jAux;
          i = iAux;
          j = jAux - 1;
        }
        // else, the element at iAux is removed
        else if (s.charAt(i + 1) == s.charAt(j)) {
          index = iAux;
          i = iAux + 1;
          j = jAux;
        }
      }
    }
    return index;
  }

  public static void main(String[] args) {
    String s = "kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk";
    System.out.println(palindromeIndex(s));
  }
}
