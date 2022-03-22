package service;

import java.util.List;

import javax.ejb.Local;

import Entity.User;
import Model.InscriptionInfo;


@Local
public interface UserService {
	public List<User> getUsers();
	
	public User getUser(Long cne) ;

	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void removeUser(Long cne);
	
}
