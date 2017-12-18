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
        lastIndex++;
      } else {
        for (int j = firstIndex; j <= lastIndex / 2; j++) {
          char aux = array[j];
          array[j] = array[lastIndex - j + firstIndex];
          array[lastIndex - j + firstIndex] = aux;
        }
        firstIndex = i + 1;
        lastIndex = i;
      }
    }

    if (firstIndex < array.length && lastIndex < array.length) {
      for (int j = firstIndex; j <= lastIndex / 2; j++) {
        char aux = array[j];
        array[j] = array[lastIndex - j + firstIndex];
        array[lastIndex - j + firstIndex] = aux;
      }
    }
  }

  public static void main(String[] args) {
    char[] array = "This is my arm, this is my gun.".toCharArray();
    reverseWords(array);
    System.out.println(Arrays.toString(array));
  }
}