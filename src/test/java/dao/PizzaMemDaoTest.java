package dao;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

public class PizzaMemDaoTest
{

	@Test
	public void testFindAllPizza()
	{
		IPizzaDao test = new PizzaMemDao();
		Assert.assertNotNull(test.findAllPizzas().size());
		
	}
	
	@Test
	public void testSaveNewPizza()
	{
		IPizzaDao test = new PizzaMemDao();
		int t = test.findAllPizzas().size();
		test.saveNewPizza(new Pizza("VEG", "vegetarienne", CategoriePizza.SANS_VIANDE, 14));
		Assert.assertEquals(t+1, test.findAllPizzas().size());
		
		System.out.println(t + " " + test.findAllPizzas().size());
	}
	
	
	@Test
	public void testUpdatePizza()
	{
		PizzaMemDao test = new PizzaMemDao();	
		int t = test.findAllPizzas().size();
		try {
			test.updatePizza("REIN", new Pizza("ROY", "royale", CategoriePizza.VIANDE, 12.5));
			
			Assert.assertEquals(t, test.findAllPizzas().size());
			Assert.assertTrue(test.pizzaExists("ROY"));
		} catch (PizzaExistException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testDeletePizza()
	{
		IPizzaDao test = new PizzaMemDao();
		int t = test.findAllPizzas().size();
		try {
			test.deletePizza("FRO");
			
			Assert.assertEquals(t-1, test.findAllPizzas().size());
		} catch (PizzaExistException e) {
			e.printStackTrace();
		}
		
	}
	
}
