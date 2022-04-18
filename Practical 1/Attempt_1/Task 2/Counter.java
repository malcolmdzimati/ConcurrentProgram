import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public volatile int count;
    public Lock l;


    public Counter(){
        l = new ReentrantLock();
        count=0;
    }

    //Task 2 - Locking
    public int increment(){
        l.lock();
        try{
            return ++count;
        }finally{
            l.unlock();
        }
    }
}
