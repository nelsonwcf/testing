package custom.structures;

// Next step is to implement equals and hashcode;
public class Tuple<T, K extends Comparable<K>> implements Comparable<Tuple<?,K>> {
  private final T key;
  private final K value;

  public Tuple(T key, K value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public int compareTo(Tuple<?, K> o) {
    return value.compareTo(o.getValue());
  }

  @Override
  public String toString() {
    return key.toString();
  }

  public T getKey() {
    return key;
  }

  public K getValue() {
    return value;
  }
}
