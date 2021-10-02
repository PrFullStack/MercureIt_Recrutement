package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
