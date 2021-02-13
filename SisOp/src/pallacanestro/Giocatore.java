package pallacanestro;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Giocatore implements Runnable
{
	private final int MIN_TEMPO = 1;
	private final int MAX_TEMPO = 5;
	private final int MIN_PROB = 30;
	private final int MAX_PROB = 60;
	
	private Partita partita;
	private Random random = new Random();
	private final int idSquadra;
	private final int probabilita = random.nextInt(MAX_PROB - MIN_PROB + 1) + MIN_PROB;
	

	
	public Giocatore(Partita partita, int s)
	{
		this.partita = partita;
		idSquadra = s;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				if(!partita.riceviPalla(idSquadra))
				{
					break;
				}
				attendi(MIN_TEMPO, MAX_TEMPO);
				if(!partita.lanciaPalla(idSquadra, probabilita))
				{
					break;
				}
			}
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("Il giocatore " + Thread.currentThread().getId()
				+ ", della squadra " + idSquadra + ", con probabilità "
				+ probabilita + ", ha terminato la sua esecuzione.");
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
	}
}
