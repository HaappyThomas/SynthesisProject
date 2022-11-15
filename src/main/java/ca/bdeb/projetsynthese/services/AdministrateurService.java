package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.AdministrateurRepository;
import ca.bdeb.projetsynthese.models.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    // récupérer la list de l'administrateur
    public List<Administrateur> getAdministrateurList() {
        return administrateurRepository.findAll();
    }

    // récupérer l'administrateur spécifié par id
    public Administrateur getAdministrateurById(Integer id) {
        return administrateurRepository.findById(id).get();
    }

    // récupérer l'administrateur spécifié par nom
    public Administrateur getAdministrateurByName(String nom){
        return administrateurRepository.findByNomAdministrateur(nom);
    }

    // ajouter un administrateur
    public Administrateur addAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    // modifier un administrateur
    public Administrateur updateAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    // supprimer un administrateur
    public void deleteAdministrateur(Integer id) {
        administrateurRepository.deleteById(id);
    }
}
