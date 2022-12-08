package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.*;
import ca.bdeb.projetsynthese.dto.CritereHebergementDTO;
import ca.bdeb.projetsynthese.dto.HebergementDTO;
import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

        if (hebergementExisted != null) {
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
        } else {
            return null;
        }

    }

    // supprimer un hebergement
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * method is for get available herbergement avec his indisponibilite list
     *
     * @param critereHebergementDTO critere hebergement of the request
     * @return list hebergement available with his indisponibilite list
     * if indisponibilite list is null, it means hebergement is available all time
     */
    public List<HebergementDTO> getListByCriteria(CritereHebergementDTO critereHebergementDTO) {
        // data preparation, read the data related into memory to reduce response time
        //// get all indisponibilite
        List<IndisponibiliteDeLogementDTO> listIndispoDTO = indisponibiliteRepository.findAllDTO();
//        System.out.println("listDTO: ====> " + listDTO);

        // change indiponibiliteList to Map<Integer, List<IndisponibiliteDeLogement>>
        // key is herbergementId, value is indiponibiliteDeLogement
        Map<Integer, List<IndisponibiliteDeLogementDTO>> mapOriginIndisponibilite = new HashMap<Integer, List<IndisponibiliteDeLogementDTO>>();
        mapOriginIndisponibilite = listIndispoDTO.stream().collect(Collectors.groupingBy(IndisponibiliteDeLogementDTO::getId));
//        System.out.println("map ====> " + map);

        //// get all hebergements
        List<Hebergement> hebergementListOrigin = repository.findAll();

        // implement critere hebergement
        // critere implicits: etatDeHebergement is true
        List<Hebergement> hebergementList = hebergementListOrigin.stream()
                .filter(Hebergement::isEtatDeHebergement)
                .collect(Collectors.toList());


        // critere: prixMax,
        float prixMax = critereHebergementDTO.getPrixMax();
        if (prixMax > 0) {
            float max = prixMax;
            hebergementList = hebergementList.stream()
                    .filter(hebergement -> hebergement.getPrix() <= max)
                    .collect(Collectors.toList());
        }

        // critere: prixMin,
        float prixMin = Float.valueOf(critereHebergementDTO.getPrixMin());
        if (prixMin > 0) {
            float min = prixMin;
            hebergementList = hebergementList.stream()
                    .filter(hebergement -> hebergement.getPrix() >= min)
                    .collect(Collectors.toList());
        }

        // critere: typeDeHebergement
        int typeDeHebergementId = Integer.valueOf(critereHebergementDTO.getTypeDeHebergementId());
        if (typeDeHebergementId > 0) {
            int typeId = typeDeHebergementId;
            hebergementList = hebergementList.stream()
                    .filter(hebergement -> hebergement.getTypeDeHebergement().getId() == typeId)
                    .collect(Collectors.toList());
        }

        // critere: secteurDeHebergement
        int secteurDeHebergementId = Integer.valueOf(critereHebergementDTO.getSecteurDeHebergementId());
        if (secteurDeHebergementId > 0) {
            int secteurId = secteurDeHebergementId;
            hebergementList = hebergementList.stream()
                    .filter(hebergement -> hebergement.getSecteurDeHebergement().getId() == secteurId)
                    .collect(Collectors.toList());
        }


        // implement critere indisponibilite de hebergement
        // critere: dateDeArrive
        LocalDate dateDeArrive = critereHebergementDTO.getDateDeArrive();
        Map<Integer, List<IndisponibiliteDeLogementDTO>> mapAvailable = new HashMap<Integer, List<IndisponibiliteDeLogementDTO>>();
        if (dateDeArrive != null) {
            for (Hebergement hebergement : hebergementList) {
                if (mapOriginIndisponibilite.get(hebergement.getId()) == null) {
                    // if List<IndisponibiliteDeLogementDTO> is null,
                    // it means that this hebergement is avaliable for all time
                    mapAvailable.put(hebergement.getId(), null);
                } else {
                    // if List<IndisponibiliteDeLogementDTO> in NOT null
                    // it means that this hebergement is NOT available for all time
                    // it must be verified to check if this hebergement is available for this date arrive
                    // get list disponibiliteDeLogement of this hebergement
                    List<IndisponibiliteDeLogementDTO> list = mapOriginIndisponibilite.get(hebergement.getId());
                    boolean available = true;
                    // iterate list disponibiliteDeLogement of this hebergement
                    // if there is conflict with this date arrive, available = false
                    for (IndisponibiliteDeLogementDTO dto : list) {
                        if (dateDeArrive.isEqual(dto.getDebutDeDateDeIndisponibilite())
                                || dateDeArrive.isEqual(dto.getFinDeDateDeIndisponibilite())
                                || (dateDeArrive.isAfter(dto.getDebutDeDateDeIndisponibilite())
                                && dateDeArrive.isBefore(dto.getFinDeDateDeIndisponibilite()))) {
                            available = false;
                            break;
                        }
                    }
                    // without conflict add into mapAvailable with his indisponibilite list
                    if (available) {
                        mapAvailable.put(hebergement.getId(), list);
                    }
                }
            }
        } else {
            // without dateDeArrive
            // iterate hebergement list
            for (Hebergement hebergement : hebergementList) {
                if (mapOriginIndisponibilite.get(hebergement.getId()) == null) {
                    // if List<IndisponibiliteDeLogementDTO> is null,
                    // it means that this hebergement is avaliable for all time
                    mapAvailable.put(hebergement.getId(), null);
                } else {
                    // if hebergement exists in mapOrigin
                    // but date de arrive is Null, not need verify, add directly with his indisponibilite list
                    mapAvailable.put(hebergement.getId(), mapOriginIndisponibilite.get(hebergement.getId()));
                }
            }
        }
        // result: with or without date de arrive, we have a map available

        // critere: dateDeDepart,
        // remove conflicted element from mapAvailable if there is a conflict with dateDeDepart
        LocalDate dateDeDepart = critereHebergementDTO.getDateDeDepart();
        if (dateDeDepart != null) {
            // iterate hebergement list
            for (Hebergement hebergement : hebergementList) {
                boolean conflict = false;
                // iterate list disponibiliteDeLogement of this hebergement
                // if there is conflict with this date depart, conflict = true
                // get list disponibiliteDeLogement of this hebergement
                List<IndisponibiliteDeLogementDTO> list = mapOriginIndisponibilite.get(hebergement.getId());
                // if list is not null, it needs verify, because there is possible to have conflict
                if (list != null) {
                    for (IndisponibiliteDeLogementDTO dto : list) {
                        if (dateDeDepart.isEqual(dto.getDebutDeDateDeIndisponibilite())
                                || dateDeDepart.isEqual(dto.getFinDeDateDeIndisponibilite())
                                || (dateDeDepart.isAfter(dto.getDebutDeDateDeIndisponibilite())
                                && dateDeDepart.isBefore(dto.getFinDeDateDeIndisponibilite()))) {
                            conflict = true;
                            break;
                        }
                    }
                }
                if (conflict) {
                    mapAvailable.remove(hebergement.getId());
                }
            }
        }
        // final result: we have a map available
        System.out.println("mapAvailable====>" + mapAvailable);

        // translate map to list for front-end
        List<HebergementDTO> hebergementDTOList = new ArrayList<HebergementDTO>();
        if(mapAvailable.size() > 0) {
            mapAvailable.forEach((k, v)->{
               HebergementDTO hebergementDTO = repository.findById(k).get().asDTO();
               hebergementDTO.setIndisponibiliteDeLogementListDTO(v);
               hebergementDTOList.add(hebergementDTO);
            });
        }
        return hebergementDTOList;
    }
}
