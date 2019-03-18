package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsolApp
{

	public static void main(String[] args)
	{
		Scanner entreeUtilisateur = new Scanner(System.in);
		System.out.println("***** Pizzeria Administration *****");
		
		
		int choix = 0;
		
		while(choix!=99)
		{
			
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3.Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99.Sortir");
			
			choix = entreeUtilisateur.nextInt();
		
			switch(choix)
			{
				case(1):
					System.out.println("Liste des pizzas");
					break;
				case(2):
					System.out.println("Ajout d'une nouvelle pizza");
					break;
				case(3):
					System.out.println("Mise à jour d'une pizza");
					break;
				case(4):
					System.out.println("Suppression d'une pizza");
					break;
			}
		}
		
		System.out.println("Au revoir \uf641");
		
		
		

	}

}
