package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.models.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    @Autowired
    private IAdresseRepository repository;

    // get adresse list
    public List<Adresse> getAdresseList() {
        return repository.findAll();
    }

    // get adresse by id
    public Adresse getAdresseById(int id) {
        return repository.findById(id).get();
    }

    // add adresse
    public Adresse addAdresse(Adresse adresse) {
        return repository.save(adresse);
    }

    // update adresse
    public Adresse updateAdresse(Adresse adresse) {
        return repository.save(adresse);
    }

    // delete adresse
    public void deleteAdresse(int id) {
        repository.deleteById(id);
    }

}
