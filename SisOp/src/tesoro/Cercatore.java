package tesoro;

import java.util.LinkedList;
import java.util.Random;

public class Cercatore implements Runnable
{
	private static final int MIN_ATTESA = 2;
	private static final int MAX_ATTESA = 5;
	private Mappa mappa;
	private LinkedList<Coordinate> caselleDaVisitare;
	private Random random = new Random();
	
	public Cercatore(Mappa mappa)
	{
		this.mappa = mappa;
		
	}//costruttore
	
	public void run()
	{
		try
		{
			long id = Thread.currentThread().getId();
			while(true)
			{
				Coordinate c = caselleDaVisitare.remove(random.nextInt(caselleDaVisitare.size()));
				if(!mappa.iniziaRicerca(c.x, c.y))
				{
					break;
				}
				
				//Istruzione non richiesta dalla traccia
				System.out.println("Il cercatore " + id + " sta cercando in posizione ("
						+ c.x + "," + c.y + ") \tCaselle rimaste da visitare = "
						+ caselleDaVisitare.size());
				//--------------------------
				
				effettuaRicerca();
				
				if(mappa.terminaRicerca(c.x, c.y))
				{
					System.out.println("Ho vinto!");
					break;
				}
					
			}
		} catch(InterruptedException ie)
		{
		}
	}
	
	private void effettuaRicerca() throws InterruptedException
	{
		Thread.sleep(((MAX_ATTESA - MIN_ATTESA + 1) + MIN_ATTESA) * 1000);
	}
	
	
}
