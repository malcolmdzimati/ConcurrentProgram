import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public volatile int count;
    public Lock l;
    public Lock pl;


    public Counter(){
        l = new ReentrantLock();
        pl=new PetersonLock();
    }

    public int increment(){
        return ++count;
    }
    
    //Task 2 - Locking
    /*public int increment(){
        l.lock();
        try{
            return ++count;
        }finally{
            l.unlock();
        }
    }*/

    //Task 3 - Peterson Lock 
    /*public int increment(){
        pl.lock();
        try{
            return ++count;
        }finally{
            pl.unlock();
        }
    }*/

}
