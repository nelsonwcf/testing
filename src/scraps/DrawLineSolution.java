package scraps;

public class DrawLineSolution {
  static void drawHTree(int x, int y, int length, int depth) {
    if (depth == 0) {
      return;
    }
    int halfLength = length / 2;

    drawLine(x - halfLength, x + halfLength, y, y);
    drawLine(x + halfLength, x + halfLength, y - halfLength, y + halfLength);
    drawLine(x - halfLength, x - halfLength, y - halfLength, y + halfLength);
    drawHTree(x - halfLength, y + halfLength, (int) (length / Math.sqrt(2)), depth - 1);
    drawHTree(x - halfLength, y - halfLength, (int) (length / Math.sqrt(2)), depth - 1);
    drawHTree(x + halfLength, y - halfLength, (int) (length / Math.sqrt(2)), depth - 1);
    drawHTree(x + halfLength, y + halfLength, (int) (length / Math.sqrt(2)), depth - 1);
  }

  private static void drawLine(int x_start, int x_end, int y_start, int y_end) {
    System.out.println(x_start + " " + x_end + " " + y_start + " " + y_end);
  }

  public static void main(String[] args) {
    drawHTree(5,5,10,3);
  }
}
