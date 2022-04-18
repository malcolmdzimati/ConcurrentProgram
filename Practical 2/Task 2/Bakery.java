import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Bakery implements Lock {
    private volatile boolean[] flag;
    private volatile int[] label;

    private int size;


    public Bakery(int n) {
        size=n;
        flag = new boolean[n];
        label = new int[n];
    }
    
    @Override
    public void lock() {
        String name=Thread.currentThread().getName();
        int i = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));

        flag[i]= true;
        label[i]= maxElement(label) + 1;
        for (int k = 0; k < size; k++) {
            while ((k != i) && flag[k] && ((label[k] < label[i]) || ((label[k] == label[i]) && k < i))) {
                //spin wait
            }
        }
    }


    @Override
    public void unlock() {
        String name=Thread.currentThread().getName();
        int me = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
        flag[me]=false;
    }


    private int maxElement(int[] elementArray) {
        int max = Integer.MIN_VALUE;
        for (int element : elementArray) {
            if (element > max) {
                max = element;
            }
        }
        return max;
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
}

