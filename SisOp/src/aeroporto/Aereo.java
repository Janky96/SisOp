package aeroporto;

import java.util.Random;

public class Aereo implements Runnable
{
	private final int MIN_TEMPO_VOLO = 600;
	private final int MAX_TEMPO_VOLO = 900;
	private final int TEMPO_DECOLLO = 300;
	private final int TEMPO_ATTERRAGGIO = 300;
	private Random random = new Random();
	private Aeroporto aeroporto;
	
	public Aereo(Aeroporto aeroporto)
	{
		this.aeroporto = aeroporto;
	}
	
	public void run()
	{
		try
		{
			//sta volando
			attendi(MIN_TEMPO_VOLO, MAX_TEMPO_VOLO);
			
			aeroporto.richiediPista();			
			Thread.sleep(TEMPO_ATTERRAGGIO);
			aeroporto.rilasciaPista();
			
			//Passeggeri scendono e salgono
			aeroporto.richiediNavetta();			
			
			aeroporto.richiediPista();
			//decollo
			Thread.sleep(TEMPO_DECOLLO);
			aeroporto.rilasciaPista();
		} catch(InterruptedException ie)
		{	
		}
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{
		Thread.sleep(random.nextInt(max - min + 1) + min);
	}
	
	
}