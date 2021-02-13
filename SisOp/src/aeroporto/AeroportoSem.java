package aeroporto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class AeroportoSem extends Aeroporto
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore [] piste;
	private boolean [] pisteLibere;
	private LinkedList<Thread> codaDecolli;
	
	public AeroportoSem(int numPiste)
	{
		super(numPiste);
		piste = new Semaphore[numPiste];
		pisteLibere = new boolean[numPiste];
		for(int i = 0; i < numPiste; i++)
		{
			piste[i] = new Semaphore(1);
			pisteLibere[i] = true;
		}//for
	}
	
	public void richiediPista(int tipo) throws InterruptedException
	{
		mutex.acquire();
		int pistaDisponibile;
		for(int i = 0; i < pisteLibere.length; i++)
		{
			if(pisteLibere[i])
			{
				piste[i].acquire();
				pistaDisponibile = i;
				pisteLibere[i] = false;
			}
		}
		mutex.release();
	}//richiediPista
	
	
	public void rilasciaPista() throws InterruptedException
	{
		
	}
	
	public Thread getAereo() throws InterruptedException;
	
	public void fineSbarco(Thread aereo) throws InterruptedException;
	
	public void richiedinavetta() throws InterruptedException
	{
		
	}
	
}
