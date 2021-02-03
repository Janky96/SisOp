package personal;
import java.util.Random;


public class Esercizio1
{

    private static class MyThread extends Thread
    {	String nome;
    	
    	public MyThread(String nome)
    	{
    		this.nome = nome;
    	}
    	
    	public void run()
    	{
    		for(int i = 0; i < 10; i++)
    		{
    			System.out.println("Thread " + nome + ": " + i);
    			try
    			{
    				sleep(1000);
    			}
    			catch(InterruptedException e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }

    public static void main(String args[])
        throws InterruptedException 
    {
    	
    	MyThread t = new MyThread("First");
    	MyThread t2 = new MyThread("Second");
    	t.start();
    	//t2.start();
    	
    	
    	/*for(int i = 0; i < 10; i++)
    	{
    		System.out.println("Not thread: "+ i);
    	}*/
    }
}

