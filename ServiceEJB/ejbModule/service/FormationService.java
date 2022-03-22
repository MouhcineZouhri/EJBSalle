package service;

import java.util.List;

import javax.ejb.Local;

import Entity.Formation;

@Local
public interface FormationService {
	public List<Formation> getAllForamtions();
	
}
