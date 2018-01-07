package scraps;

import custom.structures.Tuple;

import java.util.PriorityQueue;

public class PriorityQueueTest2 {
  public static void main(String[] args) {
    Tuple<String, Integer> t1 = new Tuple<>("Mae", 30);
    Tuple<String, Integer> t2 = new Tuple<>("Vo", 40);
    Tuple<String, Integer> t3 = new Tuple<>("Pai", 50);
    Tuple<String, Integer> t4 = new Tuple<>("Filho", 10);

    PriorityQueue<Tuple<String,Integer>> pq = new PriorityQueue<Tuple<>>(16,Integer::compareTo);
    pq.add(t1);
    pq.add(t2);
    System.out.println(pq.poll());

  }
}