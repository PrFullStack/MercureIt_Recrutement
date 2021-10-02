package ma.mercureit.Recrute.entities;

import java.io.File;
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
@Table(name="CANDIDAT")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Candidat {
        @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date DateCreation;
	private String email;
	private File cv;
	private String motivation;
	@ManyToOne
	private Etape etape;
	@ManyToMany
	private Collection<Competence> competences;
}
