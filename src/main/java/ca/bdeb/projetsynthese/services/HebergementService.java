package ca.bdeb.projetsynthese.services;
import ca.bdeb.projetsynthese.dao.HebergementRepository;
import ca.bdeb.projetsynthese.models.Administrateur;
import ca.bdeb.projetsynthese.models.Hebergement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HebergementService {


    @Autowired
    private HebergementRepository hebergementRepository;
    private List listHebergement = new ArrayList<>();

    // récupérer la list des hebergements
    public List<Hebergement> getListHebergement() {

        return hebergementRepository.findAll();

    }
    // récupérer hebergement avec son id
    public Hebergement getAdministrateurById(Integer id) {
        return hebergementRepository.findById(id).get();
    }



    // ajouter un hebergement
    public Hebergement addHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    // modifier un hebergement
    public Hebergement updateHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    // supprimer un hebergement
    public void deleteHebergement(Integer id) {
        hebergementRepository.deleteById(id);
    }

}
