package Multithreading.basic;

import Multithreading.basic.Lifecycle.Main;

public class Methods extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        Thread.yield(); // yield() → Suggests to the scheduler that current thread is willing to pause
                        // and let others execute.
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws InterruptedException {
        Main tMain = new Main();
        tMain.start(); // Starts a new thread; invokes run() in a new call stack.
        tMain.setName("Rohit thread ");

        tMain.setPriority(6);
        Thread.currentThread().getState(); // getState() → Returns the state (NEW, RUNNABLE, etc.).
        tMain.sleep(MAX_PRIORITY); // sleep(long millis) → Pauses the thread for a given time.

        Thread tt = new Thread() {
            @Override
            public void run() {
                System.out.println("thread using anonymus class");

            }
        };
        tt.start();




        

    }
}

// ✅ Relevant Methods for Working with Threads in Java
// 1. Thread Creation and Control

// start() → Starts a new thread; invokes run() in a new call stack.

// run() → Entry point of a thread; contains the task logic.

// currentThread() → Returns reference of the currently executing thread.

// isAlive() → Checks if a thread is still running.

// 2. Thread State & Information

// getName() / setName(String) → Get or change the thread’s name.

// getId() → Returns unique ID of the thread.

// getPriority() / setPriority(int) → Get or change thread priority (1–10).

// getState() → Returns the state (NEW, RUNNABLE, etc.).

// isDaemon() / setDaemon(boolean) → Marks thread as daemon (background thread).

// 3. Thread Sleeping, Waiting & Yielding

// sleep(long millis) → Pauses the thread for a given time.

// yield() → Suggests to the scheduler that current thread is willing to pause
// and let others execute.

// join() / join(long millis) → Makes one thread wait until another finishes.

// 4. Thread Interruption & Termination

// interrupt() → Sends an interruption signal to the thread.

// isInterrupted() → Checks if the thread is interrupted.

// interrupted() (static) → Checks and clears the current thread’s interruption
// status.

// 5. Synchronization-Related

// (These are in Object class, but heavily used in multithreading)

// wait() → Causes current thread to wait until notified.

// wait(long millis) → Waits with timeout.

// notify() → Wakes up a single waiting thread.

// notifyAll() → Wakes up all waiting threads.

// 6. Thread Lifecycle Helpers (Java 21+ Virtual Threads)

// Thread.ofVirtual() → Creates a virtual thread builder.

// startVirtualThread(Runnable) → Starts a virtual thread directly.

// ✅ Most frequently used in real-world apps:
// start(), run(), sleep(), join(), interrupt(), currentThread(),
// wait()/notify(), and in modern apps → Executors & CompletableFuture replace
// manual use.