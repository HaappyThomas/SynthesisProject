package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Commantaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commantaire, Integer> {
}
