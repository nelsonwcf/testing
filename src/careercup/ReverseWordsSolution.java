package careercup;

class ReverseWordsSolution {
  private static String reverseWords(String str) {
    if (str == null) {
      return null;
    }
    String[] reversedString = str.split(" ");
    StringBuilder sb = new StringBuilder();

    for (int i = reversedString.length - 1; i >= 0; i--) {
      sb.append(reversedString[i]).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "The Sky is Blue";
    System.out.println(reverseWords(s));
  }
}
