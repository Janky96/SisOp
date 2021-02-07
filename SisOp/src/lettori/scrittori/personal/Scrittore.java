package lettori.scrittori.personal;

import java.util.Random;

public class Scrittore implements Runnable
{
	private MemoriaCondivisa memoria;
	private Random random = new Random();
	

	public Scrittore(MemoriaCondivisa memoria)
	{
		this.memoria = memoria;
	}//costruttore
	
	public void run()
	{
		/*try
		{
			while(true)
			{
				
			}
		} catch(InterruptedException ie)
		{
		}*/
	}
}
