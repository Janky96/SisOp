package esercitazione3;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementaAI implements Runnable
{
	private AtomicInteger [][] matrice;
	private int colonna;
	
	public IncrementaAI(AtomicInteger [][] matrice, int colonna)
	{
		this.matrice = matrice;
		this.colonna = colonna;
	}//costruttore
	
	public void run()
	{
		for(int i = 0; i < matrice.length; i++)
		{
			matrice[i][colonna].addAndGet(1);
		}
	}
}
