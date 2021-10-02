package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PosteRepository extends JpaRepository<Poste, Long> {

}
