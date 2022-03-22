package Entity;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long cne;
	
	private String name;
	private int age;
	private String email;
	
	
	@OneToMany(mappedBy="user")
	private Set<Inscription> inscriptions = new HashSet<>();
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public Long getCne() {
		return cne;
	}
	public void setCne(Long cne) {
		this.cne = cne;
	}
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

   
}
