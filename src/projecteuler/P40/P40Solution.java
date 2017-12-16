package projecteuler.P40;

public class P40Solution {
  public static int returnChampernowneDigit(int n) {
    StringBuilder sb = new StringBuilder();
    int current = 1;

    while (n > sb.length()) {
      sb.append(current);
      current++;
    }
    return Character.getNumericValue(sb.charAt(n - 1));
  }

  public static void main(String[] args) {
    System.out.println(returnChampernowneDigit(1) *
        returnChampernowneDigit(10)*
        returnChampernowneDigit(100)*
        returnChampernowneDigit(1000)*
        returnChampernowneDigit(10000)*
        returnChampernowneDigit(100000)*
        returnChampernowneDigit(1000000)
    );
  }
}
