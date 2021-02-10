package laghetto;

import java.util.Random;

public class Pescatore implements Runnable
{
	private Laghetto laghetto;
	private Random random = new Random();
	private final static int MIN_TEMPO_PESCA = 200;
	private final static int MAX_TEMPO_PESCA = 800;
	private final static int ALLONTANAMENTO = 1000;
	private final static int PESCARE = 0;
	
	public Pescatore(Laghetto l)
	{
		laghetto = l;
	}//costruttore
	
	public void run()
	{
		try
		{
			while(true)
			{
				laghetto.inizia(PESCARE);
				pesca();
				laghetto.finisci(PESCARE);
				Thread.sleep(ALLONTANAMENTO);
			}
		} catch(InterruptedException ie)
		{
		}
	}
	
	private void pesca() throws InterruptedException
	{
		Thread.sleep(random.nextInt(MAX_TEMPO_PESCA - MIN_TEMPO_PESCA + 1) + MIN_TEMPO_PESCA);
	}
}
