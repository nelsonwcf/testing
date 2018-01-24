package custom.structures;

public class CircularQueue<T> {

  private int size;
  private T[] arr;
  private int first;
  private int last;

  static class FullQueueException extends RuntimeException {
    FullQueueException() {
      super();
    }
  }

  static class EmptyQueueException extends RuntimeException {
    EmptyQueueException() {
      super();
    }
  }

  @SuppressWarnings("unchecked")
  public CircularQueue(int size) {
    this.size = 0;
    arr = (T[]) new Object[size];
    first = 0;
    last = arr.length - 1;
  }

  public static <T> CircularQueue<T> newInstance(int size) {
    return new CircularQueue<>(size);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == arr.length;
  }

  public boolean addFirst(T obj) {
    if (isFull()) {
      throw new FullQueueException();
    }
    size++;
    arr[first] = obj;
    first = (first + 1) % arr.length;
    return true;
  }

  public boolean addLast(T obj) {
    if (isFull()) {
      throw new FullQueueException();
    }
    size++;
    arr[last] = obj;
    last = last == 0 ? last = arr.length - 1 : last - 1;
    return true;
  }

  public T getFirst() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    return first == 0 ? arr[arr.length - 1] : arr[first - 1];
  }

  public T getLast() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    return last == arr.length - 1 ? arr[0] : arr[last + 1];
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    size--;
    first = first == 0 ? arr.length - 1 : first - 1;
    return arr[first];
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    size--;
    last = last == arr.length - 1 ? 0 : last + 1;
    return arr[last];
  }

  public void clear() {
    this.size = 0;
    arr = (T[]) new Object[size];
    first = 0;
    last = arr.length - 1;
  }
}