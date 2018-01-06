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
    }
    else {
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

  public static void main(String args[]) {
    String str1 = "dragon";
    String str2 = "vorazd";
    System.out.println(deletionDistance(str1, str2));
  }
}


/*
    static int deletionDistance(String str1, String str2) {
        if (str1 == null || str2 == null)
            throw new RuntimeException();
        else
            return deletionDistanceAux(str1, str2);
    }

    static int deletionDistanceAux(String str1, String str2) {
        if (hs.containsKey(str1 + "_" + str2))
                return hs.get(str1 + "_" + str2);
        int result;

        if (str1.length() == 0)
            return str2.length();
        else if (str2.length() == 0)
            return str1.length();
        else if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1))
            result = deletionDistanceAux(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        else
            result = (1 + Math.min(
                    deletionDistanceAux(str1.substring(0, str1.length() - 1), str2),
                    deletionDistanceAux(str1, str2.substring(0, str2.length() - 1))
            ));
        hs.put(str1 + "_" + str2, result);
        return result;
	}
 */