package service;

import java.util.List;

import javax.ejb.Local;

import Entity.Salle;

@Local
public interface SalleService {

	public List<Salle> getAllSalles();
}
