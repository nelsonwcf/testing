package pramp.com;

public class SmallestSubstringSolution {
  static String getShortestUniqueSubstring(char[] arr, String str) {
    if (arr == null || arr.length == 0) {
      return str.substring(0,1);
    }

    if (str == null || str.length() == 0 || str.length() < arr.length) {
      return null;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[^");
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
    }
    sb.append(']');
    return "";
  }

  public static void main(String[] args) {
    char[] array = {'x','y','z'};
    String str = "xyyzyzyx";

    System.out.println(getShortestUniqueSubstring(array, str));

  }
}
