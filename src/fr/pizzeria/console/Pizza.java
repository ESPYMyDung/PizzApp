package fr.pizzeria.console;

public class Pizza
{
	//attribut
	private int id = 0;
	private String code = null;
	private String libelle = null;
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
		String sortie = this.getCode() + " -> " + this.getLibelle() + " (" + this.getPrix() + " €)";	
		System.out.println(sortie);
		return sortie;
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
	
	public void setPrix(String p) //en théorie pas bien...
	{
		double prix = Double.parseDouble(p);
		this.prix = prix;
	}
	
	//getter
	public int getId(int id)
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
