package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;

public class ProfesorController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	/** 
	 * Método para obtener todos los registros
	 */
	public static List<Profesor> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Profesor.findAll");
		List<Profesor> l = (List<Profesor>) q.getResultList();
		em.close();
		return l;
	}

}
