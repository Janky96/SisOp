package esercitazione2;

public class Sommatoria
{
	public static void main(String [] args)
	{
		int primo = 1;
		int ultimo = 100;
		int intermedio = (primo + ultimo)/2;
		Sommatore s1 = new Sommatore(primo, intermedio);
		Sommatore s2 = new Sommatore(intermedio + 1, ultimo);
		s1.start();
		s2.start();
		
		try
		{
			System.out.println(s1.getSomma() + s2.getSomma());
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
