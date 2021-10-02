package ma.mercureit.Recrute.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="RECRUTEUR")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Recruteur {
	 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	@ManyToOne
	private Departement departement;
	@ManyToMany(mappedBy="recruteurs", fetch = FetchType.EAGER)
	private Collection<Equipe> equipe = new ArrayList<> ();
	@OneToMany
	private Collection <Employe> employe;
}
