package scraps;

public class DeletionDistanceNewSolution {
  static int deletionDistance(String str1, String str2) {
    if (str1 == null || str1.isEmpty()) {
      return str2.length();
    }
    if (str2 == null || str2.isEmpty()) {
      return str1.length();
    }

    StringBuilder sb1 = new StringBuilder(str1);
    StringBuilder sb2 = new StringBuilder(str2);

    return recDelDist(sb1, sb2);
  }

  private static int recDelDist(StringBuilder sb1, StringBuilder sb2) {
    if (sb1.length() == 0) {
      return sb2.length();
    }
    if (sb2.length() == 0) {
      return sb1.length();
    }

    int i1 = sb1.length() - 1;
    int i2 = sb2.length() - 1;

    if (sb1.charAt(i1) == sb2.charAt(i2)) {
      char aux1 = sb1.charAt(i1);
      char aux2 = sb2.charAt(i2);
      sb1.deleteCharAt(i1);
      sb2.deleteCharAt(i2);
      int result = recDelDist(sb1, sb2);
      sb1.append(aux1);
      sb2.append(aux2);
      return result;
    } else {
      char aux1 = sb1.charAt(i1);
      sb1.deleteCharAt(i1);
      int result1 = recDelDist(sb1, sb2);
      sb1.append(aux1);
      char aux2 = sb2.charAt(i2);
      sb2.deleteCharAt(i2);
      int result2 = recDelDist(sb1, sb2);
      sb2.append(aux2);
      return 1 + Math.min(result1, result2);
    }
  }
}