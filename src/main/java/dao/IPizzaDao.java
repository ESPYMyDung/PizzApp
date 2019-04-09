package dao;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

public interface IPizzaDao
{
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizz);
	void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException;
	void deletePizza(String codePizza)throws PizzaExistException;
}
