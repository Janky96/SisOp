package esercitazione2;

import java.util.Scanner;

public class AzionatoreCronometro
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		Cronometro cronometro = new Cronometro();
		Thread thread = new Thread(cronometro);
		
		System.out.println("Premi invio per cominciare");
		sc.nextLine();
		thread.start();
		System.out.println("Premi invio per terminare");
		sc.nextLine();
		thread.interrupt();
		System.out.println("Programma terminato");
	}
}
