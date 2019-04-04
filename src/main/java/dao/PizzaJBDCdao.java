package dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class PizzaJBDCdao implements IPizzaDao 
{
	//attribut	
	public Pizza[] listPizz = new Pizza[10];; //public List<Pizza> listPizz = new ArrayList<>();
	private String url;
	private String user;
	private String pwd;
	
	//constructeur 
	// il initialise aussi les variables privees
	public PizzaJBDCdao()
	{
		super();
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		this.url = bundle.getString("url");
		this.user = bundle.getString("user");
		this.pwd = bundle.getString("pass");
	}
	

	@Override
	public Pizza[] findAllPizzas()
	{
		//() permet de gere la gestion des fermeture des divers objets
		try (
			Connection connect = DriverManager.getConnection(url,user,pwd);
			Statement requete = connect.createStatement();
			ResultSet execution = requete.executeQuery("select * from `pizza`");
			)
		{
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
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
				
		return listPizz;
	}

	@Override
	public void saveNewPizza(Pizza pizz)
	{
		
		try (Connection connect = DriverManager.getConnection(url,user,pwd);)
		{
			PreparedStatement nvPizz = connect.prepareStatement
					("INSERT INTO PIZZA (CODE,NOM,CATEGORIE,PRIX) VALUES (?,?,\"\",?)");
			nvPizz.setString(1, pizz.getCode());
			nvPizz.setString(2, pizz.getLibelle());
			nvPizz.setDouble(3, pizz.getPrix());
			nvPizz.executeUpdate();
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizz) throws PizzaExistException
	{
		try (Connection connect = DriverManager.getConnection(url,user,pwd);)
		{
			PreparedStatement chgPizz = connect.prepareStatement
					("UPDATE PIZZA set CODE=?, NOM=?, PRIX=? WHERE CODE=? ");
			chgPizz.setString(1, pizz.getCode());
			chgPizz.setString(2, pizz.getLibelle());
			chgPizz.setDouble(3, pizz.getPrix());
			chgPizz.setString(4, codePizza);
			chgPizz.executeUpdate();
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaExistException
	{
		try (Connection connect = DriverManager.getConnection(url,user,pwd);)
		{
			PreparedStatement suprPizz = connect.prepareStatement
					("DELETE FROM PIZZA WHERE CODE=?");
			suprPizz.setString(1, codePizza);
			suprPizz.executeUpdate();
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
/*
	@Override
	public Pizza findPizzabyCode(String codePizza)
	{
		try (Connection connect = DriverManager.getConnection(url,user,pwd);)
		{
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
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		try (Connection connect = DriverManager.getConnection(url,user,pwd);)
		{
		PreparedStatement trvPizz = connect.prepareStatement
				("select * from `pizza` where CODE=?");
		trvPizz.setString(1, codePizza);
		
		ResultSet execution = trvPizz.executeQuery();

		return execution.next();

		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return false;
	}*/

	//setter
	/*private void setProp()
	{
		InputStream tmp = getClass().getClassLoader().getResourceAsStream("jbdc.properties");
		Properties prop = new Properties();
		try
		{
			prop.load(tmp);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pass");
		}
		catch (IOException e1)
		{
			System.out.println(e1.getMessage());
		}
	}*/

}
