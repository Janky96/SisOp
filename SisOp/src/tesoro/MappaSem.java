package tesoro;

import java.util.concurrent.Semaphore;

public class MappaSem extends Mappa
{
	private Semaphore[][] mappa;

	public MappaSem(int n, int m, int x, int y) 
	{
        super(n, m, x, y);
        mappa = new Semaphore[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mappa[i][j] = new Semaphore(1, true);
            }
        }
    }

	@Override
	public boolean iniziaRicerca(int x, int y) throws InterruptedException
	{
		mappa[x][y].acquire();
		if (tesoroTrovato)
		{
			mappa[x][y].release();
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
			mappa[x][y].release();
			return true;
		}
		mappa[x][y].release();
		return false;
	}

	public static void main(String[] args) throws InterruptedException
	{
		int numCercatori = 20;

		int numRighe = 50;
		int numColonne = 70;

		int xTesoro = 7;
		int yTesoro = 32;

		new MappaSem(numRighe, numColonne, xTesoro, yTesoro).test(numCercatori);
	}
}