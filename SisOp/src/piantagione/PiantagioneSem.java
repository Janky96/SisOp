package piantagione;

import java.util.concurrent.Semaphore;

public class PiantagioneSem extends Piantagione
{
	private Semaphore mutex = new Semaphore(1);
	private Semaphore settori;
	
	
	public PiantagioneSem(int numSettori)
	{
		super(numSettori);
		settori = new Semaphore(numSettori, true);
	}
	
	@Override
	public int inizia() throws InterruptedException
	{
		settori.acquire();
		mutex.acquire();
		
		//mettiamo questo come default, poi se quindi c'è davvero qualcosa in realtà lo cambiamo nell'else
		int idOperazione = OPERAZIONI_TERMINATE; 
		if(numOperazioniRimaste == 0)
		{
			settori.release();
		} else
		{
			idOperazione = getOperazione();
		}
		stampa();
		mutex.release();
		return idOperazione;
	}
	
	public void termina() throws InterruptedException
	{
		mutex.acquire();
		liberaSettore();
		mutex.release();
		settori.release();
	}
	
	public static void main(String [] args)
	{
		int numSettori = 8;
		int numBraccianti = 20;
		new PiantagioneSem(numSettori).test(numBraccianti);
	}
	
	
}
