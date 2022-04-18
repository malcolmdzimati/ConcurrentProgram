public class ConsensusThread extends Thread
{
	private Consensus<Integer> consensus;

	ConsensusThread(Consensus<Integer> consensusObject)
	{
		consensus = consensusObject;
	}

	public void run()
	{
		int a =Math.random()*(200-100+1)+100;
		propose(a);
		consensus.decide();
	}
}
