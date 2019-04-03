package fr.pizzeria.exeption;

public class DeletePizzaException extends StockageException
{
	//constructeur
	public DeletePizzaException() {}
	
	public DeletePizzaException(String msg)
	{
		super(msg);
	}

	
	private static final long serialVersionUID = 1L;
}
