public abstract class ConsensusProtocol<T> implements Consensus<T>
{
	public volatile Object[] proposed;
	public volatile long waitf;

	public ConsensusProtocol(int threadCount){
		proposed = new Object[threadCount];
	}

	public void propose(T value){
		String name=Thread.currentThread().getName();
                int me = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
		proposed[me] = value;
		System.out.println(name+" Proposed: "+value);
		try{
                                Thread.sleep(waitf);
                 	}catch(InterruptedException ex){
                 		Thread.currentThread().interrupt();
                 }
		
	}

	public	void setWait(long wa){
		waitf=wa;
	}

	abstract public void decide();
}
