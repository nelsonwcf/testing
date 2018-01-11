package crackthecode;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Ex153Solution {
  public static void main(String[] args) {
    Chopstick c1 = new Chopstick("c1", new Semaphore(1));
    Chopstick c2 = new Chopstick("c2", new Semaphore(1));
    Chopstick c3 = new Chopstick("c3", new Semaphore(1));
    Philosopher p1 = new Philosopher("p1", c1, c2);
    Philosopher p2 = new Philosopher("p2", c2, c3);
    Philosopher p3 = new Philosopher("p3", c3, c1);
  }
}

class Chopstick {
  Semaphore sem;
  String name;

  Chopstick(String name, Semaphore sem) {
    this.sem = sem;
    this.name = name;
  }

  synchronized boolean get() {
    return sem.tryAcquire();
  }

  synchronized boolean drop() {
    sem.release();
    return false;
  }
}

class Philosopher implements Runnable {
  String name;
  Chopstick left;
  Chopstick right;
  boolean hasLeftChopstick;
  boolean hasRightChopstick;
  Thread t;

  Philosopher(String name, Chopstick left, Chopstick right) {
    this.name = name;
    this.left = left;
    this.right = right;
    hasLeftChopstick = false;
    hasRightChopstick = false;
    t = new Thread(this, "name");
    t.start();
  }

  @Override
  public void run() {
    while (true) {
      try {
//        System.out.println(name + " is acquiring left chopstick, " + left.name);
        hasLeftChopstick = left.get();
//        System.out.println(name + " acquired left chopstick " + left.name);

//        System.out.println(name + " is acquiring right chopstick, " + right.name);
        if (!right.get()) {
          left.drop();
          sleep(500);
          System.out.println("Dropping left");
          continue;
        }
        hasRightChopstick = true;
//        System.out.println(name + " acquired right chopstick " + right.name);

        System.out.println(name + " is eating...");
        sleep(1000);
//        System.out.println(name + " is dropping left chopstick, " + left.name);
        hasLeftChopstick = left.drop();
//        System.out.println(name + " dropped left chopstick " + left.name);
//        System.out.println(name + " is dropping right chopstick, " + right.name);
        hasRightChopstick = right.drop();
//        System.out.println(name + " dropped right chopstick " + right.name);
//        System.out.println(name + " is resting...");
          sleep(10);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }
}

