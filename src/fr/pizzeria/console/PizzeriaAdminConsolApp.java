package fr.pizzeria.console;

import java.util.Scanner;
import java.util.Arrays;

public class PizzeriaAdminConsolApp
{

	public static void main(String[] args)
	{
		Scanner entreeUtilisateur = new Scanner(System.in);
		System.out.println("***** Pizzeria Administration *****");
		
		//liste originale de pizza
		Pizza[] listPizz = new Pizza[8];
		listPizz[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		listPizz[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listPizz[2] = new Pizza(2, "REIN", "La Reine",11.50);
		listPizz[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listPizz[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listPizz[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listPizz[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listPizz[7] = new Pizza(7, "IND", "L'indienne", 14.00);
		
		int choix = 0; // obligation de l'initialiser pur entrer dans le while
		
		while(choix!=99)
		{
			// menu afficher à chaqque fois
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
					System.out.println("Liste des pizzas");
					//boucle pour afficher la liste des pizzas
					for(int i=0; i<listPizz.length; i++)
					{
						Pizza.affichage(listPizz[i]);	
					}
					
					break;
			
			//cas 2 : ajout de pizza
				case(2):
					System.out.println("Ajout d'une nouvelle pizza");
				
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code");
					String code = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le nom (sans espace)");
					String nom = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le prix");
					String p = entreeUtilisateur.nextLine();
					double prix = Double.parseDouble(p);
					
					//initialisation de la nv pizza + ajusteent de la taille du tableau pr l'ajouter
					Pizza pizz = new Pizza(code,nom,prix);
					listPizz = Arrays.copyOf(listPizz, listPizz.length+1);
					listPizz[listPizz.length-1] = pizz;

					break;
					
			//cas 3 : modif de pizza	
				case(3):
					System.out.println("Mise à jour d'une pizza");
				
				//boucle pour afficher la liste des pizzas
					for(int i=0; i<listPizz.length; i++)
					{
						Pizza.affichage(listPizz[i]);	
					}
					
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code de la pizza à modifier");
					String ancCode = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le nouveau code");
					String nvCode = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le nouveau nom (sans espace)");
					String nvNom = entreeUtilisateur.nextLine();
					System.out.println("Veuillez saisir le nouveau prix");
					String nvP = entreeUtilisateur.nextLine();
					double nvPrix = Double.parseDouble(nvP);
					
					//parcour de la liste des pizzas pour trouver celle à modifier
					for(int i=0; i<listPizz.length; i++)
					{
						if(ancCode.equals(listPizz[i].code))
						{
							listPizz[i] = new Pizza(nvCode, nvNom, nvPrix);
						}
					}
					
					break;
			
			//cas 4 : suppression de pizza
				case(4):
					System.out.println("Suppression d'une pizza");
				
					//entree de l'utilisateur
					System.out.println("Veuillez saisir le code de la pizza à supprimer");
					String suprm = entreeUtilisateur.nextLine();
					
					//ajustement de la liste pour evitre les trous
					Pizza[] copie = listPizz.clone();
					int c = 0;
					listPizz = new Pizza[listPizz.length-1];
					for(int i=0; i<copie.length; i++)
					{
						System.out.println(copie[i].code);
						System.out.println(suprm);
						if(!suprm.equals(copie[i].code))
						{
							System.out.println(c + " " + i);
							listPizz[c] = copie[i];
							c++;
						}
					}

					break;
			}
		}
		
		//fin!!!
		System.out.println("Au revoir :(");
		entreeUtilisateur.close();
		
		

	}

}
