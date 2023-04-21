package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;

public class MateriaController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	
	/** 
	 * Método para obtener todos los registros
	 */
	public static List<Materia> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Materia.findAll");
		List<Materia> l = (List<Materia>) q.getResultList();
		em.close();
		return l;
	}
	
}
