package service;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;
import fr.pizzeria.exeption.UpdatePizzaException;

public class ModifierPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, IPizzaDao objetDao) throws UpdatePizzaException
	{
		Pizza pizz = new Pizza();
		
		//entree de l'utilisateur
		System.out.println("Veuillez saisir le code de la pizza à modifier");
		String ancCode = entreeUtilisateur.nextLine();
		System.out.println("Veuillez saisir le nouveau code");
		pizz.setCode(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		pizz.setLibelle(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le nouveau prix");
		pizz.setPrix(Double.parseDouble(entreeUtilisateur.nextLine()));
		
		if (pizz.getPrix()<0)
		{
			throw new UpdatePizzaException("prix negatif, vous aller vous ruiner!!");
		}
		
		if (pizz.getCode().length()<3)
		{
			throw new UpdatePizzaException("code trop court");
		}
		
		//parcour de la liste des pizzas pour trouver celle à modifier
		try
		{
			objetDao.updatePizza(ancCode, pizz);
		}
		catch (PizzaExistException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
}
