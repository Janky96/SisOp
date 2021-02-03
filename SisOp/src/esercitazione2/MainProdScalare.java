package esercitazione2;

public class MainProdScalare
{
	public static void main(String [] args)
	{
		int [] array1 = {2, 5, 3, 2 , 32, 12, 23, 7, 43};
		int [] array2 = {2, 7, 4, 1 , 2, 0, 33, 12, 3};
		
		ProdScalare ps1 = new ProdScalare(array1, array2, 0, 2);
		ProdScalare ps2 = new ProdScalare(array1, array2, 3, 5);
		ProdScalare ps3 = new ProdScalare(array1, array2, 6, 8);
		
		ps1.start();
		ps2.start();
		ps3.start();
		
		try
		{
			System.out.println(ps1.getRisultato() + ps2.getRisultato() + ps3.getRisultato());
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
