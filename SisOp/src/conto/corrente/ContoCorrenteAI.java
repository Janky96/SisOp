package conto.corrente;

import java.util.concurrent.atomic.AtomicInteger;

public class ContoCorrenteAI extends ContoCorrente
{
	//Questa classe ci permette di eliminare la race condition
	//Le variabili che possono essere modificate contemporaneamente da più thread saranno
	//accedute in modo ATOMICO
	
	private AtomicInteger deposito;
	
	public ContoCorrenteAI(int depositoIniziale)
	{
		super(depositoIniziale);
		deposito = new AtomicInteger(depositoIniziale);
	}
	
	public void deposita(int importo)
	{
		deposito.addAndGet(importo);
	}
	
	public void preleva(int importo)
	{
		deposito.addAndGet(-importo);
	}//preleva
	
	public int getDeposito()
	{
		return deposito.get();
	}
}
