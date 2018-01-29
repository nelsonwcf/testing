package effective.java;

public class NestedClassesAsTypedef {
  Tuple t;

  class Tuple {
    int x;
    int y;

    Tuple(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  NestedClassesAsTypedef() {
    t = new Tuple(10,10);
  }

  Tuple getT() {
    return t;
  }

  static int showMax() {
    Tuple x = new NestedClassesAsTypedef().getT();
    return x.x;
  }

  public static void main(String[] args) {
    int i = showMax();
  }
}
