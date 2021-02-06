package produttore.consumatore;

import java.util.concurrent.Semaphore;

public class BufferSem extends Buffer
{
	private Semaphore ciSonoElementi = new Semaphore(0);
	private Semaphore ciSonoPostiVuoti;
	private Semaphore mutex = new Semaphore(1);
	
	public BufferSem(int dimensione)
	{
		super(dimensione);
		ciSonoPostiVuoti = new Semaphore(dimensione);
	}//costruttore
	
	public void put(int i) throws InterruptedException
	{
		ciSonoPostiVuoti.acquire();
		mutex.acquire();
		buffer[in] = i;
		in = (in + 1) % buffer.length;
		mutex.release();
		ciSonoElementi.release();
	}
	
	
	public int get() throws InterruptedException
	{
		ciSonoElementi.acquire();
		mutex.acquire();
		int i = buffer[out];
		out = (out + 1) % buffer.length;
		mutex.release();
		ciSonoPostiVuoti.release();
		return i;
	}
}
