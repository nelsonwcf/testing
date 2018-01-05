package pramp.com;

public class DecryptMessageSolution {

  static String decrypt(String word) {
    if (word == null || word.isEmpty()) {
      return "";
    }

    char[] array = word.toCharArray();
    int previousValue = 1;
    int aux;
    int n;
    for (int i = 0; i < word.length(); i++) {
      n = (int) array[i];
      aux = n;
      n -= previousValue;
      n %= 26;
      n += (int) Math.ceil((97 - n) / 26.) * 26;
      previousValue = aux;
      array[i] = (char) n;
    }

    return String.valueOf(array);
  }

  public static void main(String[] args) {
    String s = decrypt(null);
  }
}
