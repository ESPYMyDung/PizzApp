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
import fr.pizzeria.exeption.PizzaExistException;
import fr.pizzeria.exeption.UpdatePizzaException;

public class ModifierPizzaServiceTest
{

	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC() throws UpdatePizzaException, PizzaExistException
	{
		IPizzaDao testDao = Mockito.mock(IPizzaDao.class);
		//comme return void, on peut pas avoir mockito.when
		
		
		//faire le cas ou ça plante pour faire une levee d'exception
		
		//donner pour tester en fin
		Pizza p = new Pizza("ROY", "royale", CategoriePizza.VIANDE, 12.5);
		
		//donner d'entree utilisateur
		entree.provideLines("REIN","ROY", "royale", "VIANDE", "12.5");

		ModifierPizzaService modif = new ModifierPizzaService();
		modif.executeUC(new Scanner(System.in), testDao);
		Mockito.verify(testDao).updatePizza("REIN", p);

	}

}
