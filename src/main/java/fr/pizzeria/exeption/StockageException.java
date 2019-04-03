package fr.pizzeria.exeption;

public abstract class StockageException extends Exception
{

	protected static final long serialVersionUID = 1L;
	
	//constructeur
	public StockageException() {}
	
	
	public StockageException(String msg)
	{
		super(msg);
	}


	/*
	public void prixNeg()
	{
		return "Vous aller vous ruiner";
	}
	
	public String tailCode()
	{
		return "code trop petit";
	}
	
	public String nonTrouve()
	{
		return "inconnu au bataillon";
	}
*/
}
