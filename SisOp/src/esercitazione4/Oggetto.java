package esercitazione4;

public class Oggetto
{
	private String nome;
	
	public Oggetto(String nome)
	{
		this.nome = nome;
	}//costruttore
	
	public String getNome()
	{
		return nome;
	}//getNome
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}//setNome

	
	public void aggiungiNome(String stringa)
	{
		this.nome = this.nome + stringa;
	}
}