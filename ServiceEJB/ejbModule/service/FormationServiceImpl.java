package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.Formation;

@Stateless
public class FormationServiceImpl implements FormationService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Formation> getAllForamtions() {
		Query query =  em.createQuery("select f from Formation as f" ,Formation.class);
		
		List<Formation> formations =  query.getResultList();
		
		return formations;
	}
	
	
	

}

