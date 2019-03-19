package service;

import java.util.Scanner;

import dao.PizzaMemDao;
import fr.pizzeria.console.Pizza;

public class ModifierPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, PizzaMemDao objetDao)
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
		pizz.setPrix(entreeUtilisateur.nextLine());
		
		//parcour de la liste des pizzas pour trouver celle à modifier
		objetDao.updatePizza(ancCode, pizz);
	}
}
