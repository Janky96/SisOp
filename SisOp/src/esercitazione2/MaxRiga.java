package esercitazione2;

public class MaxRiga implements Runnable
{
	private int [][] matrice;
	private int riga;
	private int indColonna;
	
	public MaxRiga(int [][] matrice, int riga)
	{
		this.matrice = matrice;
		this.riga = riga;
	}//costruttore
	
	public void run()
	{
		int max = matrice[riga][0];
		for(int j = 1; j < matrice[riga].length; j++)
		{
			if(matrice[riga][j] > max)
			{
				max = matrice[riga][j];
				indColonna = j;
			}
		}
	}//run
	
	
	public int getRisultato()
	{
		return indColonna;
	}
}
