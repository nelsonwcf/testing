package pramp.com;

import java.util.Arrays;

public class SentenceReverseSolution {
  static char[] reverseWords(char[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // reverse the entire array
    mirror(arr, 0, arr.length - 1);

    // assuming the first character could be a space
    // position both iterators at the first non-space character
    int i = 0;
    int j = 0;
    while (arr[i] == ' ') {
      i++;
    }
    while (arr[j] == ' ') {
      j++;
    }

    //
    while (j < arr.length) {
      while (arr[j] != ' ' && j < arr.length - 1) {
        j++;
      }
      mirror(arr, i, j - 1);
      while (arr[j] == ' ') {
        j++;
      }
      i = j;
    }

    if (arr[j] != ' ') {
      mirror(arr, i, j);
    }

    return arr;
  }

  private static void mirror(char[] arr, int startIndex, int endIndex) {
    while (startIndex < endIndex) {
      char c = arr[startIndex];
      arr[startIndex] = arr[endIndex];
      arr[endIndex] = c;
      startIndex++;
      endIndex--;
    }
  }


  public static void main(String[] args) {
    char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
    Arrays.toString(reverseWords(arr));
  }
}
