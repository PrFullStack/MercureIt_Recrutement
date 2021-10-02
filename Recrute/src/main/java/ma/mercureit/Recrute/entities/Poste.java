package ma.mercureit.Recrute.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="POSTE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Poste {
        @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String description;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date datePublication;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date DateCreation;
	private float remuneration;
	private String typeContrat;
	private String status;
	@ManyToOne
	private Departement departement;
	@ManyToMany
	private Collection <Competence> competences;
	@ManyToOne
	private Equipe equipe;
}