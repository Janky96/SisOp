package personal;

public class Stampante implements Runnable
{
	private int da;
	private int a;
	
	public Stampante(int da, int a)
	{
		this.da = da;
		this.a = a;
	}
	
	public void run()
	{
		for(int i = da; i <= a; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args)
	{
		Stampante s1 = new Stampante(1, 10);
		Stampante s2 = new Stampante(11, 20);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		
		try
		{
			t1.join();
			t2.start();
			t2.join();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
	}
}
