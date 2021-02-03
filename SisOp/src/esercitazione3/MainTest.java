package esercitazione3;
import java.util.concurrent.atomic.AtomicInteger;

import personal.PrintMatrix;

public class MainTest
{
	public static void main(String [] args) throws InterruptedException
	{
		AtomicInteger [][] matrice = new AtomicInteger[2][3];
		
		for(int i = 0; i < matrice.length; i++)
		{
			for(int j = 0; j < matrice[0].length; j++)
				matrice[i][j] = new AtomicInteger();
		}
		
		DecrementaAI dec1 = new DecrementaAI(matrice, 0);
		Thread t1 = new Thread(dec1);
		t1.start();
		t1.join();
		
		DecrementaAI dec2 = new DecrementaAI(matrice, 1);
		Thread t2 = new Thread(dec2);
		t2.start();
		t2.join();
		
		IncrementaAI inc1 = new IncrementaAI(matrice, 0);
		Thread t3 = new Thread(inc1);
		t3.start();
		t3.join();
		
		IncrementaAI inc2 = new IncrementaAI(matrice, 1);
		Thread t4 = new Thread(inc2);
		t4.start();
		t4.join();
		
		//IncrementaAI inc3 = new IncrementaAI(matrice, 2);
		//Thread t5 = new Thread(inc3);
		//t5.start();
		//t5.join();
		
		PrintMatrix pm = new PrintMatrix(matrice);
		pm.print();
		
		
	}
}
