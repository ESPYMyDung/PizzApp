package fr.pizzeria.console;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.utils.*;

@Entity
@Table
public class Pizza
{
	//attribut	
	private int id = 0;
	
	@Id
	@Column(name="CODE")
	@ToString(upperCase = true, after = " -> ")
	private String code = null;
	
	@Column(name="NOM")
	@ToString
	private String libelle = null;
	
	@Column(name="PRIX")
	@ToString (before = " (", after = "€)")
	@Rule
	private double prix = 0;
	
	//constructeur
	/**
	 * constructeur de base pour creer un objet vide
	 */
	public Pizza(){} 
	
	/**constructeur plus evoluer utiliser pour modifier des objet existants (principalement)
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix)
	{
		this.setId(id++);
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	/** constructeur pour crer un objet entier
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix)
	{
		this(code, libelle, prix);
		this.id = id;
	}
	
	//methode
	public String toString()
	{
		StringUtils tmp = new StringUtils();
		return tmp.genStringPizza(this);
	}
	
	// setter
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}
	
	public void setPrix(double p) //en théorie pas bien...
	{
		//double prix = Double.parseDouble(p);
		this.prix = p;
	}
	
	//getter
	public int getId()
	{
		return id;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String getLibelle()
	{
		return libelle;
	}
	
	public double getPrix()
	{
		return prix;
	}

}
