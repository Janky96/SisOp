package esercitazione2;

public class MainEsercizio5
{
	public static void main(String [] args) throws InterruptedException
	{
		int [][] matrice = {{3, 7, 21, 3, 3, 6},
							{3, 21, 5, 7, 7, 7},
							{3, 55, 3, 3, 7, 5}};
		
		Esercizio5 primaRiga = new Esercizio5(matrice, 3, 7, 0);
		Esercizio5 secondaRiga = new Esercizio5(matrice, 3, 7, 1);
		Esercizio5 terzaRiga = new Esercizio5(matrice, 3, 7, 2);
		
		//creazione e start dei Thread
		Thread thread1 = new Thread(primaRiga);
		Thread thread2 = new Thread(secondaRiga);
		Thread thread3 = new Thread(terzaRiga);
		thread1.start();
		thread2.start();
		thread3.start();
		thread1.join();
		thread2.join();
		thread3.join();
		
		
		int counterX = primaRiga.getContX() + secondaRiga.getContX() + terzaRiga.getContX();
		int counterY = primaRiga.getContY() + secondaRiga.getContY() + terzaRiga.getContY();
		
		System.out.println(counterX > counterY);
		System.out.println("counterX: " + counterX + " counterY: " + counterY);
	}
}
