package esercitazione4;

import java.util.concurrent.Semaphore;

public class Punto2 implements Runnable
{
	private Oggetto oggetto;
	private Semaphore sem;	
	String stringa;
	
	public Punto2(Oggetto oggetto, Semaphore sem, String stringa)
	{
		this.oggetto = oggetto;
		this.sem = sem;
		this.stringa = stringa;
	}
	
	
	
	public void run()
	{
		oggetto.aggiungiNome(stringa);
		sem.release();
	}

}
