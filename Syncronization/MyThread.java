package Multithreading.Syncronization;

  class MyThread extends Thread {
    private Counter c = new Counter();

    public MyThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            // increment the count
            // share by threads
            c.increment();
        }
    }

}
