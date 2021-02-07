package piantagione;

import java.util.Arrays;

public abstract class Piantagione
{
	public static final int OPERAZIONI_TERMINATE = 3;
	protected int numOperazioniRimaste;
	private int [] operazioneDaEffettuare;
	private Thread [] bracciantiALavoro;
	private int idProssimoSettore = 0;
	
	public Piantagione(int numSettori)
	{
		operazioneDaEffettuare = new int[numSettori];
		bracciantiALavoro = new Thread[numSettori];
		numOperazioniRimaste = numSettori * OPERAZIONI_TERMINATE;
	}//costruttore
	
	
	
	public abstract int inizia() throws InterruptedException;	
	
	public abstract void termina() throws InterruptedException;
	
	
	
	protected int getOperazione()
	{
		numOperazioniRimaste--;
		for(int i = 0; i < bracciantiALavoro.length; i++)
		{
			boolean settoreIdoneo = bracciantiALavoro[idProssimoSettore] == null
					&& operazioneDaEffettuare[idProssimoSettore] < OPERAZIONI_TERMINATE;
			if(settoreIdoneo)
			{
				bracciantiALavoro[idProssimoSettore] = Thread.currentThread();
				return operazioneDaEffettuare[idProssimoSettore]++;
			}
			idProssimoSettore = (idProssimoSettore + 1) % operazioneDaEffettuare.length;
		}
		return OPERAZIONI_TERMINATE;
	}//getOperazione
	
	protected void liberaSettore()
	{
		for(int i = 0; i < bracciantiALavoro.length; i++)
		{
			if(bracciantiALavoro[i] == Thread.currentThread())
			{
				bracciantiALavoro[i] = null;
				break;
			}
		}
	}//liberaSettore
	
	protected void test(int numBraccianti)
	{
		for(int i = 0; i < numBraccianti; i++)
		{
			new Thread(new Bracciante(this)).start();
		}
	}
	
	protected void stampa()
	{
		System.out.println(Arrays.toString(operazioneDaEffettuare));
		System.out.println(Arrays.toString(bracciantiALavoro) + "\n");
	}
}
