package service;

import java.util.Scanner;
import dao.*;
import fr.pizzeria.console.Pizza;

public class AjouterPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, PizzaMemDao objetDao)
	{
		System.out.println("Ajout d'une nouvelle pizza");
		Pizza pizz = new Pizza();
		
		//entree de l'utilisateur
		System.out.println("Veuillez saisir le code");
		pizz.setCode(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizz.setLibelle(entreeUtilisateur.nextLine());
		System.out.println("Veuillez saisir le prix");
		pizz.setPrix(entreeUtilisateur.nextLine());
		
		//initialisation de la nv pizza + ajustement taille du tableau pr l'ajouter
		objetDao.saveNewPizza(pizz);
	}
}