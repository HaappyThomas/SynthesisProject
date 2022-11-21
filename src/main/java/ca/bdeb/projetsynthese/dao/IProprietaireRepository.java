package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProprietaireRepository extends JpaRepository<Proprietaire, String> {
    Proprietaire findByEmailProprietaire(String email);
}
