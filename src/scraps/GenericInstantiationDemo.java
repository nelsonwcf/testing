package scraps;

public class GenericInstantiationDemo {
  public static void main(String[] args) {
    Gen<Integer> gen = new Gen<Integer>(Integer.c);
    Integer x = gen.getTypeInstance();
  }
}

class Gen<T extends Comparable<T>> {
  private Class<T> clazz;

  Gen(Class<T> obj) {
    this.clazz = obj;
  }

  public T getTypeInstance() {
    try {
      return clazz.newInstance("Test");
    }
    catch(Exception e) {
      System.out.println(e);
    }
    return null;
  }
}