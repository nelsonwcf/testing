package custom.structures;

public class Tuple<T, K extends Comparable<K>> {
  private final T key;
  private final K value;

  public Tuple(T key, K value) {
    this.key = key;
    this.value = value;
  }

  public int compareTo(Tuple<T,K> o) {
    return value.compareTo(o.getValue());
  }

  public T getKey() {
    return key;
  }

  public K getValue() {
    return value;
  }
}
