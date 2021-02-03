package personal;

public class Name implements Runnable
{
	private int add1;
	private int add2;
	private int somma;
	
	public Name(int add1, int add2)
	{
		this.add1 = add1;
		this.add2 = add2;
	}//costruttore
	
	public void run()
	{
		somma = add1 + add2;
	}
	
	public int getSomma()
	{
		return somma;
	}
	
	public static void main(String [] args) throws InterruptedException
	{
		Name prova1 = new Name(5, 3);
		Thread thread = new Thread(prova1);
		
		thread.start();
		thread.join();
		System.out.println(prova1.getSomma());
	}
}
