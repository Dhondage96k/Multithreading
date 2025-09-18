package Multithreading.Syncronization.LOck;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// there are two type of syncronizes lock 
// implicit lock  = directly hadled by JVM  / when we use the synchronized keyword 
// explicit lock  = =mnually handled 

// 1. Implicit Lock

// Managed by synchronized keyword.

// Every Java object has an intrinsic (monitor) lock.

// You don’t need to manually acquire or release the lock → JVM handles it.

// If a thread enters a synchronized block/method, it acquires the object’s lock; once it exits, the lock is released automatically.

// ✅ Example:

// class Counter {
//     private int count = 0;

//     public synchronized void increment() {  // implicit lock on "this"
//         count++;
//     }

//     public synchronized int getCount() {   // implicit lock on "this"
//         return count;
//     }
// }

// Here, the lock is implicit, tied to the object (this), and automatically released.

// 2. Explicit Lock

// Provided by java.util.concurrent.locks.Lock (e.g., ReentrantLock).

// Programmer must manually acquire (lock()) and release (unlock()).

// Offers more control (tryLock, interruptible locking, fairness policy).

// More powerful but also more error-prone if you forget unlock().

// ✅ Example:

// import java.util.concurrent.locks.*;

// class Counter {
//     private int count = 0;
//     private final Lock lock = new ReentrantLock();

//     public void increment() {
//         lock.lock();       // explicit lock
//         try {
//             count++;
//         } finally {
//             lock.unlock(); // must explicitly release
//         }
//     }

//     public int getCount() {
//         return count;
//     }
// }

public class Bank {
    private int balance = 10000;

    // public synchronized void withdraw(int amt) {
    // the problem in synchronized implicit lock is only one thread can use the
    // resources
    // if any on of them may wait for time or infinitly run other will still waiting
    // we use explicit lock

    // using explicit lock

    private final Lock lock = new ReentrantLock(); // for explicit loking

    public void withdraw(int amt) {
        System.out.println(Thread.currentThread().getName() + "Attempting to withdwrawn");

        try {
            // here the thread is waiting for only 1000 milisecond if another thread is
            // processing
            // trather than until the completion of another.
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (amt <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "Proceeding amt withdrawed =" + amt);

                        balance -= amt;
                        System.out.println(Thread.currentThread().getName() + "Completed to withdrawed =" + amt);

                        Thread.sleep(10000);

                    } catch (Exception e) {
                        // best practices to known to othr thread that the current thread is exception
                        // thread.isInterrupted(); // returns true if flag is set
                        // Thread.interrupted(); // same, but also clears the flag!
                        // Interrupt flag lost = the isInterrupted status is reset to false after
                        // catching InterruptedException.

                        // It only affects the interruption signal, not other thread flags (daemon,
                        // alive, state).

                        // If you don’t restore it, the thread may continue running even though someone
                        // asked it to stop.
                        Thread.currentThread().interrupt();

                    } finally {
                        lock.unlock();
                    }

                }
            } else {
                System.out.println(Thread.currentThread().getName() + "does not take time try later");

            }

        } catch (Exception e) {

        }

    }

}
