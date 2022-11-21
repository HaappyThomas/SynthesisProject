package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.IndisponibiliteDeLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IIndisponibiliteDeLogementRepository
        extends JpaRepository<IndisponibiliteDeLogement, Integer> {

    // this return id in IndisponibiliteDeLogementDTO is indisoponibilite id
    @Query("select new ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO(id, debutDeDateDeIndisponibilite, finDeDateDeIndisponibilite) " +
            "from IndisponibiliteDeLogement i where i.hebergement.id = ?1")
    List<IndisponibiliteDeLogementDTO> findByLogementId(Integer logementid);

    // this return id in IndisponibiliteDeLogementDTO is hebergement id
    @Query("select new ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO(i.hebergement.id, debutDeDateDeIndisponibilite, finDeDateDeIndisponibilite) " +
            "from IndisponibiliteDeLogement i")
    List<IndisponibiliteDeLogementDTO> findAllDTO();

    // c'est pour cas de test
    @Query("select max(i.id) from IndisponibiliteDeLogement i ")
    int findMaxId();

}
