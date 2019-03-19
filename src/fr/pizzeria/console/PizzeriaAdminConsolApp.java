package fr.pizzeria.console;
import dao.*;
import service.*;

import java.util.Scanner;
//import java.util.Arrays;

public class PizzeriaAdminConsolApp
{

	public static void main(String[] args)
	{
		Scanner entreeUtilisateur = new Scanner(System.in);
		System.out.println("***** Pizzeria Administration *****");
		
		//liste originale de pizza
		PizzaMemDao objetDao = new PizzaMemDao();
		
		int choix = 0; // obligation de l'initialiser pour entrer dans le while
		
		while(choix!=99)
		{
			// menu afficher à chaque fois
			System.out.println("***Menu***");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3.Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99.Sortir");
			
			choix = entreeUtilisateur.nextInt();
			entreeUtilisateur.nextLine();
		
			switch(choix)
			{
			//cas 1 : liste de pizzas
				case(1): 
					ListerPizzaService lister = new ListerPizzaService();
					lister.executeUC(entreeUtilisateur, objetDao);
					
					break;
			
			//cas 2 : ajout de pizza
				case(2):
					AjouterPizzaService ajout = new AjouterPizzaService();
					ajout.executeUC(entreeUtilisateur, objetDao);

					break;
					
			//cas 3 : modif de pizza	
				case(3):
					System.out.println("Mise à jour d'une pizza");
					
					ListerPizzaService lis = new ListerPizzaService();
					lis.executeUC(entreeUtilisateur, objetDao);
				
					ModifierPizzaService modif = new ModifierPizzaService();
					modif.executeUC(entreeUtilisateur, objetDao);
					
					break;
			
			//cas 4 : suppression de pizza
				case(4):
					SupprimmerPizzaService supress = new SupprimmerPizzaService();
					supress.executeUC(entreeUtilisateur, objetDao);

					break;
			}
		}
		
		//fin!!!
		System.out.println("Au revoir :(");
		entreeUtilisateur.close();
		
		

	}

}
