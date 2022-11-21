package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.dao.ILocataireRepository;
import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.models.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocataireService {
    @Autowired
    private ILocataireRepository repository;
    @Autowired
    private IAdresseRepository IAdresseRepository;

    // get locataire list
    public List<Locataire> getLocataireList() {
        return repository.findAll();
    }

    // get a locataire by email
    public Locataire getLocataireByEmail(String email) {
        return repository.findByEmailLocataire(email);
    }

    // add a locataire
    public Locataire addLocataire(Locataire locataire) {
        // chercher adresse dans la DB
        Adresse adresse = IAdresseRepository.findById(locataire.getAdresse().getId()).get();
        locataire.setAdresse(adresse);
        return repository.save(locataire);
    }

    // update a locataire
    public Locataire updateLocataire(Locataire locataire) {
        // chercher locataire dans la DB
        Locataire locataireExiste = repository.findByEmailLocataire(locataire.getEmailLocataire());
        if (locataireExiste != null) {
            locataireExiste = locataire;
            // chercher adresse dans la DB
            Adresse adresse = IAdresseRepository.findById(locataire.getAdresse().getId()).get();
            locataireExiste.setAdresse(adresse);
            return repository.save(locataireExiste);
        } else {
            return null;
        }
    }

    // remove a locataire
    public void removeLocataire(String email) {
        Locataire locataire = repository.findByEmailLocataire(email);
        if (locataire != null) {
            repository.delete(locataire);
        }
    }
}
