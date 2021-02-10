package casello;

public abstract class Casello
{
	private int numPorte;
	protected int incasso;
	protected int tariffa;
	
	
	public Casello(int numPorte, int tariffa)
	{
		this.incasso = 0;
		this.numPorte = numPorte;
		this.tariffa = tariffa;
	}//costruttore
	
	public abstract void accedi(int porta) throws InterruptedException;
	
	public abstract void pagaEAbbandona(int porta, int km) throws InterruptedException;
	
	public int getNumPorte()
	{
		return numPorte;
	}
	
	public int getIncasso()
	{
		return incasso;
	}//getIncasso
	
	public void test(int V)
	{
	}
}
