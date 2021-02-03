package esercitazione3;

public class DecrementaNTS implements Runnable
{
	int [][] matrice;
	int riga;
	
	public DecrementaNTS(int [][] matrice, int riga)
	{
		this.matrice = matrice;
		this.riga = riga;
	}
	
	public void run()
	{
		for(int j = 0; j < matrice[0].length; j++)
			matrice[riga][j] = matrice[riga][j] - 1;
	}
}
