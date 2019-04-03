package service;

import java.util.Scanner;
import dao.*;

public abstract class MenuService
{
	public abstract void executeUC(Scanner scanner, IPizzaDao objetDao) throws Exception;
	
}
