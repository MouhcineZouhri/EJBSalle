package service;

import java.util.List;

import javax.ejb.Local;

import Model.InscriptionInfo;

@Local
public interface InscriptionService {
	
	public List<InscriptionInfo> getInscriptionsInfo();
	
	public List<InscriptionInfo> getFilterInscriptionsInfo(Long cne);

	public void changeEtatInscription(Long id);
	
	public void removeInscription(Long id);
	
	public void createInscription(Long cne, String type);
	
}
