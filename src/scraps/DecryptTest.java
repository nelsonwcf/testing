package scraps;

// Exercise I've got by interviewing someone
// Code fixed after interview
public class DecryptTest {
  static String decrypt(String word) {
    StringBuilder res = new StringBuilder();
    int prev = 0;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (i == 0) {
        int temp = (int) c;  // Gets the value of the first letter
        prev = temp;
        int value = getInrangeNumber(temp - 1);
        res.append((char) (value));
      } else {
        int aux = prev; // He was missing this step
        int temp = (int) c;
        prev = temp;
        temp -= aux;
        int value = getInrangeNumber(temp);
        res.append((char) value);
      }
    }
    return res.toString();
  }

  static int getInrangeNumber(int n) {
    while (n < (int) 'a') {
      n += 26;
    }
    while (n > (int) 'z') {
      n -= 26;
    }
    return n;
  }

  public static void main(String[] args) {
    String out = decrypt("dnotq");
    System.out.println(out);
  }
}
