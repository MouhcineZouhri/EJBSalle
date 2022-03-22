package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import Entity.Inscription;
import Entity.User;



@Stateless
public class UserServiceImpl implements UserService{
	
	@PersistenceContext
	private EntityManager em;


	
	@Override
	public List<User> getUsers() {
		Query query = em.createQuery("select u from User as u" , User.class);
		
		List<User> users = query.getResultList();
		
		return users;
	}

	
	@Override
	public User getUser(Long cne)   {	
		User user = em.find(User.class, cne);
	
		return user;
	}

	@Override
	public void removeUser(Long cne) {
		
		User user = em.find(User.class, cne);
		
		if(user == null) {
			
		}else {
			Query query = 
					em.createQuery("select i from User as u join u.inscriptions as i where u.cne = ?" , Inscription.class)
					.setParameter(1, user.getCne());
			
			List<Inscription> inscriptions =  query.getResultList();
			
			for(Inscription inscription : inscriptions) {
				em.remove(inscription);
			}
			
			em.remove(user);
		}		
		
	}


	@Override
	public User updateUser(User user) {
		User dbUser = em.find(User.class, user.getCne());
		
		if(user.getEmail() != null) dbUser.setEmail(user.getEmail());
		
		if(user.getName() != null) dbUser.setName(user.getName());
		
		if(user.getAge() != 0) dbUser.setAge(user.getAge());
		
		em.persist(dbUser);
		
		return dbUser;
	}


	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	

}
