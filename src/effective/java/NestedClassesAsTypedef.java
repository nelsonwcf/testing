package effective.java;

public class NestedClassesAsTypedef {
  class Tuple {
    private final int x;
    private final int y;

    Tuple(int x, int y) {
      this.x = x;
      this.y = y;
    }

    int getX() {
      return x;
    }

    int getY() {
      return y;
    }
  }

  public void main(String[] args) {
    Tuple t = new NestedClassesAsTypedef.Tuple(10,20);
  }
}
