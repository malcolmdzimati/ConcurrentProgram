public class TDemo extends Thread
{
	private Counter counter;
	private int pos;

	public TDemo(Counter c){
		counter=c;
	}


	//Task 1
	public void run(){
		for(int i=0; i<50; i++){
			System.out.println(this.getName() + " Counter: " + counter.increment());
		}
		System.out.println(String.format("%s is running...", this.getName()));
	}

}

//Task 2
	/*public void run(){
		for(int i=0; i<10; i++){
			counter.l.lock();
			try{	
				counter.increment();
				System.out.println(this.getName() + " Counter: " + counter.count);
			}finally{
				counter.l.unlock();
			}
		}
		System.out.println(String.format("%s is running...", this.getName()));
	}*/

	//Task 3
	/*public void run(){
		for(int i=0; i<10; i++){
			counter.pl.lock();
			try{	
				counter.increment();
				System.out.println(this.getName() + " Counter: " + counter.count);
			}finally{
				counter.pl.unlock();
			}
		}
		System.out.println(String.format("%s is running...", this.getName()));
	}*/
