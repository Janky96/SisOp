package piantagione;

import java.util.concurrent.TimeUnit;

public class Bracciante implements Runnable
{
	private Piantagione piantagione;
	
	private final static int TEMPO_RIPOSO = 10;
	private final static int []  lavoro = {20,15,5};
	
	
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
				if(operazione == Piantagione.OPERAZIONI_TERMINATE)
				{
					break;
				}
				lavora(operazione);
				piantagione.termina();
				riposa();				
			}
		} catch(InterruptedException ie)
		{
			
		}
	}
	
	public void lavora(int tempo) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(lavoro[tempo]);
	}
	
	public void riposa() throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(TEMPO_RIPOSO);
	}
}
