package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.dao.ILocataireRepository;
import ca.bdeb.projetsynthese.dto.LocataireDTO;
import ca.bdeb.projetsynthese.dto.LoginDTO;
import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.models.Locataire;
import ca.bdeb.projetsynthese.vo.AdministrateurLoginVO;
import ca.bdeb.projetsynthese.vo.LocataireLoginVO;
import ca.bdeb.projetsynthese.vo.LocataireVO;
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
    public LocataireVO addLocataire(LocataireDTO locataireDTO) {
        // ajouter l'adresse dans la DB
        Adresse adresse = IAdresseRepository.findById(1).get();
        Locataire locataire = new Locataire();
        locataire.setEmailLocataire(locataireDTO.getEmailLocataire());
        locataire.setMotDePasse(locataireDTO.getMotDePasse());
        locataire.setNom(locataireDTO.getNom());
        locataire.setPrenom(locataireDTO.getPrenom());
        locataire.setTelephone(locataireDTO.getTelephone());
        locataire.setEtatDeLocataire(true);
        locataire.setAdresse(adresse);
        locataire = repository.save(locataire);

        return new LocataireVO(
         locataire.getEmailLocataire(),
         locataire.getMotDePasse(),
         locataire.getPrenom(),
         locataire.getTelephone()
        );
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

    public LocataireLoginVO login(LoginDTO loginDTO) {
        Locataire locataire = repository.findByEmailLocataire(loginDTO.getEmail());
        if (locataire != null) {
            if (locataire.getMotDePasse().equals(loginDTO.getPassword())) {
                return new LocataireLoginVO("Bienvenu " + locataire.getPrenom(), locataire);
            }else{
                return new LocataireLoginVO("Mot de passe n'est pas correct!", null);
            }
        }else {
            return new LocataireLoginVO("Utilisateur n'exist pas, S'inscrire S.V.P", null);
        }
    }
}
