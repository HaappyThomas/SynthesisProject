package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.*;
import ca.bdeb.projetsynthese.dto.CritereHebergement;
import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class HebergementService {

    @Autowired
    private IHebergementRepository repository;
    @Autowired
    private IAdresseRepository adresseRepository;
    @Autowired
    private IProprietaireRepository proprietaireRepository;
    @Autowired
    private ITypeDeHebergementRepository typeDeHebergementRepository;
    @Autowired
    private ISecteurDeHebergementRepository secteurDeHebergementRepository;
    @Autowired
    private IIndisponibiliteDeLogementRepository indisponibiliteRepository;

    // récupérer la list des hebergements
    public List<Hebergement> getList() {
        return repository.findAll();
    }

    // récupérer hebergement avec son id
    public Hebergement getById(Integer id) {
        return repository.findById(id).get();
    }

    // ajouter un hebergement
    public Hebergement add(Hebergement hebergement) {

        Adresse adresse =
                adresseRepository.findById(hebergement.getAdresse().getId()).get();
        Proprietaire proprietaire =
                proprietaireRepository.findByEmailProprietaire(hebergement.getProprietaire().getEmailProprietaire());
        TypeDeHebergement typeDeHebergement =
                typeDeHebergementRepository.findById(hebergement.getTypeDeHebergement().getId()).get();
        SecteurDeHebergement secteurDeHebergement =
                secteurDeHebergementRepository.findById(hebergement.getSecteurDeHebergement().getId()).get();
        hebergement.setAdresse(adresse);
        hebergement.setProprietaire(proprietaire);
        hebergement.setTypeDeHebergement(typeDeHebergement);
        hebergement.setSecteurDeHebergement(secteurDeHebergement);
        return repository.save(hebergement);
    }

    // modifier un hebergement
    public Hebergement update(Hebergement hebergement) {
        Hebergement hebergementExisted = repository.findById(hebergement.getId()).get();

        if(hebergementExisted != null) {
            hebergementExisted = hebergement;
            Adresse adresse =
                    adresseRepository.findById(hebergement.getAdresse().getId()).get();
            Proprietaire proprietaire =
                    proprietaireRepository.findByEmailProprietaire(hebergement.getProprietaire().getEmailProprietaire());
            TypeDeHebergement typeDeHebergement =
                    typeDeHebergementRepository.findById(hebergement.getTypeDeHebergement().getId()).get();
            SecteurDeHebergement secteurDeHebergement =
                    secteurDeHebergementRepository.findById(hebergement.getSecteurDeHebergement().getId()).get();
            hebergement.setAdresse(adresse);
            hebergement.setProprietaire(proprietaire);
            hebergement.setTypeDeHebergement(typeDeHebergement);
            hebergement.setSecteurDeHebergement(secteurDeHebergement);
            return repository.save(hebergementExisted);
        }else{
            return null;
        }

    }

    // supprimer un hebergement
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Hebergement> getListByCriteria(CritereHebergement critereHebergement) {
        // data preparation
        // get all indisponibilite
        List<IndisponibiliteDeLogementDTO> listDTO = indisponibiliteRepository.findAllDTO();
//        System.out.println("listDTO: ====> " + listDTO);

        // change indiponibiliteList to Map<Integer, List<IndisponibiliteDeLogement>>
        // key is herbergementId, value is indiponibiliteDeLogement
        Map<Integer, List<IndisponibiliteDeLogementDTO>> map = new HashMap<Integer, List<IndisponibiliteDeLogementDTO>>();
        map = listDTO.stream().collect(Collectors.groupingBy(IndisponibiliteDeLogementDTO::getId));
//        System.out.println("map ====> " + map);

        // todo: implement
        if(critereHebergement.getDateDeArrive() != null && critereHebergement.getDateDeDepart() !=null){
            // return list of hebergement avaliable for this date
            return null;
        }
        return null;
    }
}
