package bar;

public abstract class Bar
{
	protected final int [] posto = {1,4};
	
	protected int[] numPostiLiberi = new int[posto.length];

	public Bar() {
		for (int i = 0; i < posto.length; i++) {
			numPostiLiberi[i] = posto[i];
		}
	}
	
	public abstract int scegliEInizia() throws InterruptedException;
	
	public abstract void inizia(int i) throws InterruptedException;
	
	public abstract void finisci(int i) throws InterruptedException;
}
