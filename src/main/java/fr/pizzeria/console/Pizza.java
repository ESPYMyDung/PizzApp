package fr.pizzeria.console;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.utils.Rule;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

@Entity
@Table
public class Pizza
{
	//attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	
	@Column(name="CODE")
	@ToString(upperCase = true, after = " -> ")
	private String code = null;
	
	@Column(name="NOM")
	@ToString
	private String libelle = null;
	
	@Column(name="CATEGORIE")
	@ToString(before = ", ", after = ",")
	@Enumerated(EnumType.STRING)
	private CategoriePizza cat;
	
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
	public Pizza(String code, String libelle, CategoriePizza cat, double prix)
	{
		this.setId(id++);
		this.code = code;
		this.libelle = libelle;
		this.setCat(cat);
		this.prix = prix;
	}
	
	/** constructeur pour crer un objet entier
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, CategoriePizza cat, double prix)
	{
		this(code, libelle, cat, prix);
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
	
	public void setCat(CategoriePizza cat) {
		this.cat = cat;
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
	
	public CategoriePizza getCat() {
		return cat;
	}
	
	public double getPrix()
	{
		return prix;
	}
	
	

}
