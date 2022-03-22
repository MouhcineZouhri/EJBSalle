package Model;

import java.util.Date;

public class InscriptionInfo {
	private Long id;
	private String cne;
	private String name;
	private boolean etat;
	private int numSalle;
	private String type;
	private double prix;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
