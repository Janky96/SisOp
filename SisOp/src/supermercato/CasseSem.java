package supermercato;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class CasseSem extends Casse
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore schermo = new Semaphore(0, true);
	private Semaphore [] cassiere;
	private Semaphore [] cliente;
	
	private LinkedList<Integer> idCasseLibere = new LinkedList<>();
	
	public CasseSem(int numCasse)
	{
		super(numCasse);
		cassiere = new Semaphore[numCasse];
		cliente = new Semaphore[numCasse];
		for(int i = 0; i < cassiere.length; i++)
		{
			cassiere[i] = new Semaphore(0);
			cliente[i] = new Semaphore(0);
		}
	}//costruttore
	
	public int getIdCassa() throws InterruptedException
	{
		int id;
		mutex.acquire();
		schermo.acquire();
		id = idCasseLibere.remove();
		mutex.release();
		return id;
	}
	
	public void consegnaProdotti(int id, int p) throws InterruptedException
	{
		numProdottiInCassa[id] = p;
		cassiere[id].release();
		cliente[id].acquire();
	}
	
	public int segnalaCassaLibera(int id) throws InterruptedException
	{
		mutex.acquire();
		idCasseLibere.add(id);
		mutex.release();
		
		schermo.release();
		cassiere[id].acquire();
		return numProdottiInCassa[id];
	}
	
	public void congedaCliente(int id)
	{
		cliente[id].release();
	}
	
	
}
