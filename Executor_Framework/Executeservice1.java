package Multithreading.Executor_Framework;
// It provides a higher-level replacement for managing threads compared to creating threads manually.

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Instead of manually creating Thread objects, you can submit tasks (Runnable or Callable) to an ExecutorService, and it takes care of:

// Creating and managing the thread pool

// Scheduling execution

// Handling task completion

// How tasks are submitted:
// execute(Runnable task) → runs a task, no result returned

// submit(Runnable/Callable task) → returns a Future (you can check result or cancel task)

// Shutting down the service:

// shutdown() → stops accepting new tasks, finishes running tasks

// shutdownNow() → attempts to stop immediately

// 🔑 Methods involved:

// shutdown()

// Initiates a graceful shutdown.

// No new tasks will be accepted.

// Already submitted tasks (both running and waiting in the queue) will still be executed.

// awaitTermination(timeout, unit)

// Blocks the calling thread (like main) until either:

// All tasks are completed, OR

// The given timeout expires.

// shutdownNow()

// Not graceful (forceful shutdown).

// Attempts to stop all running tasks immediately.

// Returns a list of tasks that were submitted but never started.

public class Executeservice1 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            int taskid = i;
            service.submit(() -> {
                // body of runnable
                System.out.println("Task " + taskid + " executed by " + Thread.currentThread().getName());
                try {
                    service.wait(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            });
        }

        service.shutdown(); // graceful shoutdown - mean no new task will be acceptd and aldready working
                            // taskwill executed only

        try {
            if (!service.awaitTermination(10, TimeUnit.MILLISECONDS)) {
                // it wait for 10 milisecond and then forcefully terminats the tasks

                System.out.println("forcefully shutdown");
                service.shutdownNow(); // forcefully shutdown after one seconds

            }
        } catch (InterruptedException e) {

        }
    }

}


class futureDemo {
    // how the future is used 

    void Methods() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(2);
      Future<Integer> future=  service.submit(() ->{
            for(int i=0 ;i<0; i++) {

            }
              return 42;
        });
        
 future.get(); // wait until the result completed
 future.get(10, TimeUnit.MILLISECONDS); //Waits only for the given time.
 future.isDone();
 future.isCancelled();
 future.cancel(false);




    }
}
