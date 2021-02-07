package aeroporto;

import java.util.Random;

public class Aereo implements Runnable
{
	private Aeroporto aeroporto;
	
	private Random random = new Random();
	
	private final static int MIN_TEMPO_VOLO = 600;
	private final static int MAX_TEMPO_VOLO = 900;
	
	public Aereo(Aeroporto aeroporto)
	{
		this.aeroporto = aeroporto;
	}
	
	public void run()
	{
		/*try
		{
			while (true)
			{
				vola();
				aeroporto.richiestaPista(aeroporto.ATTERRAGGIO);
				atterra();
				aeroporto.rilasciaPista()
				aeroporto.richiestaNavetta();
				aeroporto.richiestaPista(aeroporto.DECOLLO)
				preparazione();
				aeroporto.rilasciaPista();
			}
		} catch(InterruptedException ie)
		{
		}*/
	}
	
	public void vola() throws InterruptedException
	{
		Thread.sleep(random.nextInt(MAX_TEMPO_VOLO - MIN_TEMPO_VOLO + 1) + MIN_TEMPO_VOLO);
	}
	
	public void atterra() throws InterruptedException
	{
		Thread.sleep(300);
	}
	
	public void preparazione() throws InterruptedException
	{
		Thread.sleep(300);
	}
}
