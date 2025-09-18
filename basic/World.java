// package Multithreading.basic;



// using extend thread
// public class World extends Thread {    
//     @Override
//     public void run() {
//       for( ; ;) {
//         System.out.println("World");
//       }
//     }
    
    
// }





// implement runnable interface 
package Multithreading.basic;

  class World  implements Runnable{

    @Override
    public void run() {
      for(;;) {
        System.out.println("world");
      }
      
       }

  
}


