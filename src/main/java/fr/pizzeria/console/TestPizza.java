package fr.pizzeria.console;

public class TestPizza
{

	public static void main(String[] args)
	{
		Pizza pizz = new Pizza("veg", "vegetarienne", CategoriePizza.SANS_VIANDE, 14.5);
		
		System.out.println(pizz);
	}

}
