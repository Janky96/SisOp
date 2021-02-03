package personal;

public class PrintMatrix <T>
{
	private T [][] matrice;
	
	public PrintMatrix(T [][] matrice)
	{
		this.matrice = matrice;
	}
	
	public void print()
	{
		for(int i = 0; i < matrice.length; i++)
		{
			System.out.print("[");
			for(int j = 0; j < matrice[0].length - 1; j++)
			{
				System.out.print(matrice[i][j] + ", ");
			}
			System.out.print(matrice[i][matrice[0].length - 1 ] + "]\n");
		}
	}
}
