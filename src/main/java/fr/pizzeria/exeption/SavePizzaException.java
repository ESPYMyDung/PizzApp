package fr.pizzeria.exeption;

public class SavePizzaException extends StockageException
{	
	//constructeur
	public SavePizzaException() {}
	
	public SavePizzaException(String msg)
	{
		super(msg);
	}

	
	private static final long serialVersionUID = 1L;
}
