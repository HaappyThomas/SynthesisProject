package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocataireRepository extends JpaRepository<Locataire, String> {
    Locataire findByEmailLocataire(String email);
}

