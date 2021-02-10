package casello;

import java.util.concurrent.Semaphore;

public class CaselloSem extends Casello
{
	Semaphore mutex = new Semaphore(1);
	Semaphore [] porte;
	
	public CaselloSem(int numPorte, int tariffa)
	{
		super(numPorte, tariffa);
		porte = new  Semaphore [numPorte];
		for(int i = 0; i < numPorte; i++)
		{
			porte[i] = new Semaphore(1, true);
		}
	}//costruttore
	
	public void accedi(int porta) throws InterruptedException
	{
		mutex.acquire();
		porte[porta].acquire();
		mutex.release();
	}
	
	public void pagaEAbbandona(int porta, int km) throws InterruptedException
	{
		mutex.acquire();
		incasso += km * tariffa;
		porte[porta].release();
		mutex.release();
	}
	
}
