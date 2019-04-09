package service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import dao.IPizzaDao;

public class ListerPizzaServiceTest
{
	@Rule
	public TextFromStandardInputStream entree = emptyStandardInputStream();

	@Test
	public void testExecuteUC()
	{
		
		IPizzaDao testDao = Mockito.mock(IPizzaDao.class);
		entree.provideLines("1"); // utilité de cette ligne ???

		ListerPizzaService lister = new ListerPizzaService();
		lister.executeUC(new Scanner(System.in), testDao);
		
		Mockito.verify(testDao).findAllPizzas();
	}

}
