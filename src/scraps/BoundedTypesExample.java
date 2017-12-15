package scraps;

public class BoundedTypesExample {
  public static void main(String[] args) {
    Integer i = new Integer(88);
    Object o = new Object();

    o = i;
    Integer ii = (Integer) o;

    System.out.println(i.getClass());
    System.out.println(o.getClass());

  }

}
