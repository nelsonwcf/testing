package pramp;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SquareRootSolution {
  static double root(double x, int n) {
    DecimalFormat df = new DecimalFormat("#.###");

    double lowerBound = 0;
    double upperBound = Math.max(1, x);
    double approxRoot = (upperBound + lowerBound) / 2;
    double aux;

    if (x == 0) {
      return 0;
    }

    df.setRoundingMode(RoundingMode.HALF_UP);

    while (approxRoot - lowerBound >= 0.001) {
      aux = Math.pow(approxRoot, n);
      if (aux > x) {
        upperBound = approxRoot;
      } else if (aux < x) {
        lowerBound = approxRoot;
      } else {
        break;
      }

      approxRoot = (upperBound + lowerBound) / 2;
    }

    return Double.parseDouble(df.format(approxRoot));
  }

  public static void main(String[] args) {
    System.out.println(root(10, 3));
  }
}
