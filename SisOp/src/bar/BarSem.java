package bar;

import java.util.concurrent.Semaphore;

public class BarSem extends Bar
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore [] fila = new Semaphore [MAX_PERSONE.length];
	private int [] numPersoneInFila = new int[MAX_PERSONE.length];
	
	public BarSem()
	{
		super();
		for(int i = 0; i < 4; i++)
		{
			fila[i] = new Semaphore(0, true);
			numPersoneInFila[i] = 0;
		}
	}//costruttore
	
	public abstract int scegliEInizia() throws InterruptedException
	{
		int i = 0;
		mutex.acquire();
		if(numPostiLibieri[i] == 0)
		{
			if(numPostiLiberi[1 - i] > 0)
			{
				i = 1 - i;
			}
			else
			{
				if(numPersoneInFila[1] < numPersoneInFila[0])
				{
					i = 1;
				}
				attendiFila(i);
			}
		}
		numPostiLiberi[i]--;
		mutex.release();
	}//scegliEInizia
	
	private void attendiInFila(int i) throws InterruptedException
	{
		numPersoneInFila[i]++;
	}
	
}
