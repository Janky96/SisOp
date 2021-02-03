package esercitazione3;

import java.util.concurrent.atomic.AtomicInteger;

public class DecrementaAI implements Runnable
{
	private AtomicInteger [][] matrice;
	private int riga;
	
	public DecrementaAI(AtomicInteger [][] matrice, int riga)
	{
		this.matrice = matrice;
		this.riga = riga;
	}//costruttore
	
	public void run()
	{
		for(int j = 0; j < matrice[0].length; j++)
		{
			matrice[riga][j].addAndGet(-1);
		}
	}
}
