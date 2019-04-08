package service;

//import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import dao.IPizzaDao;
import dao.PizzaMemDao;

public class ListerPizzaServiceTest
{
	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC()
	{
		entree.provideLines("1");
		
		
		IPizzaDao objetDao = new PizzaMemDao();
		ListerPizzaService lister = new ListerPizzaService();
		lister.executeUC(new Scanner(System.in), objetDao);
	}

}
