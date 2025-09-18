package Multithreading.basic;

// 1. Definition
// A daemon thread is a background thread that provides services to user (non-daemon) threads.
// JVM does not wait for daemon threads to finish before shutting down.
// If all user threads finish, the JVM exits, killing all daemon threads automatically.


// 2. Key Characteristics
// Runs in the background (e.g., garbage collector, JVM housekeeping).
// Ends automatically when no user threads remain.
// Must be set as daemon before calling start().


public class Deman_Thread {
    public static void main(String[] args) {
        Thread deman  = new Thread(() ->{

            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
 System.out.println(e);
            }
            
            System.out.println("Deman thread");
        });
        deman.setDaemon(true);
        deman.start();
        
    }
    
}
