package laghetto;

import java.util.concurrent.Semaphore;

public class LaghettoSem extends Laghetto
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore ingresso = new Semaphore(0);
	private Semaphore [] pesci;
	
	public LaghettoSem(int min, int max)
	{
		super(min, max);
		pesci[0] = new Semaphore(numPesci - minPesci);
		pesci[1] = new Semaphore(maxPesci - numPesci);
	}
	
	public void inizia(int t) throws InterruptedException
	{
		pesci[t].acquire(t * (PESCI_ALLA_VOLTA - 1) + 1);
		mutex.acquire();
		if(numPersoneDentro[1 - t] > 0)
		{
			numPersoneInAttesa++;
			mutex.release();
			ingresso.acquire();
		}
		else
		{
			numPersoneDentro[t]++;
			mutex.release();
		}
	}
	
	public void finisci(int t) throws InterruptedException
	{
		
	}
}
