package esercitazione2;

public class Esercizio5 implements Runnable
{
	private int [][] matrice;
	private int x;
	private int y;
	private int ripX;
	private int ripY;
	private int riga;
	
	
	public Esercizio5(int [][] matrice, int x, int y, int riga)
	{
		this.matrice = matrice;
		this.x = x;
		this.y = y;
		this.riga = riga;
	}//costruttore
	
	public void run()
	{
		int counterX = 0;
		int counterY = 0;
		for(int j = 0; j < matrice[0].length; j++)
		{
			if(matrice[riga][j] == x)
				counterX++;
			if(matrice[riga][j] == y)
				counterY++;
		}
		ripX = counterX;
		ripY = counterY;
	}//run
	
	public int getContX()
	{
		return ripX;
	}//getContX
	
	public int getContY()
	{
		return ripY;
	}//getContY
}
