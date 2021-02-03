package lettori.scrittori;

public abstract class MemoriaCondivisa
{
	public abstract void inizioScrittura() throws InterruptedException;
	
	public abstract void fineScrittura() throws InterruptedException;
	
	public abstract void inizioLettura() throws InterruptedException;
	
	public abstract void fineLettura() throws InterruptedException;
	
	protected void test(int numLettori, int numScrittori)
	{
		Lettore lettori [] = new Lettore[numLettori];
		for(int i = 0; i < numLettori; i++)
		{
			lettori[i] = new Lettore(this);
		}
		
		Scrittore scrittori [] = new Scrittore [numScrittori];
		for(int i = 0; i < numScrittori; i++)
		{
			scrittori[i] = new Scrittore(this);
		}
		
		System.out.println("Avviati " + numLettori + " thread lettori");
		for(int i = 0; i < numScrittori; i++)
		{
			new Thread(scrittori[i]).start();
		}
		
		System.out.println("Avviati " + numScrittori + " thread scrittori");
	}
	
	public static void main(String [] args)
	{
		MemoriaCondivisa cond = new MemoriaCondivisaSem();
		cond.test(5, 2);
	}
}
