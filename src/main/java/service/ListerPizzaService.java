package service;

import java.util.Scanner;
import dao.*;

public class ListerPizzaService extends MenuService
{
	public void executeUC(Scanner scanner, IPizzaDao objetDao)
	{
		for(int i=0; i<objetDao.findAllPizzas().length; i++)
		{
			System.out.println(objetDao.findAllPizzas()[i]);
		}
	}
}
