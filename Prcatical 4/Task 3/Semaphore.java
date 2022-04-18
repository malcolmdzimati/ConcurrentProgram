import java.util.concurrent.atomic.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class Semaphore{
	final int capacity;
	int state;
	Lock lock;
	Condition condition;

	public Semaphore(int c){
		capacity=c;
		state=0;
		lock=new ReentrantLock();
		condition=lock.newCondition();
	}

	public void acquire(){
		lock.lock();
		try{
			while(state==capacity){
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			state++;
		} finally {
			lock.unlock();
		}
	}

	public void release(){
		lock.lock();
		try{
			state--;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
