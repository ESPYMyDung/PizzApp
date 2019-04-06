package service;

import java.util.Scanner;

import dao.*;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.SavePizzaException;

public class AjouterPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, IPizzaDao objetDao) throws SavePizzaException
	{
		System.out.println("Ajout d'une nouvelle pizza");
		Pizza pizz = new Pizza();
		
		//entree de l'utilisateur
		System.out.println("Veuillez saisir le code");
		pizz.setCode(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizz.setLibelle(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le prix");
		pizz.setPrix(Double.parseDouble(entreeUtilisateur.nextLine()));
		
		if (pizz.getPrix()<0)
		{
			throw new SavePizzaException("prix negatif, vous aller vous ruiner!!");
		}
		
		if (pizz.getCode().length()<3)
		{
			throw new SavePizzaException("code trop court");
		}
		
		//initialisation de la nv pizza + ajustement taille du tableau pr l'ajouter
		objetDao.saveNewPizza(pizz);
	}
}