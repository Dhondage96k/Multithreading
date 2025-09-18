package Multithreading.Syncronization.LOck;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class InnerReadwrite_Lock {


// In Java multithreading, a ReadWriteLock is synchronization mechanism that allows multiple threads to read simultaneously,
//   but ensures that only one thread can write at a time (and when writing, no other thread can read).

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    WriteLock eWriteLock = lock.writeLock();
    ReadLock readLock = lock.readLock();

    int count =0;


    void write() {
        try {

            eWriteLock.lock();
            count +=1;
            System.out.println("wtire operation count   = "+count);


        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }finally{
            eWriteLock.unlock();
        }
        


    }
    
    void read() {
        try {
            readLock.lock();
            System.out.println("read Operation by thread " +Thread.currentThread().getName() + "count  ="+count);
    
        } catch (Exception e) {
            
        }finally{
            readLock.unlock();
        }
           }
}

public class Readwrite_Lock {
    public static void main(String[] args) {

        InnerReadwrite_Lock lock = new InnerReadwrite_Lock();

        Runnable write = new Runnable() {

            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    lock.write();
                }
               

                      }
            
        };

        Runnable read = new Runnable() {
            public void run() {
                for(int i=0; i<10; i++) {
                    lock.read();
                }
            }
        };
        




        Thread t1 = new Thread(write , "Thread1");
        Thread t2 = new Thread(read , "Thread2");
        Thread t3 = new Thread(read , "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
