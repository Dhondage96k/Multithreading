package Multithreading.Syncronization;


// Java provides Inter-Thread Communication mainly through three methods of the Object class:

// wait()

// Causes the current thread to wait until another thread notifies it.

// Releases the lock on the object.

// notify()

// Wakes up one of the threads waiting on the object’s monitor.

// notifyAll()

// Wakes up all threads waiting on the object’s monitor.

class Shared {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until data is consumed
        }
        data = value;
        System.out.println("Produced: " + value);
        hasData = true;
        notify(); // notify consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until data is produced
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // notify producer
    }
}

public class ThreadCommunicationExample {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shared.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shared.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
