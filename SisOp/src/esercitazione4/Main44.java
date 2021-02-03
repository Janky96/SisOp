package esercitazione4;

import java.util.concurrent.Semaphore;

public class Main44
{
	public static void main(String [] args)
	{

		Semaphore mutex = new Semaphore(0);
		Semaphore mutex2 = new Semaphore(0);
		
		while(true)
		{	
			
			try
			{	
				Thread.sleep(1000);
				

				Esercizio44A esA = new Esercizio44A(mutex);
				Esercizio44B esB = new Esercizio44B(mutex);
				
				Esercizio44A esA2 = new Esercizio44A(mutex2);
				Esercizio44B esB2 = new Esercizio44B(mutex2);
				
				Thread t1 = new Thread(esA);
				Thread t2 = new Thread(esB);
				
				Thread t3 = new Thread(esA2);
				Thread t4 = new Thread(esB2);
				
				t1.start();
				t2.start();
				t3.start();
				t4.start();
			}
			catch(InterruptedException ie)
			{	
			}
		}
	}
}
