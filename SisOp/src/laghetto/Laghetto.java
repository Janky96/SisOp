package laghetto;

import java.util.Random;

public abstract class Laghetto
{
	protected final static int PESCI_ALLA_VOLTA = 10;
	
	protected final int minPesci;
	protected final int maxPesci;
	protected int numPesci;
	protected int [] numPersoneDentro = {0, 0};
	
	public Laghetto(int min, int max)
	{
		minPesci = min;
		maxPesci = max;
		numPesci = new Random().nextInt(max - min + 1) + min;
	}
	
	protected void pesca()
	{
		numPesci--;
	}
	
	protected void ripop()
	{
		numPesci += 10;
	}
	
	public abstract void inizia(int t) throws InterruptedException;
	
	public abstract void finisci(int t) throws InterruptedException;
}
