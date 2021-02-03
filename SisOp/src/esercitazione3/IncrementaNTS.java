package esercitazione3;

public class IncrementaNTS implements Runnable
{
	int [][] matrice;
	int colonna;
	
	public IncrementaNTS(int [][] matrice, int colonna)
	{
		this.matrice = matrice;
		this.colonna = colonna;
	}
	
	public void run()
	{
		for(int i = 0; i < matrice.length; i++)
			matrice[i][colonna] = matrice[i][colonna] + 1;
	}
}
