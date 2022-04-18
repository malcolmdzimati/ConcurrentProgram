

public class Counter {
    public volatile int count;


    public Counter(){
        count=0;
    }

    public int increment(){
        return ++count;
    }

}
