package aeroporto;

public abstract class Aeroporto
{
	protected int numPiste;
	public static final int ATTERRAGGIO = 0;
	public static final int DECOLLO = 1;
	
	
	public Aeroporto(int numPiste)
	{
		this.numPiste = numPiste;
	}
	
	public abstract void richiediPista(int tipo) throws InterruptedException;
	
	public abstract void rilasciaPista() throws InterruptedException;			
	
	public abstract Thread getAereo() throws InterruptedException;
	
	public abstract void fineSbarco(Thread aereo) throws InterruptedException;
	
	public abstract void richiedinavetta() throws InterruptedException;
}