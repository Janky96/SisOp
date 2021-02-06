package produttore.consumatore;

public abstract class Buffer
{
	protected int [] buffer;
	protected int in = 0;
	protected int out = 0;
	
	public Buffer(int dimensione)
	{
		buffer = new int[dimensione];
	}//costruttore
	
	public abstract void put(int i) throws InterruptedException;
	
	public abstract int get() throws InterruptedException;
}