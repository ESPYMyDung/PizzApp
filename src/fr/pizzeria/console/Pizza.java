package fr.pizzeria.console;

public class Pizza
{
	public int id = 0;
	public String code;
	public String libelle;
	public double prix;
	
	//constructeur
	public Pizza(String code, String libelle, double prix)
	{
		id++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix)
	{
		this(code, libelle, prix);
		this.id = id;
	}

}
