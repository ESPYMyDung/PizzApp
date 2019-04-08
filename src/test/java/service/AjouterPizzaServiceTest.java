package service;

//import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exeption.SavePizzaException;

public class AjouterPizzaServiceTest
{
	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC()
	{
		entree.provideLines("CHE", "chevre_miel", "SANS_VIANDE", "13.5");
		
		
		IPizzaDao objetDao = new PizzaMemDao();
		AjouterPizzaService ajout = new AjouterPizzaService();
		try {
			ajout.executeUC(new Scanner(System.in), objetDao);
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
