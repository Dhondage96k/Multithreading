package Multithreading.Syncronization.LOck;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class innerr {
    Lock lock = new ReentrantLock();

   public void outerlock () {
        lock.lock(); // lock by thread in outer method
        try {
            System.out.println("Outer Lock");
            innerlock();
            
        } catch (Exception e) {
           Thread.currentThread().interrupt();
        }finally{
            lock.unlock();
        }
    }


    void innerlock() {
        lock.lock(); // inner lock try to lock same lock as itsaldready lock by outerlock  = deadlock 
         // but the java has handled it automatically by allowing the same thread to acquire the lock multiple times

         try {
            System.out.println("InnerLock");
         } catch (Exception e) {
            Thread.currentThread().interrupt();
         }finally{
            lock.unlock();
         }


    }

}
public class Deadlock {
    public static void main(String[] args) {
        innerr inn = new innerr();
        Thread t1 = new Thread( new Runnable() {
            @Override
            public void run() {
                inn.outerlock();
            }
        } ,"thread 1");

        t1.start();
        System.out.println("hello");


        // simplifies code approach 
        Thread t2 = new Thread(() ->inn.outerlock());
        t2.start();
        
    }
    
 }


// With ReentrantLock, you can choose fairness policy:

// ReentrantLock fairLock = new ReentrantLock(true);  // fair
// ReentrantLock unfairLock = new ReentrantLock(false); // unfair (default)


// Fair lock → gives access to the longest-waiting thread (first-come, first-served).

// Unfair lock (default) → may allow threads to “barge in” and get the lock immediately, even if others are waiting. This is usually faster.

