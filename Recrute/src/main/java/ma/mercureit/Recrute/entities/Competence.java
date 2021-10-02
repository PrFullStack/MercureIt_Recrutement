package ma.mercureit.Recrute.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="COMPETENCE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Competence {
	 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nom;
	private String type;
	@ManyToMany
	private Collection <Candidat> candidats;//
	@ManyToMany
	private Collection <Poste> postes;//
}
