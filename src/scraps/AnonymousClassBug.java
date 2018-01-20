package scraps;

public class AnonymousClassBug {
  public static void main(String[] args) {
    Runnable r = new Runnable() {
      @Override


      public void run() {
        System.out.println("This");
      }
    };
    new Thread(r).start();
  }
}
