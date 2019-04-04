package dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

public interface IPizzaDao
{
	Pizza [] findAllPizzas();
	void saveNewPizza(Pizza pizz);
	void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException;
	void deletePizza(String codePizza)throws PizzaExistException;
	//Pizza findPizzabyCode(String codePizza);
	//boolean pizzaExists(String codePizza);
}
