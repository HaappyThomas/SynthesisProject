package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
    Facture findByNumeroDeFacture(Integer numero);
}
