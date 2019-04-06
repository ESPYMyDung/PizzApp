package service;

import java.util.Scanner;
import dao.*;
import fr.pizzeria.console.Pizza;

public class ListerPizzaService extends MenuService
{
	public void executeUC(Scanner scanner, IPizzaDao objetDao)
	{
		for(Pizza p:objetDao.findAllPizzas()) //int i=0; i<objetDao.findAllPizzas().size(); i++
		{
			System.out.println(p);
		}
	}
}
