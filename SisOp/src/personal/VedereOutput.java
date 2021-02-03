package personal;

public class VedereOutput extends Thread
{
	public VedereOutput(String name)
	{
		super(name);
	}
	
	public void run()
	{
		for(int i = 0; i < 2; i++)
		{
			System.out.println(getName());
		}
	}
	
	public static void main(String [] args)
	{
		new VedereOutput("0").start();
		new VedereOutput("1").start();
	}
}
