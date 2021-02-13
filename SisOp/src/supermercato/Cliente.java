package supermercato;

import java.util.Random;

public class Cliente implements Runnable
{
	private final static int MIN_PRODOTTO = 1;
	private final static int MAX_PRODOTTO = 50;
	private Random random = new Random();
	private Casse casse;
	private int numProdotti;
	
	
	public Cliente(Casse casse)
	{
		this.casse = casse;
		numProdotti = random.nextInt(MAX_PRODOTTO - MIN_PRODOTTO + 1) + MIN_PRODOTTO;
	}//costruttore
	
	public void run()
	{
		try
		{
			while(true)
			{
				int idCassa = casse.getIdCassa();
				casse.consegnaProdotti(idCassa, numProdotti);

			}
		} catch(InterruptedException ie)
		{
		}
	}
}
