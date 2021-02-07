package trenino;

public abstract class Trenino
{
	protected final static int NUM_CABINE = 8;
	protected int [] cabine;
	protected int scatto, personeInCoda;
	
	public Trenino()
	{
		cabine = new int[NUM_CABINE];
		scatto = 0;
		personeInCoda = 0;
	}
	
	
	
	public abstract void turSali() throws InterruptedException;
	
	public abstract void turScendi() throws InterruptedException;
	
	public abstract void FaiScendere() throws InterruptedException;
	
	public abstract void impFaiSalire() throws InterruptedException;
	
	public abstract void impMuovi() throws InterruptedException;
	
}
