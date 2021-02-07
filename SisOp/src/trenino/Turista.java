package trenino;

public class Turista implements Runnable
{
	private Trenino trenino;
	
	public Turista(Trenino trenino)
	{
		this.trenino = trenino;
	}//costruttore
	
	public void run()
	{
		try
		{
			while(true)
			{
				trenino.turSali();
				trenino.turScendi();
			}
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
