package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class StringUtils
{
	public String genStringPizza(Object objet)
	{
		String sortie = "";

		@SuppressWarnings("rawtypes")
		Class struct = objet.getClass(); //recupera la structure de la classe
		Field[] attrib = struct.getDeclaredFields(); //recupere la liste des attribut de la classe
		for (Field a:attrib)
		{
			a.setAccessible(true); //pour forcer l'accessibilité : private a la base!!
			//Classe.class pour acceder a la structure de la classe. equivalent à getClass()
			if (a.isAnnotationPresent(ToString.class)) 
			{
				a.setAccessible(true);
				//cree une instance ToString, pour récupere ses attributs ligne suivante
				ToString annot = a.getAnnotation(ToString.class);
				boolean up = annot.upperCase(); //recupere la valeur de l'annotation
				String before = annot.before();
				String after = annot.after();
				
				if (up)
				{
					try
					{
						sortie += before + a.get(objet).toString().toUpperCase() + after;
					}
					catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
					catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				}
				else 
				{
					try
					{
						sortie += before + a.get(objet) + after;
					}
					catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
					catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		return sortie;
	}
}
