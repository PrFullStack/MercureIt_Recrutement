package ma.mercureit.Recrute.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="ETAPE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Etape {
	 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int Id;
	private String intitulite;
	@OneToMany
	private Collection<Candidat> candidats;
}
