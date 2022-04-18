import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class Filter implements Lock
{

	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock()
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

        volatile int[] level;
        volatile int[] victim;
	volatile int n;
	int c;
	
        public Filter(int size){
		n=size;
                level = new int[n];
                victim = new int[n];
        }

        public void lock(){
	        String name=Thread.currentThread().getName();
                int me = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));

                for (int i = 1; i < n; i++) {
            		level[me]=i;
            		victim[i]=me;
            		for (int k = 0; k < n; k++) {
                		while ((k != me) && (level[k] >= i && victim[i] == me)) {
                    			//spin wait
                		}
           		 }
       		 }
        }

        public void unlock(){
		String name=Thread.currentThread().getName();
                int me = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
                level[me]=0;
        }

}
