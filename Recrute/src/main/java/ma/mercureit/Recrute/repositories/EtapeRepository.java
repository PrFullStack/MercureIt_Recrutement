package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtapeRepository extends JpaRepository<Etape, Long> {

}
