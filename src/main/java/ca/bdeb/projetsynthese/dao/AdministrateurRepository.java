package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    Administrateur findByNomAdministrateur(String nom);

}
