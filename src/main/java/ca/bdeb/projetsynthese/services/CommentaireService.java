package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.IAdresseRepository;
import ca.bdeb.projetsynthese.dao.ICommentaireRepository;
import ca.bdeb.projetsynthese.dao.ILocataireRepository;
import ca.bdeb.projetsynthese.models.Commantaire;
import ca.bdeb.projetsynthese.models.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {
    @Autowired
    private ICommentaireRepository repository;

    @Autowired
    private ILocataireRepository ILocataireRepository;

    @Autowired
    private IAdresseRepository IAdresseRepository;


    // get all commentaires
    public List<Commantaire> getCommantaireList() {
        return repository.findAll();
    }

    // get commantaire by id
    public Commantaire getCommantaire(Integer id) {
        return repository.findById(id).get();
    }

    // add commantaire
    public Commantaire addCommantaire(Commantaire commantaire) {
        Locataire locataire =
                ILocataireRepository.findByEmailLocataire(commantaire.getLocataire().getEmailLocataire());

        commantaire.setLocataire(locataire);
        return repository.save(commantaire);
    }

    // update commantaire
    public Commantaire updateCommantaire(Commantaire commantaire) {
        Commantaire commantaireExist = repository.findById(commantaire.getId()).get();
        if (commantaireExist != null) {
            Locataire locataire =
                    ILocataireRepository.findByEmailLocataire(commantaire.getLocataire().getEmailLocataire());
            commantaire.setLocataire(locataire);
            return repository.save(commantaire);
        }else{
            return null;
        }
    }

    // delete commantaire
    public void deleteCommantaire(Integer id) {
        repository.deleteById(id);
    }
}
