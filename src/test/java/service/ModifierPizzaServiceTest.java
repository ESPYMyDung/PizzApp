package service;

//import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exeption.UpdatePizzaException;

public class ModifierPizzaServiceTest
{

	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC()
	{
		entree.provideLines("REIN","ROY", "royale", "VIANDE", "12.5");
		
		
		IPizzaDao objetDao = new PizzaMemDao();
		ModifierPizzaService modif = new ModifierPizzaService();
		try {
		modif.executeUC(new Scanner(System.in), objetDao);
		} catch (UpdatePizzaException e) {
			e.printStackTrace();
		}
	}

}
