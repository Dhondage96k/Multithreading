package Multithreading.basic.Lifecycle;

public class Main extends Thread{
 
    @Override
        public void run(){
            try {
                
                Thread.sleep(2000); // sleep / waiting 
                System.out.println(currentThread().getState());
                System.out.println("abc");

            } catch (InterruptedException e) {

                System.out.println(e);

            }

            
            
        }

        public static void main(String[] args) throws InterruptedException {
            System.out.println("Thread liecycle");
            Main ss = new Main(); // new 
            System.out.println(ss.getState());

            ss.start(); // running / runnable
            System.out.println(ss.getState());

            Thread.sleep(1000);
            System.out.println(ss.getState()); // ss thread waiting


            ss.join(); // similar as async  / wait whe main method until ss completed 

           

            System.out.println(ss.getState()); // tesminated 





        }

        
        
        
    
}
