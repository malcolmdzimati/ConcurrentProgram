public abstract class RMWRegister{
	private int value;

	public RMWRegister(v){
		value=v;
	}

	public int synchronized getAndMumble() { 
    		int prior  = this.value; 
    		this.value = mumble(this.value); 
    		return prior; 
  	}

	public int mumble(int x){
		return ++x;
	}
}
