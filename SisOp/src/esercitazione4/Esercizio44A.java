package esercitazione4;

import java.util.concurrent.Semaphore;

public class Esercizio44A implements Runnable
{
	Semaphore mutex;
	
	public Esercizio44A(Semaphore mutex)
	{
		this.mutex = mutex;
	}
	
	public void run()
	{
		System.out.print("A ");
		mutex.release();
	}
}
