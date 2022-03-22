package Entity;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Inscription
 *
 */
@Entity

public class Inscription implements Serializable {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="date_creation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	private boolean etat;
	
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Formation formation;
	
	
	private static final long serialVersionUID = 1L;

	public Inscription() {
		super();
	}   
	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}   
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}   
	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
   
}
