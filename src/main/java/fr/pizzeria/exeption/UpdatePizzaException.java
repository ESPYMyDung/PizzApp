package fr.pizzeria.exeption;

public class UpdatePizzaException extends StockageException
{
	//constructeur
	public UpdatePizzaException() {}
	
	public UpdatePizzaException(String msg)
	{
		super(msg);
	}
	
	private static final long serialVersionUID = 1L;
}
