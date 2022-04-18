public class RDemo implements Runnable
{
	private Counter counter;

	public RDemo(Counter c){
		counter=c;
	}

	public void run(){
		for(int i=0; i<7; i++){
			counter.increment();
		}
		System.out.println(Thread.currentThread().getName() + " Counter: " + counter.increment());
		
		System.out.println(String.format("%s is running...", Thread.currentThread().getName()));
	}
}
