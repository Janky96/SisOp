package pallacanestro;

import java.util.concurrent.TimeUnit;

public class Arbitro implements Runnable
{
	private Partita partita;
	private int TEMPO_LIMITE = 40 * 60;
	
	public Arbitro(Partita partita)
	{
		this.partita = partita;
	}
	
	public void run()
	{
		try
		{
			avviaPartita();
			int risultato [] = partita.termina();
			if(risultato[0] == risultato[1])
			{
				System.out.println("La partita è terminata in parità, " + risultato[0] + " a "
						+ risultato[1] + ".");
			}
			else
			{
				int idSquadraVincente = risultato[0] > risultato[1] ? 0 : 1;
				System.out.println("La partita è terminata, la squadra "
						+ idSquadraVincente + " ha vinto per "
						+ risultato[idSquadraVincente] + " a "
						+ risultato[1 - idSquadraVincente] + ".");
			}
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}//catch
	}
	
	public void avviaPartita() throws InterruptedException
	{
		while(true)
		{
			TimeUnit.SECONDS.sleep(TEMPO_LIMITE);
		}
	}
}
