package effective.java;

// Example of wrong implementation of .equals();
public final class CaseInsensitiveString {
  private final String s;

  public CaseInsensitiveString(String s) {
    if (s == null) {
      throw new NullPointerException();
    }
    this.s = s;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString) {
      return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
    }
    if (o instanceof String) {
      return s.equalsIgnoreCase((String) o);
    }
    return false;
  }

  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";
    System.out.println(s.equals(cis));
    System.out.println(cis.equals(s));
  }
}
