package service;

import java.util.Scanner;
import fr.pizzeria.exeption.*;
import dao.IPizzaDao;


public class SupprimmerPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, IPizzaDao objetDao)  throws DeletePizzaException
	{
		System.out.println("Suppression d'une pizza");
		
		//entree de l'utilisateur
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String suprm = entreeUtilisateur.nextLine();
		
		/*
		if (pizz.getPrix()<0)
		{
			throw new DeletePizzaException("prix negatif, vous aller vous ruiner!!");
		}
		*/
		
		if (suprm.length()<3)
		{
			throw new DeletePizzaException("code trop court");
		}
		
		//ajustement de la liste pour evitre les trous
		try
		{
			objetDao.deletePizza(suprm);
		}
		catch (PizzaExistException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
