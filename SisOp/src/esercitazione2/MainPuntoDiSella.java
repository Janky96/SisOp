package esercitazione2;

import java.util.ArrayList;
import java.util.List;

public class MainPuntoDiSella
{
	static int [][] matrice = {{6,10,1}, 
								{2,7,4}, 
								{2,16,5}};
	
	public static void main(String [] args) throws InterruptedException
	{
		

		
		for(int i = 0; i < matrice.length; i++)
		{
			MaxRiga maxRiga = new MaxRiga(matrice, i);
			Thread ThreadRiga = new Thread(maxRiga);
			ThreadRiga.start();
			ThreadRiga.join();
			
			int j = maxRiga.getRisultato();
			//System.out.println(j);
			
			MinColonna minColonna = new MinColonna(matrice, j);
			Thread ThreadColonna = new Thread(minColonna);
			ThreadColonna.start();
			ThreadColonna.join();
			int rigaVerifica = minColonna.getRisultato();
			
			//System.out.print(rigaVerifica);
			
			if(i == rigaVerifica)
				System.out.println(matrice[i][j] + " è punto di sella e si trova in [i][j]");
		}
	}
}
