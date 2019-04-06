package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		travail.persist(pizz);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		Pizza p = travail.find(Pizza.class,codePizza);
		//null?
		p.setCode(pizz.getCode());
		p.setLibelle(pizz.getLibelle());
		p.setPrix(pizz.getPrix());
		
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaExistException
	{
		Pizza p = travail.find(Pizza.class, codePizza);
		//null
		travail.remove(p);
		
	}
	
	public void fermeture()
	{
		travail.close();
    	factory.close();
	}


}
