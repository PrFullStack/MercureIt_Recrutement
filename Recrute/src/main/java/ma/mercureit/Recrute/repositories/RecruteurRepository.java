package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {

}
