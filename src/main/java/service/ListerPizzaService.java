package service;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.console.Pizza;

public class ListerPizzaService extends MenuService
{
	public void executeUC(Scanner scanner, IPizzaDao objetDao)
	{
		for(Pizza p:objetDao.findAllPizzas())
		{
			System.out.println(p);
		}
	}
}
