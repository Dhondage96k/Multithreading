package Multithreading.Syncronization.LOck;

public class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                b1.withdraw(100);

                   }
            
        };
        Thread t1 = new Thread(runnable,"Thread 1") ;
        // using lambda
      //   Thread t3 = new Thread(()->b1.withdraw(100),"Thread 1") ; // no need to create the runnable

 
        Thread t2 = new Thread(runnable, "thread2");

        

        t1.start();
        t2.start();
        
    }
}
