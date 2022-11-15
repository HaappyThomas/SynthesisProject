package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.TypeDeHebergementRepository;
import ca.bdeb.projetsynthese.models.TypeDeHebergement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDeHebergementService {
    @Autowired
    private TypeDeHebergementRepository repository;

    // get type de hebergement list
    public List<TypeDeHebergement> getTypeDeHebergementList() {
        return repository.findAll();
    }

    // get type de hebergement by id
    public TypeDeHebergement getTypeDeHebergementById(int id) {
        return repository.findById(id).get();
    }

    // add new type de hebergement
    public TypeDeHebergement addTypeDeHebergement(TypeDeHebergement typeDeHebergement){
        return repository.save(typeDeHebergement);
    }

    // update type de hebergement
    public TypeDeHebergement updateTypeDeHebergement(TypeDeHebergement typeDeHergement){
       return repository.save(typeDeHergement);
    }

    // delete type de hebergement
    public void deleteTypeDeHebergement(Integer id){
        repository.deleteById(id);
    }

}
