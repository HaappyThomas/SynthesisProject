package ca.bdeb.projetsynthese.services;


import ca.bdeb.projetsynthese.dao.SecteurDeHebergementRepository;
import ca.bdeb.projetsynthese.models.SecteurDeHebergement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurDeHebergementService {
    @Autowired
    private SecteurDeHebergementRepository secteurDeHebergementRepository;

    // get all secteurs of hebergement
    public List<SecteurDeHebergement> getSecteurDeHebergementList(){
        return secteurDeHebergementRepository.findAll();
    }

    // get a specific secteur of hebergement
    public SecteurDeHebergement getSecteurDeHebergementById( Integer id ){
        return secteurDeHebergementRepository.findById(id).get();
    }

    // add a new secteur of hebergement
    public SecteurDeHebergement addSecteurDeHebergement( SecteurDeHebergement secteurDeHebergement ){
        return secteurDeHebergementRepository.save(secteurDeHebergement);
    }

    // update a secteur of hebergement
    public SecteurDeHebergement updateSecteurDeHebergement( SecteurDeHebergement secteurDeHebergement ){
        return secteurDeHebergementRepository.save(secteurDeHebergement);
    }

    // delete a secteur of hebergement
    public void deleteSecteurDeHebergement( Integer id ){
        secteurDeHebergementRepository.deleteById(id);
    }


}
