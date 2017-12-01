package crackthecode;

class Philosopher implements Runnable {
    String name;
    Chopstick leftChopstick;
    Chopstick rightChopstick;
    boolean holdingLeftChopstick;
    boolean holdingRightChopstick;
    Thread t;

    Philosopher(String n, Chopstick left, Chopstick right) {
        name = n;
        holdingLeftChopstick = false;
        holdingRightChopstick = false;
        leftChopstick = left;
        rightChopstick = right;
        t = new Thread(this, name);
        t.start();
    }

    void getLeftChopstick() {
        if (!holdingLeftChopstick) {
            leftChopstick.acquire();
            holdingLeftChopstick = true;
        }
    }

    void releaseLeftChopstick() {
        if (holdingLeftChopstick) {
            leftChopstick.release();
            holdingLeftChopstick = false;
        }
    }

    void getRightChopstick() {
        if (!holdingRightChopstick) {
            rightChopstick.acquire();
            holdingRightChopstick = true;
        }
    }

    void releaseRightChopstick() {
        if (holdingRightChopstick) {
            rightChopstick.release();
            holdingRightChopstick = false;
        }
    }

    synchronized void eat() {
        System.out.println(name + " tries to acquire left chopstick...");
        getLeftChopstick();
        System.out.println(name + " acquired left chopstick.");
        System.out.println(name + " tries to acquire right chopstick...");
        if (rightChopstick.isHeld) {
            System.out.println(name + " concedes left");
            releaseLeftChopstick();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getLeftChopstick();
            getRightChopstick();
        }
        System.out.println(name + " acquired right chopstick.");
        System.out.println(name + " is eating...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished eating.");
        System.out.println(name + " is releasing chopstick...");
        releaseLeftChopstick();
        System.out.println(name + " released left chopstick.");
        System.out.println(name + " is releasing right chopstick...");
        releaseRightChopstick();
        System.out.println(name + " released right chopstick.");
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            eat();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Chopstick {
    boolean isHeld = false;

    synchronized Chopstick acquire() {
        if (isHeld)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        isHeld = true;
        return this;
    }

    synchronized void release() {
        isHeld = false;
        notify();
    }
}

public class Ex153Solution {
    static Chopstick c2 = new Chopstick();
    static Chopstick c4 = new Chopstick();
    static Chopstick c6 = new Chopstick();
    static Chopstick c8 = new Chopstick();


    public static void main(String[] args) {
        Philosopher p1 = new Philosopher("Nelson", c8, c2);
        Philosopher p3 = new Philosopher("Tsvete", c2, c4);
        Philosopher p5 = new Philosopher("Stephen", c4, c6);
        Philosopher p7 = new Philosopher("Marianne", c6, c8);


    }
}