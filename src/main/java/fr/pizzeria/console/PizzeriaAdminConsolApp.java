package fr.pizzeria.console;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IPizzaDao;
import dao.PizzaJBDCdao;
import fr.pizzeria.exeption.DeletePizzaException;
import fr.pizzeria.exeption.SavePizzaException;
import fr.pizzeria.exeption.UpdatePizzaException;
import service.AjouterPizzaService;
import service.ListerPizzaService;
import service.ModifierPizzaService;
import service.SupprimmerPizzaService;
//import java.util.Arrays;

public class PizzeriaAdminConsolApp
{
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsolApp.class);

	public static void main(String[] args)
	{
		//LOG.info("for now");

		Scanner entreeUtilisateur = new Scanner(System.in);
		System.out.println("***** Pizzeria Administration *****");


		//liste originale de pizza
		//IPizzaDao objetDao = new PizzaMemDao();
		IPizzaDao objetDao = new PizzaJBDCdao();


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
				try
				{
					ajout.executeUC(entreeUtilisateur, objetDao);
				}
				catch (SavePizzaException e)
				{
					System.out.println(e.getMessage());
					LOG.error("une erreur est survenu", e);
				}
	
				break;

			//cas 3 : modif de pizza	
			case(3):
				System.out.println("Mise à jour d'une pizza");

				ListerPizzaService lis = new ListerPizzaService();
				lis.executeUC(entreeUtilisateur, objetDao);
	
				ModifierPizzaService modif = new ModifierPizzaService();
	
				try
				{
					modif.executeUC(entreeUtilisateur, objetDao);
				}
				catch (UpdatePizzaException e)
				{
					System.out.println(e.getMessage());
					LOG.error("une erreur est survenu", e);
				}
	
				break;

			//cas 4 : suppression de pizza
			case(4):
				SupprimmerPizzaService supress = new SupprimmerPizzaService();

				try
				{
					supress.executeUC(entreeUtilisateur, objetDao);
				}
				catch (DeletePizzaException e)
				{
					System.out.println(e.getMessage());
					LOG.error("une erreur est survenue", e);
				}
	
				break;
			}
		}


		//fin!!!
		System.out.println("Au revoir :(");
		entreeUtilisateur.close();


	}

}
