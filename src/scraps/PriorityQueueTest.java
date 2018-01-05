package scraps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {

  public static void main(String[] args) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(10, (a,b) -> -1 * a.compareTo(b));
    heap.addAll(Arrays.asList(4,6,8,3,6,2,0,9,1));
    System.out.println(heap.poll());
  }
}
