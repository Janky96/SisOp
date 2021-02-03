package esercitazione2;

public class MinColonna implements Runnable
{
	private int [][] matrice;
	private int colonna;
	private int indRiga;
	
	public MinColonna(int [][] matrice, int colonna)
	{
		this.matrice = matrice;
		this.colonna = colonna;
	}//costruttore
	
	
	public void run()
	{
		int min = matrice[0][colonna];
		for(int i = 1; i < matrice.length; i++)
		{
			if(matrice[i][colonna] < min)
			{
				min = matrice[i][colonna];
				indRiga = i;
			}
		}
	}//run
	
	
	public int getRisultato()
	{
		return indRiga;
	}
}
