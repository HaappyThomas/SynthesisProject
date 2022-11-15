package ca.bdeb.projetsynthese.dao;
import ca.bdeb.projetsynthese.models.Hebergement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement, Integer> {


}
