// package Multithreading.basic;



// using extend thread
// public class Hello {
//     public static void main(String[] args) {
//         World w = new World();
//         // initiation of new thread 
//         w.start();

        
//         for(;;) {
//             System.out.println("hello");
//         }
//     }
    
// }



// for implement itefae runnable 

package Multithreading.basic;

public class Hello {

    public static void main(String[] args) {
        World w  = new World();
        Thread t = new Thread(w);
        t.start();


        for(;;) {
            System.out.println("hellow");
        }
    }
}

