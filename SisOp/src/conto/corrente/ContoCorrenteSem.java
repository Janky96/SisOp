package conto.corrente;

import java.util.concurrent.Semaphore;

public class ContoCorrenteSem extends ContoCorrente
{
	private Semaphore mutex = new Semaphore(1);
	
	public ContoCorrenteSem(int depositoIniziale)
	{
		super(depositoIniziale);
	}
	
	public void deposita(int importo)
	{
		try
		{
			mutex.acquire();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		deposito += importo;
		mutex.release();
	}
	
	public void preleva(int importo)
	{
		try
		{
			mutex.acquire();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		deposito -= importo;
		mutex.release();
	}
}
