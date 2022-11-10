package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.AdresseRepository;
import ca.bdeb.projetsynthese.models.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas Wang on 11/8/2022.
 */
@Service
public class AdresseService {
    @Autowired
    private AdresseRepository adresseRepository;

    // get adresse list
    public List<Adresse> getAdresseList() {
        return adresseRepository.findAll();
    }
    // get adresse by id
    public Adresse getAdresseById(int id) {
        return adresseRepository.findById(id).get();
    }
    // add adresse
    public Adresse addAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
    // update adresse
    public Adresse updateAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
    // delete adresse
    public void deleteAdresse(int id) {
        adresseRepository.deleteById(id);
    }
}
