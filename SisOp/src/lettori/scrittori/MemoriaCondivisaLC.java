package lettori.scrittori;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MemoriaCondivisaLC extends MemoriaCondivisa
{
	private int numLettoriInLettura = 0;
	private boolean scrittoreInScrittura = false;
	
	private Lock l = new ReentrantLock();
	private Condition possoScrivere = l.newCondition();
	private Condition possoLeggere = l.newCondition();
	
	public void inizioScrittura() throws InterruptedException
	{
		l.lock();
		try
		{
			while(scrittoreInScrittura || numLettoriInLettura > 0)
			{
				possoScrivere.await();
			}
			scrittoreInScrittura = true;
		} finally
		{
			l.unlock();
		}
	}//inizioScrittura
	
	public void fineScrittura() throws InterruptedException
	{
		l.lock();
		try
		{
			scrittoreInScrittura = false;
			possoLeggere.signalAll();
			possoScrivere.signal();
			
		} finally
		{
			l.unlock();
		}
	}//fineScrittura
	
	public void inizioLettura() throws InterruptedException
	{
		l.lock();
		try
		{
			while(scrittoreInScrittura)
			{
				possoLeggere.await();
			}
			numLettoriInLettura++;
		} finally
		{
			l.unlock();
		}
	}
	
	public void fineLettura() throws InterruptedException
	{
		l.lock();
		try
		{
			numLettoriInLettura--;
			if(numLettoriInLettura == 0)
			{
				possoScrivere.signal();
			}
		} finally
		{
			l.unlock();
		}
	}
}
