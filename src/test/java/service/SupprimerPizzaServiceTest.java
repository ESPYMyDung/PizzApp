package service;

//import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import dao.IPizzaDao;
import fr.pizzeria.exeption.DeletePizzaException;
import fr.pizzeria.exeption.PizzaExistException;

public class SupprimerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC() throws DeletePizzaException, PizzaExistException
	{
		IPizzaDao testDao = Mockito.mock(IPizzaDao.class);
		//comme return void, on peut pas avoir mockito.when

		//faire le cas ou ça plante pour faire une levee d'exception

		
		entree.provideLines("FRO");
		
		SupprimerPizzaService supr = new SupprimerPizzaService();

		supr.executeUC(new Scanner(System.in), testDao);
		Mockito.verify(testDao).deletePizza("FRO");
	}

}
