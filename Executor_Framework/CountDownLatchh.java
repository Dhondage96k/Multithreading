package Multithreading.Executor_Framework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchh {
    public static void main(String[] args) throws InterruptedException {
        int services = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(services);
        CountDownLatch count = new CountDownLatch(services);

        executorService.submit(new demo(count));
        executorService.submit(new demo(count));
        
        executorService.submit(new demo(count));
        count.await();

        System.out.println("Main thread started");





        
    }
}


  class  demo implements Runnable{

    CountDownLatch count;
    public demo(CountDownLatch latch){
      this.count = latch;

    }
    @Override
    public void run() {

      System.out.println(Thread.currentThread().getName() + "\t" +"Service started");
      try {
        Thread.sleep(1000);
        
        
      } catch (Exception e) {
         
      }finally {
        count.countDown();
      }
       
          }



    
}