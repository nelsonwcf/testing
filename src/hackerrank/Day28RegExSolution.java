package hackerrank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28RegExSolution {
  public static void main(String[] args) {
    ArrayList<String> al = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Pattern p1 = Pattern.compile("@gmail.com");
    Pattern p2 = Pattern.compile("^[a-z]+");
    Matcher m;

    scanner.nextLine();
    for (int i = 0; i < n; i++) {
      String input = scanner.nextLine();
      m = p1.matcher(input);
      if (m.find()) {
        m = p2.matcher(input);
        if (m.find()) {
          al.add(m.group());
        }
      }
    }

    Collections.sort(al);

    for (String s : al) {
      System.out.println(s);
    }
  }
}
