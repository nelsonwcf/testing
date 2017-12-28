package pramp.com;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SquareRootSolution {
  static double root(double x, int n) {
    double y = Math.pow(x, 1. / n);

    return findRoot(0, x, n, y);
  }

  private static double findRoot(double left, double right, int n, double real) {
    double mid = (left + right) / 2;
    double mid_aux = pow(mid, n);

    if (Math.abs(mid - real) <= 0.001) {
      DecimalFormat df = new DecimalFormat("#.###");
      df.setMaximumFractionDigits(3);
      df.setRoundingMode(RoundingMode.UP);
      return Double.parseDouble(df.format(mid));
    }

    if (mid > real) {
      return findRoot(left, mid, n, real);
    } else {
      return findRoot(mid, right, n, real);
    }
  }

  public static double pow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return x;
    }

    double aux = x;
    for (int i = 2; i <= n; i++) {
      aux *= x;
    }

    return aux;

  }

  public static void main(String[] args) {
    System.out.println(root(3.,2));
  }
}
