package tesoro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MappaLC extends Mappa
{
	private Lock[][] mappa;

	public MappaLC(int n, int m, int x, int y)
	{
		super(n, m, x, y);
		mappa = new ReentrantLock[n][m];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				mappa[i][j] = new ReentrantLock(true);
			}
		}
	}

	@Override
	public boolean iniziaRicerca(int x, int y) throws InterruptedException
	{
		mappa[x][y].lock();
		if (tesoroTrovato)
		{
			mappa[x][y].unlock();
			return false;
		}
		return true;
	}

	@Override
	public boolean terminaRicerca(int x, int y) throws InterruptedException
	{
		if (posizioneTesoro.x == x && posizioneTesoro.y == y)
		{
			tesoroTrovato = true;
			mappa[x][y].unlock();
			return true;
		}
		mappa[x][y].unlock();
		return false;
	}

	public static void main(String[] args) throws InterruptedException
	{
		int numCercatori = 20;

		int numRighe = 50;
		int numColonne = 70;

		int xTesoro = 7;
		int yTesoro = 32;

		new MappaLC(numRighe, numColonne, xTesoro, yTesoro).test(numCercatori);
	}
}
