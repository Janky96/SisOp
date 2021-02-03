package esercitazione4;

import java.util.concurrent.Semaphore;

public class Esercizio44B implements Runnable
{
	Semaphore mutex;
	
	public Esercizio44B(Semaphore mutex)
	{
		this.mutex = mutex;
	}//costruttore
	
	public void run()
	{
		try
		{
			mutex.acquire();
			System.out.print("B ");
		}
		catch(InterruptedException ie)
		{
		}
	}
}
