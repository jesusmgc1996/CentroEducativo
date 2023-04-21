package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;

public class EstudianteController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	/** 
	 * Método para obtener todos los registros
	 */
	public static List<Estudiante> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNamedQuery("Estudiante.findAll");
		List<Estudiante> l = (List<Estudiante>) q.getResultList();
		em.close();
		return l;
	}

}
