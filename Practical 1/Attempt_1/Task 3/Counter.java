import java.util.concurrent.locks.Lock;

public class Counter {
    public volatile int count;
    public Lock pl;


    public Counter(){
        pl=new PetersonLock();
        count=0;
    }

    //Task 3 - Peterson Lock 
    public int increment(){
        pl.lock();
        try{
            return ++count;
        }finally{
            pl.unlock();
        }
    }

}
