package esercitazione4;

import java.util.concurrent.Semaphore;

public class Main1
{
	public static void main(String [] args)
	{
		Semaphore sem = new Semaphore(0);
		Oggetto ogg = new Oggetto("Gennaro");
		Punto1 p1 = new Punto1(ogg, sem, "uno");
		Punto2 p2 = new Punto2(ogg, sem, "due");
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
		
		try
		{
			t1.join();
			t2.join();
		} catch (InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
		System.out.println(ogg.getNome());
	}
}
