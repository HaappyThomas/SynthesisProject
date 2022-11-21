package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.dao.IProprietaireRepository;
import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.models.Proprietaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaireService {
    @Autowired
    private IProprietaireRepository repository;
    @Autowired
    private IAdresseRepository adresseRepository;

    // get proprietaire list
    public List<Proprietaire> getList() {
        return repository.findAll();
    }

    // get proprietaire by email
    public Proprietaire getByEmail(String email) {
        return repository.findByEmailProprietaire(email);
    }

    // add proprietaire
    public Proprietaire add(Proprietaire proprietaire) {
        Adresse adresse =
                adresseRepository.findById(proprietaire.getAdresse().getId()).get();
        proprietaire.setAdresse(adresse);
        return repository.save(proprietaire);
    }

    // update proprietaire
    public Proprietaire update(Proprietaire proprietaire) {
        Proprietaire proprietaireExisted =
                repository.findByEmailProprietaire(proprietaire.getEmailProprietaire());
        if (proprietaireExisted != null) {
            proprietaireExisted = proprietaire;
            Adresse adresse =
                    adresseRepository.findById(proprietaireExisted.getAdresse().getId()).get();
            proprietaireExisted.setAdresse(adresse);
            return repository.save(proprietaireExisted);
        } else {
            return null;
        }
    }

    // delete proprietaire
    public void delete(String email){
        Proprietaire proprietaire = repository.findByEmailProprietaire(email);
        if (proprietaire!= null) {
            repository.delete(proprietaire);
        }
    }
}
