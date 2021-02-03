package lettori.scrittori;

import java.util.concurrent.Semaphore;

public class MemoriaCondivisaSem extends MemoriaCondivisa
{
	private int numLettori = 0;
	
	private Semaphore lettura = new Semaphore(1);
	private Semaphore scrittura = new Semaphore(1);
	
	public void inizioScrittura() throws InterruptedException
	{
		scrittura.acquire();
	}
	
	public void fineScrittura() throws InterruptedException
	{
		scrittura.release();
	}
	
	public void inizioLettura() throws InterruptedException
	{
		lettura.acquire();
		if(numLettori == 0)
		{
			scrittura.acquire();
		}
		numLettori++;
		lettura.release();
	}
	
	public void fineLettura() throws InterruptedException
	{
		lettura.acquire();
		numLettori--;
		if(numLettori == 0)
		{
			scrittura.release();
		}
		lettura.release();
	}
}
