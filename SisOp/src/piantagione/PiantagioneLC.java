package piantagione;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PiantagioneLC extends Piantagione
{
	private Lock coda = new ReentrantLock(true);
	private Lock l = new ReentrantLock();
	private Condition settoreSuCuiLavorare = l.newCondition();
	private int numSettoriLiberi;
	
	public PiantagioneLC(int numSettori)
	{
		super(numSettori);
		numSettoriLiberi = numSettori;
	}
	
	public int inizia() throws InterruptedException
	{
		coda.lock();
		l.lock();
		try
		{
			while(numSettoriLiberi == 0)
			{
				settoreSuCuiLavorare.await();
			}
			if(numOperazioniRimaste == 0)
			{
				return OPERAZIONI_TERMINATE;
			}
			numOperazioniRimaste--;
			return getOperazione();
		} finally
		{
			l.unlock();
			coda.unlock();
		}
	}//inizia
	
	public void termina() throws InterruptedException
	{
		l.lock();
		try
		{
			liberaSettore();
			numSettoriLiberi++;
			if(numOperazioniRimaste == 0)
			{
				settoreSuCuiLavorare.signalAll();
			}
			else
			{
				settoreSuCuiLavorare.signal();
			}
		} finally
		{
			l.unlock();
		}
	}
	
	
}
