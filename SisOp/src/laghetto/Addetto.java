package laghetto;

public class Addetto implements Runnable
{
	private final static int MIN_TEMPO_RIPOP = 300;
	private final static int MAX_TEMPO_RIPOP = 600;
	private final static int ALLONTANAMENTO = 3000;
	private final static int RIPOP = 1;
	private Laghetto laghetto;
	
	public Addetto(Laghetto l)
	{
		laghetto = l;
	}//costruttore

	public void run()
	{
		
	}
}
