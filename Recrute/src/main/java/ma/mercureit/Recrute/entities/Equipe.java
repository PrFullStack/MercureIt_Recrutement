package ma.mercureit.Recrute.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="EQUIPE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Equipe {
	 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nom;
	@ManyToMany( fetch = FetchType.EAGER)
	private Collection<Recruteur> recruteurs = new ArrayList<> ();//
	@OneToMany
	private Collection<Poste> postes;
}
