package casello;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable
{
	private Casello casello;
	private int km;
	private static Random random = new Random();
	
	private final static int MIN_TRATTO = 50;
	private final static int MAX_TRATTO = 100;
	private final static int MIN_TEMPO_PAGAMENTO = 3;
	private final static int MAX_TEMPO_PAGAMENTO = 6;
	
	
	public Automobile(Casello casello)
	{
		this.casello = casello;
	}//costruttore
	
	public void run()
	{
		try
		{
			while(true)
			{
				//segno i km, e faccio la sleep
				percorriStrada();
				
				//prendo una porta a caso dal casello
				int porta = random.nextInt(casello.getNumPorte());
				casello.accedi(porta);
				
				//attesa per il pagamento tra i 3 e i 6 secondi
				attendi(MIN_TEMPO_PAGAMENTO, MAX_TEMPO_PAGAMENTO);
				//pagamento e se ne va
				casello.pagaEAbbandona(porta, km);
			}
		} catch(InterruptedException ie)
		{			
		}
	}
	
	public int getKm()
	{
		return km;
	}
	
	private void percorriStrada() throws InterruptedException
	{
		km = random.nextInt(MAX_TRATTO - MIN_TRATTO + 1) + MIN_TRATTO;
		TimeUnit.SECONDS.sleep(km * 40);
	}
	
	private void attendi(int min, int max) throws InterruptedException
	{	
		int tempo = random.nextInt(MAX_TEMPO_PAGAMENTO - MIN_TEMPO_PAGAMENTO + 1) + MIN_TEMPO_PAGAMENTO;
		TimeUnit.SECONDS.sleep(tempo);
	}
	
}
