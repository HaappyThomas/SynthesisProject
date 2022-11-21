package ca.bdeb.projetsynthese.dao;
import ca.bdeb.projetsynthese.models.Hebergement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHebergementRepository extends JpaRepository<Hebergement, Integer> {

}
