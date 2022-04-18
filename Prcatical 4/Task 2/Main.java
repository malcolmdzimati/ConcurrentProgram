// Name: Batsirai Malcolm Dzimati
// Student Number: u20456078

public class Main {

    public static void main(String[] args) {
	    Queue[] queues = new Queue[4];

        Store store = new Store();

        for(int i = 0; i < 4; i++)
            queues[i] = new Queue(store);

        for(Queue queue : queues)
            queue.start();

    }
}
