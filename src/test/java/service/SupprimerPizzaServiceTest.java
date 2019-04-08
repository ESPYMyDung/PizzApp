package service;

//import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exeption.DeletePizzaException;

public class SupprimerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC()
	{
		entree.provideLines("FRO");
		
		
		IPizzaDao objetDao = new PizzaMemDao();
		SupprimmerPizzaService supr = new SupprimmerPizzaService();
		try {
			supr.executeUC(new Scanner(System.in), objetDao);
		} catch (DeletePizzaException e) {
			e.printStackTrace();
		}
	}

}
