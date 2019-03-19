package fr.pizzeria.console;
import dao.*;

import java.util.Scanner;
//import java.util.Arrays;

public class PizzeriaAdminConsolApp
{
	
	public static void affichList(Pizza[] liste)
	{
		for(int i=0; i<liste.length; i++)
		{
			System.out.println(liste[i]);//liste[i].toString();	
		}

	}

	public static void main(String[] args)
	{
		Scanner entreeUtilisateur = new Scanner(System.in);
		System.out.println("***** Pizzeria Administration *****");
		
		/*
		//liste originale de pizza
		Pizza[] listPizz = new Pizza[8];
		listPizz[0] = new Pizza(0, "PEP", "P�p�roni", 12.50);
		listPizz[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listPizz[2] = new Pizza(2, "REIN", "La Reine",11.50);
		listPizz[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listPizz[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listPizz[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listPizz[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listPizz[7] = new Pizza(7, "IND", "L'indienne", 14.00);
		*/
		
		PizzaMemDao objetDao = new PizzaMemDao();
		Pizza[] listPizz  = objetDao.findAllPizzas();
		
		
		int choix = 0; // obligation de l'initialiser pour entrer dans le while
		
		while(choix!=99)
		{
			// menu afficher � chaqque fois
			System.out.println("***Menu***");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3.Mettre � jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99.Sortir");
			
			choix = entreeUtilisateur.nextInt();
			entreeUtilisateur.nextLine();
			Pizza pizz = new Pizza();
		
			switch(choix)
			{
			//cas 1 : liste de pizzas
				case(1): 
					System.out.println("Liste des pizzas");

					PizzeriaAdminConsolApp.affichList(listPizz);
					
					break;
			
			//cas 2 : ajout de pizza
				case(2):
					System.out.println("Ajout d'une nouvelle pizza");
				
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code");
					pizz.setCode(entreeUtilisateur.nextLine());
					System.out.println("Veuillez saisir le nom (sans espace)");
					pizz.setLibelle(entreeUtilisateur.nextLine());
					System.out.println("Veuillez saisir le prix");
					pizz.setPrix(entreeUtilisateur.nextLine());
					
					//initialisation de la nv pizza + ajustement taille du tableau pr l'ajouter
					/*listPizz = Arrays.copyOf(listPizz, listPizz.length+1);
					listPizz[listPizz.length-1] = pizz;*/
					objetDao.saveNewPizza(pizz);
					listPizz = objetDao.getDao();

					break;
					
			//cas 3 : modif de pizza	
				case(3):
					System.out.println("Mise � jour d'une pizza");

					PizzeriaAdminConsolApp.affichList(listPizz);
					
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code de la pizza � modifier");
					String ancCode = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le nouveau code");
					pizz.setCode(entreeUtilisateur.nextLine());
					System.out.println("Veuillez saisir le nouveau nom (sans espace)");
					pizz.setLibelle(entreeUtilisateur.nextLine());
					System.out.println("Veuillez saisir le nouveau prix");
					pizz.setPrix(entreeUtilisateur.nextLine());
					
					//parcour de la liste des pizzas pour trouver celle � modifier
					/*for(int i=0; i<listPizz.length; i++)
					{
						if(ancCode.equals(listPizz[i].getCode() ))
						{
							listPizz[i] = pizz;
						}
					}*/
					objetDao.updatePizza(ancCode, pizz);
					listPizz = objetDao.getDao();
					
					break;
			
			//cas 4 : suppression de pizza
				case(4):
					System.out.println("Suppression d'une pizza");
				
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code de la pizza � supprimer");
					String suprm = entreeUtilisateur.nextLine();
					
					//ajustement de la liste pour evitre les trous
					/*Pizza[] copie = listPizz.clone();
					int c = 0;
					listPizz = new Pizza[listPizz.length-1];
					for(int i=0; i<copie.length; i++)
					{
						if(!suprm.equals(copie[i].getCode() ))
						{
							listPizz[c] = copie[i];
							c++;
						}
					}*/
					objetDao.deletePizza(suprm);
					listPizz = objetDao.getDao();

					break;
			}
		}
		
		//fin!!!
		System.out.println("Au revoir :(");
		entreeUtilisateur.close();
		
		

	}

}
