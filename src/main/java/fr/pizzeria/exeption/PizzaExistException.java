package fr.pizzeria.exeption;

public class PizzaExistException extends Exception
{
	private static final long serialVersionUID = 1L;


	//constructeur
	public PizzaExistException() {}
	
	
	public PizzaExistException(String msg)
	{
		super(msg);
	}

}
