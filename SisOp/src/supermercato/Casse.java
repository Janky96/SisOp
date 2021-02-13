package supermercato;

import java.util.LinkedList;

public abstract class Casse
{
	protected int [] numProdottiInCassa;
	protected boolean [] clienteInCassa;
	protected LinkedList<Integer> idCasseLibere = new LinkedList<>();
	
	public Casse(int numCasse)
	{
		numProdottiInCassa = new int[numCasse];
		clienteInCassa = new boolean[numCasse];
			for(int i = 0; i< clienteInCassa.length; i++)
			{
				clienteInCassa[i] = false;
			}
	}
	
	public abstract int getIdCassa() throws InterruptedException;
	
	public abstract void consegnaProdotti(int id, int p) throws InterruptedException;
	
	public abstract int segnalaCassaLibera(int id) throws InterruptedException;
	
	public abstract void congedaCliente(int id) throws InterruptedException;
	
}
