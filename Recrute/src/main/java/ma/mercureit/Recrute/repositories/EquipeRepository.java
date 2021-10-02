package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
