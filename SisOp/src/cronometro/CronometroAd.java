package cronometro;

import java.util.Scanner;

public class CronometroAd implements Runnable
{
	private Scanner sc;
	
	public CronometroAd(Scanner sc)
	{
		this.sc = sc;
	}
	
	private int azione(int secondi)
	{
		System.out.print(secondi);
		secondi++;
		try
		{
		Thread.sleep(1000);
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		return secondi;
	}
	
	public void run()
	{
		int secondi = 0;
		char comando = sc.next().charAt(0);
		while (true)
		{
			if (comando == 'A')
			{
				while (true)
				{
					secondi = azione(secondi);
				}
			}
		}
	}
}
