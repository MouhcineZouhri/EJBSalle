package Entity;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salle
 *
 */
@Entity
public class Salle implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num")
	private int numSalle;
	
	private String ville;
	
	
	@OneToMany(mappedBy="salle")
	private Set<Formation> formations = new HashSet<>();
	
	private static final long serialVersionUID = 1L;

	public Salle() {
		super();
	}   
	public int getNumSalle() {
		return this.numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}   
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
   
}
