package Multithreading.Executor_Framework;

   

 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InnerFixedThread_executor  implements Runnable{
    private final int workid;
   
   public InnerFixedThread_executor(int wirkid) {
    this.workid = wirkid;

    }

    @Override
    public void run() {
        
        System.out.println("Task ID" +workid + "Executed by Thread " +Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           }

    

    
}
public class FixedThread_executor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);           
          
        try{
              for(int i=0; i<10; i++) {
service.execute(new InnerFixedThread_executor(i));
            }
        
        
        }catch(Exception e){

        }finally{
            service.shutdown();
        }
    }
    
}
