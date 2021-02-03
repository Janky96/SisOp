package esercitazione2;

public class ProdScalare extends Thread
{
	private int [] arr1;
	private int [] arr2;
	private int inf;
	private int sup;
	private int risultato;
	
	public ProdScalare(int [] arr1, int [] arr2, int inf, int sup)
	{
		this.arr1 = arr1;
		this.arr2 = arr2;
		this.inf = inf;
		this.sup = sup;
	}
	
	public void run()
	{
		risultato = 0;
		for (int i = inf; i <= sup; i++)
		{
			risultato += arr1[i] * arr2[i];
		}
	}
	
	public int getRisultato() throws InterruptedException
	{
		join();
		return risultato;
	}
}
