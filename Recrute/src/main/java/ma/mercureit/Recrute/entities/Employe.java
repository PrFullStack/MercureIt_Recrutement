package ma.mercureit.Recrute.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="EMPLOYE")
@Data @NoArgsConstructor   @AllArgsConstructor @ToString
public class Employe {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private String nom;
	private String prenom;
	private String adresseProfes;
	private String adressePers;
	private String Tel;
	private Date HeureTravail;
	@ManyToOne
	private Recruteur recruteur;
	@ManyToOne
	private Departement departement;
}
