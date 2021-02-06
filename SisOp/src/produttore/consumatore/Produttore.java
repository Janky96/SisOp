package produttore.consumatore;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Produttore implements Runnable
{
	private Buffer buffer;
	private Random random = new Random();
	private final int MAX_RANDOM = 10;
	private final int MAX_TEMPO_PRODUZIONE = 5;
	private final int MIN_TEMPO_PRODUZIONE = 1;
	
	public Produttore(Buffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int i = produci();
				buffer.put(i);
			}
		} catch(InterruptedException ie)
		{
		}//catch
	}//run
	
	private int produci() throws InterruptedException
	{
		attendi(MIN_TEMPO_PRODUZIONE, MAX_TEMPO_PRODUZIONE);
		return random.nextInt(MAX_RANDOM);
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(random.nextInt((max - min + 1) + min));
	}
}
