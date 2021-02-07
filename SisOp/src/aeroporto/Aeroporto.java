package aeroporto;

public abstract class Aeroporto
{
	protected int numPisteLibere;
	
	public static final int ATTERRAGGIO = 0;
	public static final int DECOLLO = 1;
	
	public abstract void richiestaPista(int tipo) throws InterruptedException;
	
	public abstract void richiestaNavetta() throws InterruptedException;
	
	public abstract void rilascioPista() throws InterruptedException;
	
	public abstract Thread getAereo() throws InterruptedException;
	
	public abstract void fineSbarco(Thread aereo) throws InterruptedException;
}
