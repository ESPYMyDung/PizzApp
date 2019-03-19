package service;

import java.util.Scanner;

import dao.PizzaMemDao;

public class SupprimmerPizzaService extends MenuService
{
	public void executeUC(Scanner entreeUtilisateur, PizzaMemDao objetDao)
	{
		System.out.println("Suppression d'une pizza");
		
		//entree de l'utilisateur
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String suprm = entreeUtilisateur.nextLine();
		
		//ajustement de la liste pour evitre les trous
		objetDao.deletePizza(suprm);
	}
}
