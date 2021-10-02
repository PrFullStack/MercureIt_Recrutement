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
@Table(name="DEPARTEMENT")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Departement {
	 @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String nom;
    @OneToMany
    private Collection <Poste> postes;//
    @OneToMany
    private Collection <Recruteur> recruteurs;//
}
