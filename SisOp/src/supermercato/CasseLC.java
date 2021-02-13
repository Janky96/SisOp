package supermercato;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CasseLC extends Casse
{
	private Lock schermo = new ReentrantLock();
	private Condition cassaLibera = schermo.newCondition();
	private Lock [] casse;
	private Condition [] cassiere;
	private Condition [] cliente;
	
	private LinkedList<Thread> fila = new LinkedList<>();

	
	public CasseLC(int numCasse)
	{		
		super(numCasse);
		casse = new ReentrantLock[numCasse];
		cliente = new Condition[numCasse];
		cassiere = new Condition[numCasse];
		for(int i = 0; i < numCasse; i++)
		{
			casse[i] = new ReentrantLock();
			cassiere[i] = casse[i].newCondition();
			cliente[i] = casse[i].newCondition();
		}

	}//costruttore
	
	public int getIdCassa() throws InterruptedException
	{
		int id;
		schermo.lock();
		try
		{
			Thread t = Thread.currentThread();
			fila.add(t);
			while(!mioTurno(t))
			{
				cassaLibera.await();
			}
			fila.remove(t);
			id = idCasseLibere.remove();
		} finally
		{
			schermo.unlock();
		}
		return id;
	}//getIdCassa
	
	private boolean mioTurno(Thread t)
	{
		return fila.indexOf(t) < idCasseLibere.size();
	}
	
	public void consegnaProdotti(int id, int p) throws InterruptedException
	{
		casse[id].lock();
		try
		{
			while(clienteInCassa[id])
			{
				cliente[id].await();
			}
			numProdottiInCassa[id] = p;
			cassiere[id].signal();
			clienteInCassa[id] = true;
			while(numProdottiInCassa[id] > 0)
			{
				cliente[id].await();
			}
			clienteInCassa[id] = false;
			cliente[id].signal();
		} finally
		{
			casse[id].unlock();
		}
	}
	
	public int segnalaCassaLibera(int id) throws InterruptedException
	{
		schermo.lock();
		try
		{
			idCasseLibere.add(id);
			cassaLibera.signalAll();
		} finally
		{
			schermo.unlock();
		}
		casse[id].lock();
		try
		{
			while(numProdottiInCassa[id] == 0)
			{
				cassiere[id].await();
			}
		} finally
		{
			casse[id].unlock();
		}
		return numProdottiInCassa[id];
	}
	
	public void congedaCliente(int id)
	{
		casse[id].lock();
		try
		{
			numProdottiInCassa[id] = 0;
			cliente[id].signal();
		} finally
		{
			casse[id].unlock();
		}
	}

	
}
