package tesoro;

import java.util.LinkedList;

public abstract class Mappa
{
	protected final Coordinate posizioneTesoro;
	private final LinkedList<Coordinate> elencoCoordinate = new LinkedList<>();
	protected boolean tesoroTrovato = false;
	
	public Mappa(int n, int m, int x, int y)
	{
		posizioneTesoro = new Coordinate(x, y);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				elencoCoordinate.add(new Coordinate(i, j));
			}
		}
	}//costruttore
	
	public abstract boolean iniziaRicerca(int x, int y) throws InterruptedException;
	
	public abstract boolean terminaRicerca(int x, int y) throws InterruptedException;
	
	
	protected void test(int numCeratori) throws InterruptedException
	{
		System.out.println("Test della classe " + getClass().getSimpleName());
		for (int i = 0; i < numCeratori; i++)
		{
			new Thread(new Cercatore(this)).start();
		}
	}
}
