package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Valoracionmateria;

public class ValoracionMateriaController {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	/**
	 * Método para obtener un registro a partir de varias IDs
	 * @param idProfesor
	 * @param idEstudiante
	 * @param idMateria
	 * @return
	 */
	public static Valoracionmateria findByMultipleId(int idProfesor, int idEstudiante, int idMateria) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idProfesor = ?"
				+ " and idEstudiante = ? and idMateria = ?", Valoracionmateria.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idEstudiante);
		q.setParameter(3, idMateria);
		Valoracionmateria o;
		try  {
			o = (Valoracionmateria) q.getSingleResult();
		}
		catch (NoResultException e) {
			o = null;
		}
		em.close();
		return o;
	}
	
	/**
	 * Método para guardar un registro
	 */
	public static void save(Valoracionmateria o) {
		if (o.getId() == 0) {
			insert(o);
		}
		else {
			update(o);
		}
	}
	
	/**
	 * Método para insertar un registro
	 */
	private static void insert(Valoracionmateria o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para modificar un registro
	 */
	public static void update(Valoracionmateria o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}

}
