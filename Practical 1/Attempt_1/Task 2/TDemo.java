public class TDemo extends Thread
{
	private Counter counter;

	public TDemo(Counter c){
		counter=c;
	}

	public void run(){
		for(int i=0; i<12; i++){
			System.out.println(this.getName() + " Counter: " + counter.increment());
		}
		System.out.println(String.format("%s is running...", this.getName()));
	}

}
