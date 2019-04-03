package dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PizzaJBDCdao implements IPizzaDao 
{
	//attribut	
	public Pizza[] listPizz = new Pizza[10];; //public List<Pizza> listPizz = new ArrayList<>();
		
	/*private void ouvertureConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bdd_pizzeria";
			Connection connect = DriverManager.getConnection(url,"root", "");
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		finally
		{
			execution.close();
			requete.close();
			connect.close();
		}
	}*/

	@Override
	public Pizza[] findAllPizzas()
	{
		//ouvertureConnect()
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bdd_pizzeria";
			Connection connect = DriverManager.getConnection(url,"root", "");
			
			Statement requete = connect.createStatement();
			ResultSet execution = requete.executeQuery("select * from `pizza`");
			int c = 0;
			
			//exploitation résultat
			while(execution.next())
			{
				String code = execution.getString("CODE");
				String nom = execution.getString("NOM");
				double prix = execution.getDouble("PRIX");

				Pizza pizz = new Pizza(code, nom, prix);
				listPizz[c] = pizz; c++;
			}

		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
				
		return listPizz;
	}

	@Override
	public void saveNewPizza(Pizza pizz)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bdd_pizzeria";
			Connection connect = DriverManager.getConnection(url,"root", "");
			
			PreparedStatement nvPizz = connect.prepareStatement
					("INSERT INTO PIZZA (CODE,NOM,CATEGORIE,PRIX) VALUES (?,?,\"\",?)");
			nvPizz.setString(1, pizz.getCode());
			nvPizz.setString(2, pizz.getLibelle());
			nvPizz.setDouble(3, pizz.getPrix());
			nvPizz.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bdd_pizzeria";
			Connection connect = DriverManager.getConnection(url,"root", "");
			
			PreparedStatement chgPizz = connect.prepareStatement
					("UPDATE PIZZA set CODE=?, NOM=?, PRIX=? WHERE CODE=? ");
			chgPizz.setString(1, pizz.getCode());
			chgPizz.setString(2, pizz.getLibelle());
			chgPizz.setDouble(3, pizz.getPrix());
			chgPizz.setString(4, codePizza);
			chgPizz.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaExistException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bdd_pizzeria";
			Connection connect = DriverManager.getConnection(url,"root", "");
			
			PreparedStatement suprPizz = connect.prepareStatement
					("DELETE FROM PIZZA WHERE CODE=?");
			suprPizz.setString(1, codePizza);
			suprPizz.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		
	}

	@Override
	public Pizza findPizzabyCode(String codePizza)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/bdd_pizzeria";
		Connection connect = DriverManager.getConnection(url,"root", "");
		
		PreparedStatement trvPizz = connect.prepareStatement
				("select * from `pizza` where CODE=?");
		trvPizz.setString(1, codePizza);
		
		ResultSet execution = trvPizz.executeQuery();
		
		//exploitation résultat
		String code = execution.getString("CODE");
		String nom = execution.getString("NOM");
		double prix = execution.getDouble("PRIX");
		
		Pizza pizz = new Pizza(code, nom, prix);
		return pizz;

		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/bdd_pizzeria";
		Connection connect = DriverManager.getConnection(url,"root", "");
		
		//Statement requete = connect.createStatement();
		PreparedStatement trvPizz = connect.prepareStatement
				("select * from `pizza` where CODE=?");
		trvPizz.setString(1, codePizza);
		
		ResultSet execution = trvPizz.executeQuery();

		return execution.next();

		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		} 
		catch (SQLException e) 
		{
			e.getMessage();
		}
		return false;
	}

}
