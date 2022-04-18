public class TDemo extends Thread
{
	private Counter counter;
	private int pos;

	public TDemo(Counter c){
		counter=c;
	}


	//Task 1
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println(this.getName() + " Counter: " + counter.increment());
		}
		System.out.println(String.format("%s is running...", this.getName()));
	}

}
