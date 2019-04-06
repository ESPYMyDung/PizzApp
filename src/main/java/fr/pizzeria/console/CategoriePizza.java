package fr.pizzeria.console;

public enum CategoriePizza
{
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Vegetarien");
	
	private String nom;
	
	private CategoriePizza(String nom)
	{
		this.setNom(nom);
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
