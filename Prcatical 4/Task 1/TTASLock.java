import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class TTASLock implements Lock{
	AtomicBoolean state = new AtomicBoolean(false);
	
	TTASLock(){

	}

	public void lock(){
		while(true){
			while(state.get()) {};
			if(!state.getAndSet(true)){
				return;
			}
		}
	}

	public void unlock(){
		state.set(false);
	}

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
}
