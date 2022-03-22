package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.Formation;
import Entity.Inscription;
import Entity.Salle;
import Entity.User;
import Model.InscriptionInfo;

@Stateless
public class InscriptionServiceImpl implements InscriptionService {
	
	@PersistenceContext
	private EntityManager em ;

	
	@Override
	public void createInscription(Long cne, String type) {
		User user = em.find(User.class, cne);
		
		Query query =  em.createQuery("select f from Formation as f where f.type =?" , Formation.class)
								.setParameter(1, type);
		
		Formation formation =  (Formation) query.getSingleResult();
		
		Inscription inscription = new Inscription();
		
		inscription.setDateCreation(new Date());
		
		inscription.setEtat(true);

		em.persist(inscription);
		
		inscription.setUser(user);
				
		inscription.setFormation(formation);
		
		em.persist(user);
		
		em.persist(formation);
		
		em.persist(inscription);
	}


	
	@Override
	public List<InscriptionInfo> getFilterInscriptionsInfo(Long cne) {
		List<Object[]> query = 
				em.createQuery("select u.cne , u.name , i.etat , s.numSalle , f.type , f.prix , i.id from User as u"
						+ " join u.inscriptions as i"
						+ " join i.formation as f"
						+ " join f.salle as s where u.cne = ?" )
				.setParameter(1, cne)
				.getResultList();
		
		List<InscriptionInfo> infos = new ArrayList<InscriptionInfo>();
		
		for(Object[] o : query) {
			InscriptionInfo inscription = new InscriptionInfo();
			inscription.setCne(String.valueOf(o[0]));
			inscription.setName(String.valueOf(o[1]));
			
			String etat = String.valueOf(o[2]);
			inscription.setEtat(Boolean.parseBoolean(etat));
			
			inscription.setNumSalle(Integer.parseInt(String.valueOf(o[3])));
			
			inscription.setType(String.valueOf(o[4]));
			
			inscription.setPrix(Double.parseDouble(String.valueOf(o[5])));
			
			inscription.setId(Long.parseLong(String.valueOf(o[6])));

			
			infos.add(inscription);
			
		}
		
		return infos;
		
	}

	
	@Override
	public List<InscriptionInfo> getInscriptionsInfo() {
		List<Object[]> query = 
				em.createQuery("select u.cne , u.name , i.etat , s.numSalle , f.type , f.prix , i.id from User as u"
						+ " join u.inscriptions as i"
						+ " join i.formation as f"
						+ " join f.salle as s" )
				.getResultList();
		
		List<InscriptionInfo> infos = new ArrayList<InscriptionInfo>();
		
		for(Object[] o : query) {
			InscriptionInfo inscription = new InscriptionInfo();
			inscription.setCne(String.valueOf(o[0]));
			inscription.setName(String.valueOf(o[1]));
			
			String etat = String.valueOf(o[2]);
			inscription.setEtat(Boolean.parseBoolean(etat));
			
			inscription.setNumSalle(Integer.parseInt(String.valueOf(o[3])));
			
			inscription.setType(String.valueOf(o[4]));
			
			inscription.setPrix(Double.parseDouble(String.valueOf(o[5])));
			
			inscription.setId(Long.parseLong(String.valueOf(o[6])));

			
			infos.add(inscription);
			
		}
		
		return infos;
	}

	@Override
	public void changeEtatInscription(Long id) {
		
		Inscription inscription = em.find(Inscription.class, id);
		
		if(inscription == null) throw new RuntimeException("inscription n'existe pas");
		
		inscription.setEtat(!inscription.getEtat());
		
		em.persist(inscription);
		
	}

	@Override
	public void removeInscription(Long id) {
		Inscription inscription = em.find(Inscription.class, id);
		
		if(inscription == null) throw new RuntimeException("inscription n'existe pas");
		
		em.remove(inscription);
	}

}
