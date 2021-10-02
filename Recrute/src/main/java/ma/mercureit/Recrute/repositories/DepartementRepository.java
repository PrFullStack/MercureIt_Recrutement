package ma.mercureit.Recrute.repositories;

import ma.mercureit.Recrute.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository   extends JpaRepository<Departement, Long>{

}
