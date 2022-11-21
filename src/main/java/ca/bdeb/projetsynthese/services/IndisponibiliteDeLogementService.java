package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IHebergementRepository;
import ca.bdeb.projetsynthese.dao.IIndisponibiliteDeLogementRepository;
import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.Hebergement;
import ca.bdeb.projetsynthese.models.IndisponibiliteDeLogement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class IndisponibiliteDeLogementService {
    @Autowired
    private IIndisponibiliteDeLogementRepository repository;

    @Autowired
    private IHebergementRepository iHebergementRepository;

    // get indisponibiliteDeLogement list
    public List<IndisponibiliteDeLogement> getList() {
        return repository.findAll();
    }

    // get indisponibiliteDeLogement by id
    public IndisponibiliteDeLogement getById(Integer id) {
        return repository.findById(id).get();
    }

    // get liste de indisponibilite d'un logement by logement id
    public List<IndisponibiliteDeLogementDTO> getIndisponibiliteUnLogement(Integer logementid) {
        return repository.findByLogementId(logementid);
    }

    // add new indisponibilite de logement
    public IndisponibiliteDeLogement add(IndisponibiliteDeLogement indisponibilite) {
        // get hebergement related for this indisponibiliteDeLogement
        Hebergement hebergement =
                iHebergementRepository.findById(indisponibilite.getHebergement().getId()).get();
        // herbergement exists
        if (hebergement != null) {
            // the date to insert can be inserted, because there is no conflict
            if (isInsertbale(hebergement.getId(), indisponibilite)) {
                // update hebergement
                indisponibilite.setHebergement(hebergement);
                // insert into DB
                return repository.save(indisponibilite);
            } else {
                // impossible to insert this indisponibiliteDeLogement because conflict
                return null;
            }
        } else {
            // impossible to insert this indisponibiliteDeLogement because hebergement related NOT exists
            return null;
        }
    }

    // update indisponibilite de logement
    public IndisponibiliteDeLogement update(IndisponibiliteDeLogement indisponibilite) {
        // get indisponibilite exists
        IndisponibiliteDeLogement indisponibiliteExist = repository.findById(indisponibilite.getId()).get();
        // if already exists
        if (indisponibiliteExist != null) {
            // get hebergement related for this indisponibiliteDeLogement
            Hebergement hebergement =
                    iHebergementRepository.findById(indisponibilite.getHebergement().getId()).get();
            // herbergement exists
            if (hebergement != null) {
                // the date modified is not conflict, it can be inserted
                if (isUpdatebale(hebergement.getId(), indisponibilite)) {
                    // update indisponibiliteExist form indisponibilite
                    indisponibiliteExist = indisponibilite;
                    // update hebergement for indisponibiliteExist
                    indisponibiliteExist.setHebergement(hebergement);
                    // update into DB
                    return repository.save(indisponibiliteExist);
                } else {
                    // impossible to insert this indisponibiliteDeLogement because conflict
                    return null;
                }
            } else {
                // impossible to insert this indisponibiliteDeLogement because hebergement related NOT exists
                return null;
            }
        } else {
            // this indisponibilite is not exists
            return null;
        }
    }


    // delete indisponibilite de logement
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    //// auxiliary method
    private boolean isUpdatebale(int logementId, IndisponibiliteDeLogement indisponibilite) {
        // get all indisponibilite of this hebergement
        List<IndisponibiliteDeLogementDTO> listDTO = repository.findByLogementId(logementId);
        // delete indisponibilite himself, it must not to compare itself
        listDTO.removeIf(dto -> dto.getId() == indisponibilite.getId());
        // iterate this list for known whether this indisponibilite can be inserted
        for (IndisponibiliteDeLogementDTO dto : listDTO) {
            // if inserted debut date is between the current date
            // or if inserted fin date is between the current date
            // return false
            // if the start date is equal to the current start date or finish date,
            // or the finish date is equal to the current start date or finish date
            // return false
            if ((indisponibilite.getDebutDeDateDeIndisponibilite().isAfter(dto.getDebutDeDateDeIndisponibilite())
                    && indisponibilite.getDebutDeDateDeIndisponibilite().isBefore(dto.getFinDeDateDeIndisponibilite()))
                    || (indisponibilite.getFinDeDateDeIndisponibilite().isAfter(dto.getDebutDeDateDeIndisponibilite())
                    && indisponibilite.getFinDeDateDeIndisponibilite().isBefore(dto.getFinDeDateDeIndisponibilite()))
                    || indisponibilite.getDebutDeDateDeIndisponibilite().isEqual(dto.getDebutDeDateDeIndisponibilite())
                    || indisponibilite.getDebutDeDateDeIndisponibilite().isEqual(dto.getFinDeDateDeIndisponibilite())
                    || indisponibilite.getFinDeDateDeIndisponibilite().isEqual(dto.getDebutDeDateDeIndisponibilite())
                    || indisponibilite.getFinDeDateDeIndisponibilite().isEqual(dto.getFinDeDateDeIndisponibilite())) {
                return false;
            }
        }
        return true;
    }

    // iterate indisponibilite of this hebergement
    private boolean isInsertbale(int logementId, IndisponibiliteDeLogement indisponibilite) {
        // get all indisponibilite of this hebergement
        List<IndisponibiliteDeLogementDTO> listDTO = repository.findByLogementId(logementId);
        // iterate this list for known whether this indisponibilite can be inserted
        for (IndisponibiliteDeLogementDTO dto : listDTO) {
            // if inserted debut date is between the current date
            // or if inserted fin date is between the current date
            // return false
            // if the start date is equal to the current start date or finish date,
            // or the finish date is equal to the current start date or finish date
            // return false
            if ((indisponibilite.getDebutDeDateDeIndisponibilite().isAfter(dto.getDebutDeDateDeIndisponibilite())
                    && indisponibilite.getDebutDeDateDeIndisponibilite().isBefore(dto.getFinDeDateDeIndisponibilite()))
                    || (indisponibilite.getFinDeDateDeIndisponibilite().isAfter(dto.getDebutDeDateDeIndisponibilite())
                    && indisponibilite.getFinDeDateDeIndisponibilite().isBefore(dto.getFinDeDateDeIndisponibilite()))
                    || indisponibilite.getDebutDeDateDeIndisponibilite().isEqual(dto.getDebutDeDateDeIndisponibilite())
                    || indisponibilite.getDebutDeDateDeIndisponibilite().isEqual(dto.getFinDeDateDeIndisponibilite())
                    || indisponibilite.getFinDeDateDeIndisponibilite().isEqual(dto.getDebutDeDateDeIndisponibilite())
                    || indisponibilite.getFinDeDateDeIndisponibilite().isEqual(dto.getFinDeDateDeIndisponibilite())) {
                return false;
            }
        }
        return true;
    }
}
