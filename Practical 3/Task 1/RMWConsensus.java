public class RMWConsensus<T> extends ConsensusProtocol<T>{
	private RMWRegister r = new RMWRegister(10);

	public	object decide(){
		System.out.println("");
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
		System.out.print(name+ " Decided :");
		if(r.getAndMumble()==10){
			System.out.println(proposed[i]);
		}else{
			System.out.println(proposed[1-j]);	
		}
	}
}
