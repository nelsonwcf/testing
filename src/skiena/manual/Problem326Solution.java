package skiena.manual;

import java.util.Arrays;

public class Problem326Solution {
  static void reverseWords(char[] array) {
    if (array == null || array.length <= 1) {
      return;
    }

    // Reversing the entire array
    int lastPosition = array.length - 1;
    for (int i = 0; i < array.length / 2; i++) {
      char aux = array[i];
      array[i] = array[lastPosition - i];
      array[lastPosition - i] = aux;
    }

    // Reversing each word
    int firstIndex = 0;
    int lastIndex = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] != ' ') {
        lastIndex = i;
      } else {
        while (firstIndex <= lastIndex) {
          char aux = array[firstIndex];
          array[firstIndex] = array[lastIndex];
          array[lastIndex] = aux;
          firstIndex++;
          lastIndex--;
        }
        firstIndex = i + 1;
        lastIndex = i;
      }
    }

    while (firstIndex <= lastIndex) {
      char aux = array[firstIndex];
      array[firstIndex] = array[lastIndex];
      array[lastIndex] = aux;
      firstIndex++;
      lastIndex--;
    }
  }

  public static void main(String[] args) {
    char[] array = "This is my arm, this is my gun.".toCharArray();
    reverseWords(array);
    for (char c : array) {
      System.out.print(c);
    }
    System.out.println();
  }
}