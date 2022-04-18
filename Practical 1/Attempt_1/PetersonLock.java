import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PetersonLock implements Lock
{
    private boolean[] flag = {false, false};
    private volatile int victim;


    @Override
    public void lock() {
        int i=(int)(Thread.currentThread().getId()%2);
        int j=1-i;
        flag[i]=true;
        victim=i;
        while(flag[j] && victim==i){};
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean tryLock(long arg0, TimeUnit arg1) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void unlock() {
        int i = (int) (Thread.currentThread().getId()%2);
        flag[i]=false;
    }
	
}
