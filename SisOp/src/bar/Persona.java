package bar;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Persona implements Runnable
{
	private Bar bar;
	private int MIN_TEMPO_BERE = 20;
	private int MAX_TEMPO_BERE = 40;
	private int MIN_TEMPO_PAG = 5;
	private int MAX_TEMPO_PAG = 10;
	private Random random = new Random();
	
	public Persona(Bar bar)
	{
		this.bar = bar;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int operazione = bar.scegliEInizia();
				attendi(operazione);
				operazione = 1 - operazione;
				bar.inizia(operazione);
				attendi(operazione);
				bar.finisci(operazione);
			}
		} catch(InterruptedException ie)
		{
		}
	}
	
	private void attendi(int operazione) throws InterruptedException
	{
		if(operazione == 0)
		{
			attendi(MIN_TEMPO_PAG, MAX_TEMPO_PAG);
		}
		else
		{
			attendi(MIN_TEMPO_BERE, MAX_TEMPO_BERE);
		}
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
	}
}
