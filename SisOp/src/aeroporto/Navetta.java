package aeroporto;

public class Navetta
{
	private Aeroporto aeroporto;
	
	public Navetta(Aeroporto aeroporto)
	{
		this.aeroporto = aeroporto;
	}
	
	public void run()
	{
		try
		{
			Thread aereo = aeroporto.getAereo();
			sbarcaImbarca();
			aeroporto.fineSbarco(aereo);
		} catch(InterruptedException ie)
		{
		}
	}
	
	
	public void sbarcaImbarca() throws InterruptedException
	{
		Thread.sleep(400);
	}
}
