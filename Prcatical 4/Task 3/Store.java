import java.util.concurrent.locks.Lock;

// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class Store
{
	Semaphore l;
	
	public Store(){
		l= new Semaphore(3);
	}

	public void enterStore(int i){
		String name=Thread.currentThread().getName();
		System.out.println(Thread.currentThread().getName()+" Person "+ i +" is trying to get inside.");
		l.acquire();
		try{
			System.out.println(Thread.currentThread().getName()+" Person "+ i  +" has entered the store. Spaces remaining: "+(3-l.state));
			try{
				long a =(long)(Math.random()*(1000-200+1)+200);
                        	Thread.sleep(a);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}finally{
			System.out.println(Thread.currentThread().getName()+" Person "+ i +" has left the store.");
			l.release();
		}
	}
}
