package scraps;

public class NegativeIndexing {
  public static void main(String[] args) {
    int size = 5;
    int index = -2;
    System.out.println((size + (index % size)) % size);
  }
}
