public abstract class ConsensusProtocol<T> implements Consensus<T>
{
	public volatile Object[] proposed;

	public ConsensusProtocol(int threadCount)	{
		proposed = new Object[threadCount];
	}

	public void propose(T value){
		String name=Thread.currentThread().getName();
                int me = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
		proposed[me] = value;		
	}

	abstract public void decide();
}
