package Multithreading.Executor_Framework;

import java.util.concurrent.Executor;

public class Executor_interface {

    public static void main(String[] args) {
                                 

Executor executor0 = runnable ->new Thread(runnable).start(); // each time create the new thread to execute runnable

executor0.execute(() ->{
    // the execute method accept the Runnable 
    // the body of Runnable you want to pass 
});




    
        Executor executor = new Executor() {

            @Override
            public void execute(Runnable command) {
                Thread t1 = new Thread(command);
                System.out.println("the thread created");
                t1.start();
            }

        };

        executor.execute(null);

        // way 2
        Executor executor2 = new Executor() {
            @Override
            public void execute(Runnable command) {
                new Thread(command).start();
            }
        };

        // way 3 // using anonymus class
        Executor executor3 = command -> new Thread(command).start(); // command  = iit is the argument of execute method 

        executor3.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        });
 
        // using lambda
        executor3.execute(( )->{            
            for (int i = 0; i < 5; i++) {
            System.out.println(i);    

    }});
             
    }
    }


