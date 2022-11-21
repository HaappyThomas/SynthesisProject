package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    Administrateur findByNomAdministrateur(String nom);

}
