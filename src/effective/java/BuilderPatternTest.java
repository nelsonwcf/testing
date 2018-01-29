package effective.java;

public class BuilderPatternTest {
  private final int r0;
  private final int r1;
  private final int o1;
  private final int o2;

  static class Builder {
    // required parameters
    private final int r0;
    private final int r1;

    // optional parameters
    private int o1 = 0;
    private int o2 = 0;

    public Builder(int required1, int required2) {
      r0 = required1;
      r1 = required2;
    }

    public Builder seto1(int value) {
      o1 = value;
      return this;
    }

    public Builder seto2(int value) {
      o2 = value;
      return this;
    }

    public BuilderPatternTest build() {
      return new BuilderPatternTest(this);
    }
  }

  private BuilderPatternTest(Builder builder) {
    r0 = builder.r0;
    r1 = builder.r1;
    o1 = builder.o1;
    o2 = builder.o2;
  }

  public static void main(String[] args) {
    BuilderPatternTest O1 = new BuilderPatternTest.Builder(10,20).seto1(5).build();
  }
}
