package dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

public class PizzaMemDao implements IPizzaDao {
	// attributs
	public List<Pizza> listPizz = new ArrayList<>();

	// constructeur
	public PizzaMemDao()
	{
		listPizz.add(new Pizza(0, "PEP", "Pépéronie", CategoriePizza.VIANDE, 12.50));
		listPizz.add(new Pizza(1, "MAR", "Margherita",CategoriePizza.SANS_VIANDE, 14.00));
		listPizz.add(new Pizza(2, "REIN", "La Reine",CategoriePizza.VIANDE, 11.50));
		listPizz.add(new Pizza(3, "FRO", "La 4 fromages",CategoriePizza.VIANDE, 12.00));
		listPizz.add(new Pizza(4, "CAN", "La cannibale",CategoriePizza.VIANDE, 12.50));
		listPizz.add(new Pizza(5, "SAV", "La savoyarde",CategoriePizza.VIANDE, 13.00));
		listPizz.add(new Pizza(6, "ORI", "L'orientale",CategoriePizza.VIANDE, 13.50));
		listPizz.add(new Pizza(7, "IND", "L'indienne",CategoriePizza.VIANDE, 14.00));
	}

	// getter
	public List<Pizza> findAllPizzas() {
		return listPizz;
	}

	// methode
	public void saveNewPizza(Pizza pizz) {
		listPizz.add(pizz);
	}

	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		if (this.pizzaExists(codePizza))
		{
			Pizza tmp = findPizzabyCode(codePizza);
			int i = listPizz.indexOf(tmp);
			listPizz.set(i, pizz);
		}
		else
		{
			throw new PizzaExistException("inconu au bataillon");
		}
	}

	public void deletePizza(String codePizza) throws PizzaExistException
	{
		if(this.pizzaExists(codePizza))
		{
			Pizza tmp = findPizzabyCode(codePizza);
			listPizz.remove(tmp);
		}
		else
		{
			throw new PizzaExistException("inconnu au bataillon");
		}
	}

	public Pizza findPizzabyCode(String codePizza)
	{
		for (Pizza p:listPizz)
		{
			if(codePizza.equals(p.getCode()) )
					return p;
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		for (Pizza p:listPizz)
		{
			if(codePizza.equals(p.getCode()) )
					return true;
		}
		return false;
	}

}
