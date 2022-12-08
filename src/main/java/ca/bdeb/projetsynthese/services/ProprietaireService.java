package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.dao.IProprietaireRepository;
import ca.bdeb.projetsynthese.dto.LoginDTO;
import ca.bdeb.projetsynthese.dto.ProprietaireDTO;
import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.models.Proprietaire;
import ca.bdeb.projetsynthese.vo.ProprietaireLoginVO;
import ca.bdeb.projetsynthese.vo.ProprietaireVO;
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
    public ProprietaireVO add(ProprietaireDTO proprietaireDTO) {
        Adresse adresse = adresseRepository.findById(1).get();
        System.out.println("===========> adresse" + adresse.toString());
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setEmailProprietaire(proprietaireDTO.getEmailProprietaire());
        proprietaire.setMotDePasse(proprietaireDTO.getMotDePasse());
        proprietaire.setNom(proprietaireDTO.getNom());
        proprietaire.setPrenom(proprietaireDTO.getPrenom());
        proprietaire.setTelephone(proprietaireDTO.getTelephone());
        proprietaire.setEtatDeProprietaire(true);
        proprietaire.setAdresse(adresse);
        proprietaire = repository.save(proprietaire);


        return new ProprietaireVO(
                proprietaire.getEmailProprietaire(),
                proprietaire.getNom(),
                proprietaire.getPrenom(),
                proprietaire.getTelephone());
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
    public void delete(String email) {
        Proprietaire proprietaire = repository.findByEmailProprietaire(email);
        if (proprietaire != null) {
            repository.delete(proprietaire);
        }
    }

    public ProprietaireLoginVO login(LoginDTO loginDTO) {
        Proprietaire proprietaire = repository.findByEmailProprietaire(loginDTO.getEmail());
        if (proprietaire != null) {
            if (proprietaire.getMotDePasse().equals(loginDTO.getPassword())) {
                return new ProprietaireLoginVO("Bienvenu " + proprietaire.getPrenom(), proprietaire);
            } else {
                return new ProprietaireLoginVO("Mot de passe n'est pas correct!", null);
            }
        } else {
            return new ProprietaireLoginVO("Utilisateur n'exist pas, S'inscrire S.V.P", null);
        }
    }

}
