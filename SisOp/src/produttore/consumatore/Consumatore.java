package produttore.consumatore;

import java.util.concurrent.TimeUnit;

public class Consumatore implements Runnable
{
	private Buffer buffer;
	
	
	public Consumatore(Buffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int i = buffer.get();
				consuma(i);
			}
		} catch(InterruptedException ie)
		{			
		}
	}
	
	private void consuma(int i) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(i);
	}
}
