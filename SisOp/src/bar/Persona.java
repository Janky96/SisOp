package bar;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Persona implements Runnable
{
	private Bar bar;
	private Random random = new Random();
	private final static int MIN_TEMPO_PAGAMENTO = 5;
	private final static int MAX_TEMPO_PAGAMENTO = 10;
	private final static int MIN_TEMPO_BERE = 20;
	private final static int MAX_TEMPO_BERE = 40;
	
	
	public Persona(Bar bar)
	{
		this.bar = bar;
	}//costruttore
	
	public void run()
	{
		try
		{
			int operazione = bar.scegliEInizia();
			switch(operazione)
			{
				case 0:
					attendi(operazione);
					break;
				case 1:
					attendi(operazione);
					break;
			}
			switch(operazione)
			{
				case 0:
					operazione = 1;
					break;
				case 1:
					operazione = 0;
					break;
			}
			bar.inizia(operazione);
			bar.finisci(operazione);
			
		} catch(InterruptedException ie)
		{
		}
	}//run
	
	private void attendi(int operazione) throws InterruptedException
	{
		if(operazione == 0)
			attendi(MIN_TEMPO_PAGAMENTO, MAX_TEMPO_PAGAMENTO);
		else
			attendi(MIN_TEMPO_BERE, MAX_TEMPO_BERE);
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
	}
}
