package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class Validator
{
	public boolean valide(Object objet) throws IllegalArgumentException, IllegalAccessException
	{
		boolean sortie = true;
	
		@SuppressWarnings("rawtypes")
		Class struct = objet.getClass();
		Field[] attrib = struct.getDeclaredFields();
		for (Field a:attrib)
		{
			a.setAccessible(true);
			if (a.isAnnotationPresent(Rule.class)) 
			{
				a.setAccessible(true);
				Rule regle = a.getAnnotation(Rule.class);
				double max = regle.max(); //recupere la valeur de l'annotation
				double min = regle.min();
				
				System.out.println(a.getType());
				//if (a.get(objet)>max)
					//sortie = false;
				
				//if (a.get(objet)<min)
					//sortie = false;
				
			}
				
				
		}
		
		return sortie;
	}

}
