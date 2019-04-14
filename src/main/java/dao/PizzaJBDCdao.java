package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exeption.PizzaExistException;


public class PizzaJBDCdao implements IPizzaDao 
{
	//attribut	
	public List<Pizza> listPizz = new ArrayList<>();
	private String url;
	private String user;
	private String pwd;
	
	//constructeur 
	public PizzaJBDCdao()  // il initialise aussi les variables privees
	{
		super();
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		this.url = bundle.getString("url");
		this.user = bundle.getString("user");
		this.pwd = bundle.getString("pass");
	}
	

	@Override
	public List<Pizza> findAllPizzas()
	{
		//() permet de gere la gestion des fermeture des divers objets
		try (
			Connection connect = DriverManager.getConnection(url,user,pwd);
			Statement requete = connect.createStatement();
			ResultSet execution = requete.executeQuery("select * from `pizza`");
			)
		{
			//int c = 0;
			listPizz.clear();
			
			//exploitation résultat
			while(execution.next())
			{
				String code = execution.getString("CODE");
				String nom = execution.getString("NOM");
				String cat = execution.getString("CATEGORIE");
				double prix = execution.getDouble("PRIX");

				Pizza pizz = new Pizza(code, nom, CategoriePizza.valueOf(cat), prix);
				listPizz.add(pizz);
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
					("INSERT INTO PIZZA (CODE,NOM,CATEGORIE,PRIX) VALUES (?,?,?,?)");
			nvPizz.setString(1, pizz.getCode());
			nvPizz.setString(2, pizz.getLibelle());
			nvPizz.setString(3,pizz.getCat().toString());
			nvPizz.setDouble(4, pizz.getPrix());
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
					("UPDATE PIZZA set CODE=?, NOM=?, CATEGORIE=?, PRIX=? WHERE CODE=? ");
			chgPizz.setString(1, pizz.getCode());
			chgPizz.setString(2, pizz.getLibelle());
			chgPizz.setString(3,pizz.getCat().toString());
			chgPizz.setDouble(4, pizz.getPrix());
			chgPizz.setString(5, codePizza);
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

}
