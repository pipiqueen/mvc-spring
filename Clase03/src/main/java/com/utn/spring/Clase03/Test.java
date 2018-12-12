package com.utn.spring.Clase03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.utn.spring.beans.Persona;
import com.utn.spring.dao.PersonaDAO;
import com.utn.spring.dao.PersonaDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		Persona persona;
		int id = 3;
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/utn/spring/xml/beans.xml");
		
		PersonaDAO personaDao = (PersonaDAO) appContext.getBean("personaDAOImpl");
		
//		PersonaDAOImpl perosnaDAOImpl = new PersonaDAOImpl();
//		persona = perosnaDAOImpl.busacarPersona(id);
//		
//		System.out.println("Datos de la persona id: " +id);
//		System.out.println("Nombre: " +persona.getNombre());
//		System.out.println("DNI: " +persona.getDni());
		
		
		System.out.println("Cantidad de Personas: " +personaDao.cantidadPersonas() +"\n");
		
		System.out.println("Los datos de la persona con ID = " +id +" es : " +""
						+  personaDao.buscarNombre(id) +"\n");
		
		Persona p1 = personaDao.busacarPersona(id);
		
		System.out.println("La persona buscada con id= " +id +" es: \n" +""
						+  "Nombre: " +p1.getNombre() +"\n"
						+  "ID: " +p1.getId() +"\n"
						+  "DNI: " +p1.getDni() +"\n");
		
		List<Persona> listaPersonas = personaDao.buscarPersonas();
		
		System.out.println("Imprimimos los nombres de las personas en la lista 'lisaPersonas'\n");
		
		for (Persona persona2 : listaPersonas) {
			System.out.println("NOMBRE: " +persona2.getNombre());
			
		}
		
		personaDao.insertarPersona(new Persona (0, 678 , "Peron"));
		
	}
	
	

}
