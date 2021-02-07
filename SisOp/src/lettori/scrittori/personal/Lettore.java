package lettori.scrittori.personal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Lettore implements Runnable
{
	private MemoriaCondivisa memoria;
	private Random random = new Random();
	
	private final static int MIN_TEMPO_LETTURA = 1;
	private final static int MAX_TEMPO_LETTURA = 4;
	private final static int MIN_TEMPO_ALTRO = 6;
	private final static int MAX_TEMPO_ALTRO = 10;
	
	public Lettore(MemoriaCondivisa mem)
	{
		memoria = mem;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
			memoria.inizioLettura();
			leggi();
			memoria.fineLettura();
			faiAltro();
			} catch (InterruptedException ie)
			{
			}
		}
	}//run
	
	public void leggi() throws InterruptedException
	{
		attendi(MIN_TEMPO_LETTURA, MAX_TEMPO_LETTURA);
	}//leggi
	
	public void faiAltro() throws InterruptedException
	{
		attendi(MIN_TEMPO_ALTRO, MAX_TEMPO_ALTRO);
	}
	
	public void attendi(int min, int max) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(random.nextInt(max - min + 1) + min);
	}//attendi
}
