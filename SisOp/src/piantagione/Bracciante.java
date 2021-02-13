package piantagione;

import java.util.concurrent.TimeUnit;

public class Bracciante implements Runnable
{
	private final int [] lavoro = {20, 15, 5};
	private final static int TEMPO_RISPOSO = 10;
	private Piantagione piantagione;
	
	public Bracciante(Piantagione piantagione)
	{
		this.piantagione = piantagione;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int operazione = piantagione.inizia();
				if(operazione == piantagione.OPERAZIONI_TERMINATE)
				{
					break;
				}
				attendi(lavoro[operazione]);
				piantagione.termina();
				attendi(TEMPO_RISPOSO);
			}
		} catch(InterruptedException ie)
		{
			
		}
	}
	
	private void attendi(int tempo) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(tempo);
	}
}
