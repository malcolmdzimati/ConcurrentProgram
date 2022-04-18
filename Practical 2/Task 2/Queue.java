// Name:
// Student Number:

public class Queue extends Thread
{
	Store store;

	public Queue(Store s){
		store = s;
	}

	@Override
	public void run()
	{
		for(int i=1; i<=5; i++){
			store.enterStore(i);
		}		
	}
}
