package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formation
 *
 */
@Entity
public class Formation implements Serializable {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private double prix;
	
	@Column(unique = true)
	private String type;
	
	@OneToMany(mappedBy="formation")
	private Set<Inscription> inscriptions = new HashSet<>();
	
	
	@ManyToOne
	private Salle salle;
	
	
	private static final long serialVersionUID = 1L;

	public Formation() {
		super();
	}   
	
	
	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
