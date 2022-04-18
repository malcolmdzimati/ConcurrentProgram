public class Main {

    public static void main(String[] args){
        Counter c = new Counter();
        Thread t1 = new TDemo(c);
        Thread t2 = new TDemo(c);
        t1.start();
        t2.start();
        
        /*Thread[] threads = new TDemo[5];
        Thread[] runs = new Thread[5];

        for(int i = 0; i < 5; i++){
            threads[i] = new TDemo();
            runs[i] = new Thread(new RDemo());
        }

        System.out.println("Threads created by extending the Thread class:");

        for(Thread t : threads){        // Start running threads
            t.start();
        }

        for(Thread t : threads){        // Wait for all running threads to finish
            try {
                t.join();
            }catch(InterruptedException e){}
        }

        System.out.println("\nThreads created by implementing the Runnable interface:");

        for(Thread r : runs){
            r.start();
        }*/
    }
}
