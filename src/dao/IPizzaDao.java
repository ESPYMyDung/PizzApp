package dao;

import fr.pizzeria.console.Pizza;

public interface IPizzaDao
{
	Pizza [] findAllPizzas();
	void saveNewPizza(Pizza pizz);
	void updatePizza(String codePizza, Pizza pizz);
	void deletePizza(String codePizza);
	Pizza findPizzabyCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
