package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.SecteurDeHebergement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Thomas Wang on 11/7/2022.
 */
@Repository
public interface SecteurDeHebergementRepository extends JpaRepository<SecteurDeHebergement, Integer> {
}
