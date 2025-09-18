package Multithreading.Syncronization;

public class Test {
    public static void main(String[] args) {
        Counter c1 = new Counter();

        MyThread t1 = new MyThread(c1);
        MyThread t2 = new MyThread(c1);

        // here the raise conditon arise were two thread shares the common resource at same time  / resourese = Counter 
        // to solve these we use the syncronized keyword to the sharable part  / / counter.increment is sharable part
        
        
    
        
    }
}
