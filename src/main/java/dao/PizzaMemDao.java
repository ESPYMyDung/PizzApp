package dao;

import java.util.Arrays;

import fr.pizzeria.console.*;
import fr.pizzeria.exeption.PizzaExistException;

public class PizzaMemDao implements IPizzaDao {
	// attributs
	public Pizza[] listPizz;

	// constructeur
	public PizzaMemDao() {
		this.listPizz = new Pizza[8];
		listPizz[0] = new Pizza(0, "PEP", "P�p�roni", 12.50);
		listPizz[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listPizz[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		listPizz[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listPizz[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listPizz[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listPizz[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listPizz[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}

	// getter
	public Pizza[] findAllPizzas() {
		return listPizz;
	}

	// methode
	public void saveNewPizza(Pizza pizz) {
		pizz.setId(listPizz.length);
		listPizz = Arrays.copyOf(listPizz, listPizz.length + 1);
		listPizz[listPizz.length - 1] = pizz;
	}

	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		if (this.pizzaExists(codePizza))
		{
			Pizza tmp = findPizzabyCode(codePizza);
			int c = tmp.getId();
			listPizz[c] = pizz;
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
			Pizza[] copie = listPizz.clone();
			int c = 0;
			listPizz = new Pizza[listPizz.length-1];
			for(int i=0; i<copie.length; i++)
			{
				if(!codePizza.equals(copie[i].getCode() ))
				{
					listPizz[c] = copie[i];
					listPizz[c].setId(c);
					c++;
				}
			}
		}
		else
		{
			throw new PizzaExistException("inconnu au bataillon");
		}
	}

	public Pizza findPizzabyCode(String codePizza) {
		for (int i = 0; i < listPizz.length; i++) {
			if (codePizza.equals(listPizz[i].getCode())) {
				return listPizz[i];
			}
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		for (int i = 0; i < listPizz.length; i++) {
			if (codePizza.equals(listPizz[i].getCode())) {
				return true;
			}
		}
		return false;
	}

}