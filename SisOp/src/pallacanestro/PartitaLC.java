package pallacanestro;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PartitaLC extends Partita
{
	Lock l = new ReentrantLock();
	private final Condition [] squadra = new Condition [2];
	private Random random = new Random();
	private int squadraInPossessoDellaPalla = -1;
	
	public PartitaLC()
	{
		for(int i = 0; i < squadra.length; i++)
		{
			squadra[i] = l.newCondition();
		}
	}
	
	public boolean riceviPalla(int s) throws InterruptedException
	{
		l.lock();
		try
		{
			
		} finally
		{
			l.unlock();
		}
	}

	public boolean lanciaPalla(int s, int p) throws InterruptedException

	}

	public int [] termina() throws InterruptedException
	{

	}

}
