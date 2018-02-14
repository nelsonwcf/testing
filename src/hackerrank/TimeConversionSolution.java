package hackerrank;

import java.util.Scanner;

public class TimeConversionSolution {
  static String timeConversion(String s) {
    String hour = s.substring(0, 2);
    String min = s.substring(3, 5);
    String sec = s.substring(6, 8);
    String period = s.substring(8, 10);

    int hourN = Integer.parseInt(hour);
    if (hourN == 12 && period.equals("AM")) {
      hourN = 0;
    }
    else if (hourN == 12 && period.equals("PM")) {
      hourN = 12;
    }
    else if (period.equals("PM")) {
      hourN = hourN + 12;
    }

    // interesting way to convert from number to String
    return String.format("%02d", hourN) + ":" + min + ":" + sec;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = timeConversion(s);
    System.out.println(result);
  }
}
