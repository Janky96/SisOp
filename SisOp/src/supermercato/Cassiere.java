package supermercato;

import java.util.concurrent.TimeUnit;

public class Cassiere implements Runnable
{
	private Casse casse;
	private int id;
	
	public Cassiere(Casse casse, int id)
	{
		this.casse = casse;
		this.id = id;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int p = casse.segnalaCassaLibera(id);
				scandisciProdotti(p);
				casse.congedaCliente(id);
			}
		}
		catch(InterruptedException ie)
		{
			
		}
	}
	
	private void scandisciProdotti(int p) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(p);
	}
	

}
