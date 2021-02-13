package bar;

import java.util.concurrent.Semaphore;

public class BarSem extends Bar
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore [] fila;
	private int [] numPersoneInFila = {0,0};
	
	public BarSem()
	{
		super();
		fila = new Semaphore[posto.length];
		for(int i = 0; i < posto[1]; i++)
		{
			fila[i] = new Semaphore(0, true);
		}
	}
	
	public int scegliEInizia() throws InterruptedException
	{
		mutex.acquire();
		int i = 0;
		if(numPostiLiberi[i] == 0)
		{
			if(numPostiLiberi[i + 1] > 0)
			{
				i = 1 - i;
			} else
			{
				if (numPersoneInFila[i] > numPersoneInFila[i + 1])
				{
					i++;
				}
			}
		}
		mutex.release();

		return i;
	}
	
	public void inizia(int i) throws InterruptedException
	{
		mutex.acquire();
		fila[i].acquire();
		numPersoneInFila[i]--;
		
		mutex.release();
	}
	
	public void finisci(int i) throws InterruptedException
	{
		mutex.acquire();

		fila[i].release();
		mutex.release();
	}
}
