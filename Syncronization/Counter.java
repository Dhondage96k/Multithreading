package Multithreading.Syncronization;

  class Counter {
    private int count = 0;


    public synchronized  void increment() { // synchronized method
        count ++;

    }

    public void increment2() {
        
        synchronized (this) {  // synchronized block
            count++;
        }
    }

    public int getcount() {
        return count;
    }
}
