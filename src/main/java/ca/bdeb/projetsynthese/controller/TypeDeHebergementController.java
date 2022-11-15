package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.TypeDeHebergement;
import ca.bdeb.projetsynthese.services.TypeDeHebergementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/typeDeHebergement")
@Api(tags = "API pour type de hebergement")
public class TypeDeHebergementController {
    @Autowired
    private TypeDeHebergementService service;

    @GetMapping("/list")
    @ApiOperation(value ="Récupérer la liste de type de hebergement")
    public List<TypeDeHebergement> getTypeDeHebergementList() {
        return service.getTypeDeHebergementList();
    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Récupérer une type de hebergement")
    public TypeDeHebergement getTypeDeHebergement(@PathVariable("id") Integer id) {
        return service.getTypeDeHebergementById(id);
    }

    @PostMapping("/add")
    @ApiOperation("Ajouter une type de hebergement")
    public TypeDeHebergement addTypeDeHebergement(@RequestBody TypeDeHebergement typeDeHebergement) {
        return service.addTypeDeHebergement(typeDeHebergement);
    }

    @PutMapping("/update")
    @ApiOperation("Modifier la type de hebergement")
    public TypeDeHebergement updateTypeDeHebergement(@RequestBody TypeDeHebergement typeDeHeberg){
        return service.updateTypeDeHebergement(typeDeHeberg);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Supprimer une  type de hebergement")
    public void deleteTypeDeHebergement(@PathVariable("id") Integer id) {
        service.deleteTypeDeHebergement(id);
    }




}
