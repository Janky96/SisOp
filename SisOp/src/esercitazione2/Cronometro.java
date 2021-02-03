package esercitazione2;

public class Cronometro implements Runnable
{
	public void run()
	{
		int numSecondi = 1;
		Thread thread = Thread.currentThread();
		while(!thread.isInterrupted())
		{
			try
			{
				thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				break;
			}
			System.out.println(numSecondi);
			numSecondi++;
		}
	}
}
