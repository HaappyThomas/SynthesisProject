package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.FactureRepository;
import ca.bdeb.projetsynthese.dao.LocataireRepository;
import ca.bdeb.projetsynthese.models.Facture;
import ca.bdeb.projetsynthese.models.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    @Autowired
    private FactureRepository repository;

    @Autowired
    private LocataireRepository locataireRepository;

    // get facture list
    public List<Facture> getFactureList() {
        return repository.findAll();
    }

    // get facture by numero
    public Facture getByNumro(Integer numero) {
        return repository.findByNumeroDeFacture(numero);
    }

    // add facture
    public Facture addFacture(Facture facture) {
        // get locataire for the facture
        Locataire locataire =
                locataireRepository.findByEmailLocataire(facture.getLocataire().getEmailLocataire());
        facture.setLocataire(locataire);
        return repository.save(facture);
    }

    // update facture
    public Facture updateFacture(Facture facture) {
        Facture factureExiste = repository.findById(facture.getNumeroDeFacture()).get();
        if (factureExiste != null) {
            factureExiste = facture;
            Locataire locataire =
                    locataireRepository.findByEmailLocataire(facture.getLocataire().getEmailLocataire());
            factureExiste.setLocataire(locataire);
            return repository.save(factureExiste);
        } else {
            return null;
        }
    }

    // delete facture
    public void deleteFacture(Integer numeroDeFacture) {
        Facture facture = repository.findByNumeroDeFacture(numeroDeFacture);
        if (facture != null) {
            repository.delete(facture);
        }
    }
}
