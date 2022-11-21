package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdresseRepository extends JpaRepository<Adresse, Integer> {
}
