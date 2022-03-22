package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.Salle;

@Stateless
public class SalleServiceImpl implements SalleService {

	@PersistenceContext
	private EntityManager em ;
	
	@Override
	public List<Salle> getAllSalles() {
		Query query =  em.createQuery("select s from Salle as s" ,Salle.class);
		
		List<Salle> salles =  query.getResultList();
		
		return salles;
		
	}

}
