package Multithreading.Executor_Framework;

// ScheduledExecutorService is an interface in Java (java.util.concurrent package) that extends ExecutorService.
// It is mainly used to schedule tasks to run after a delay or periodically.

// 📌 Important Methods of ScheduledExecutorService

// ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit)

// Schedules a task to run once after the given delay.

// Example: run something after 5 seconds.

// <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit)

// Same as above, but with a Callable that returns a result.

// ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)

// Runs a task repeatedly at a fixed rate.

// The next execution starts exactly after period time, regardless of how long the task takes.

// Example: run every 10 seconds (good for time-based scheduling like a clock).

// ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)

// Runs a task repeatedly with a fixed delay between the end of one execution and the start of the next.

// Example: run a cleanup task 5 seconds after the previous one finishes.

// 🖥️ Example Code:

import java.util.concurrent.*;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 1. Run once after 3 seconds
        scheduler.schedule(() -> {
            System.out.println("Task 1 executed after 3 seconds");
        }, 3, TimeUnit.SECONDS);

        // 2. Run every 5 seconds, starting after 2 seconds
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task 2 executed at fixed rate: " + System.currentTimeMillis());
        }, 2, 5, TimeUnit.SECONDS);

        // 3. Run repeatedly with 4 seconds delay between tasks
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Task 3 executed with fixed delay: " + System.currentTimeMillis());
        }, 1, 4, TimeUnit.SECONDS);
   
   
   scheduler.schedule(() ->{
    // runnable 
    System.out.println("shutdown the tasks");

    scheduler.shutdown();

   },20,TimeUnit.MILLISECONDS);
    }
}