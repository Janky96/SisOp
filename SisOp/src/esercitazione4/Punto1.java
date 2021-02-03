package esercitazione4;

import java.util.concurrent.Semaphore;

public class Punto1 implements Runnable
{
	private Oggetto oggetto;
	private Semaphore sem;	
	String stringa;
	
	public Punto1(Oggetto oggetto, Semaphore sem, String stringa)
	{
		this.oggetto = oggetto;
		this.sem = sem;
		this.stringa = stringa;
	}
	
	
	
	public void run()
	{
		try
		{
			sem.acquire();
		} catch (InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
		oggetto.aggiungiNome(stringa);
	}

}