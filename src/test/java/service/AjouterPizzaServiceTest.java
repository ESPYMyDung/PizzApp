package service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import dao.IPizzaDao;
import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.SavePizzaException;

public class AjouterPizzaServiceTest
{
	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC() throws SavePizzaException
	{
		IPizzaDao testDao = Mockito.mock(IPizzaDao.class);
		//comme return void, on peut pas avoir mockito.when
		
		
		//faire le cas ou ça plante pour faire une levee d'exception
		
		//donner pour tester en fin
		Pizza p = new Pizza("CHE", "chevre_miel", CategoriePizza.SANS_VIANDE, 13.5);
		
		//donner d'entree utilisateur
		entree.provideLines("CHE", "chevre_miel", "SANS_VIANDE", "13.5");
		
		AjouterPizzaService ajout = new AjouterPizzaService();
		
		//enlever les try catch parce que y a pas de raison de planter.
		ajout.executeUC(new Scanner(System.in), testDao);	
		Mockito.verify(testDao).saveNewPizza(p);
	}

}
