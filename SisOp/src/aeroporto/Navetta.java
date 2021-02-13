package aeroporto;

public class Navetta
{
	private Aeroporto aeroporto;
	private final int TEMPO_SBARCO_IMBARCO = 400;
	
	public Navetta(Aeroporto aeroporto)
	{
		this.aeroporto = aeroporto;
	}
	
	public void run()
	{
		try
		{
			Thread aereo = aereoporto.getAereo();
			serviAereo();
			aeroporto.fineSbarco(aereo);
		} catch(InterruptedException ie)
		{
		}
	}
	
    private void serviAereo() throws InterruptedException {
        System.out.println("La navetta " + Thread.currentThread().getId()
                + " sta servendo un aereo");
        Thread.sleep(TEMPO_SBARCO_IMBARCO);
    }
}
