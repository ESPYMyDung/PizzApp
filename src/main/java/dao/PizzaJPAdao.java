package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

public class PizzaJPAdao implements IPizzaDao
{
	
	//creer un EntityManagerFactory
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("PizzApp");	
	//creer une unite de travail
	private EntityManager travail = factory.createEntityManager();


	@Override
	public List<Pizza> findAllPizzas()
	{
    	TypedQuery<Pizza> requete = travail.createQuery(
    			"select p from Pizza p ", Pizza.class);
    	
    	List<Pizza> listePizz = requete.getResultList();
		

		return listePizz;
	}

	@Override
	public void saveNewPizza(Pizza pizz)
	{
		EntityTransaction transaction = travail.getTransaction();
    	transaction.begin();
		
		travail.persist(pizz);
		
		transaction.commit();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		EntityTransaction transaction = travail.getTransaction();
    	transaction.begin();
    	
    	TypedQuery<Pizza> requete = travail.createQuery(
    			"select p from Pizza p where CODE=:ref", Pizza.class);
    	requete.setParameter("ref", codePizza);
    	
    	List<Pizza> listePizz = requete.getResultList();
		
		Pizza p = travail.find(Pizza.class,listePizz.get(0).getId());
		//null?
		p.setCode(pizz.getCode());
		p.setLibelle(pizz.getLibelle());
		p.setPrix(pizz.getPrix());
		
		transaction.commit();
		
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaExistException
	{
		EntityTransaction transaction = travail.getTransaction();
    	transaction.begin();
		
		TypedQuery<Pizza> requete = travail.createQuery(
    			"select p from Pizza p where CODE=:ref", Pizza.class);
    	requete.setParameter("ref", codePizza);
    	
    	List<Pizza> listePizz = requete.getResultList();
    	
		Pizza p = travail.find(Pizza.class, listePizz.get(0).getId());
		//null
		travail.remove(p);
		
		transaction.commit();
		
	}
	
	public void fermeture()
	{
		travail.close();
    	factory.close();
	}


}

/* si jamais on a beson de réinitialiser la bdd
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("PEP","VIANDE", "Pépéronie",  12.50);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("MAR","SANS_VIANDE", "Margherita", 14.00);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("REIN","VIANDE", "La Reine", 11.50);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("FRO","VIANDE", "La 4 fromages", 12.00);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("CAN","VIANDE", "La cannibale", 12.50);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("SAV","VIANDE", "La savoyarde", 13.00);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("ORI","VIANDE", "L'orientale", 13.50);
INSERT INTO `pizza`(`CODE`, `CATEGORIE`, `NOM`, `PRIX`) VALUES ("IND","VIANDE", "L'indienne", 14.00);
*/
