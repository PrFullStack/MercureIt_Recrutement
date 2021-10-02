package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
