package trenino;

public class Impiegato
{
	private Trenino trenino;
	private int scatto;
	
	public Impiegato(Trenino trenino)
	{
		this.trenino = trenino;
		scatto = 0;
	}//costruttore
	
	public void run()
	{
		try
		{
			while(true)
			{
				trenino.impFaiSalire();
				trenino.impFaiSalire();
				trenino.impMuovi();
			}
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
