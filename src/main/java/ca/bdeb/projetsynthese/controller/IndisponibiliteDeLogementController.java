package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.IndisponibiliteDeLogement;
import ca.bdeb.projetsynthese.services.IndisponibiliteDeLogementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/IndisponibiliteDeLogement")
@Api(tags = "API pour indisponibilite de logement")
public class IndisponibiliteDeLogementController {
    @Autowired
    private IndisponibiliteDeLogementService service;

    @GetMapping("/list")
    @ApiOperation(value ="Récupérer une indisponibilite de logement par id")
    public List<IndisponibiliteDeLogement> getList() {
       return service.getList();
    }

    @GetMapping("/{id}")
    @ApiOperation(value ="Récupérer une indisponibilite de logement")
    public IndisponibiliteDeLogement getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value ="Ajouter une indisponibilite de logement")
    public IndisponibiliteDeLogement add(@RequestBody IndisponibiliteDeLogement indisponibilite){
        return service.add(indisponibilite);
    }

    @PutMapping("/update")
    @ApiOperation(value ="Modifie une indisponibilite de logement")
    public IndisponibiliteDeLogement update(@RequestBody IndisponibiliteDeLogement indisponibilite) {
        return service.update(indisponibilite);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value ="Supprimer une indisponibilite de logement by id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    @GetMapping("/logement/{logementid}")
    @ApiOperation(value ="Récupérer liste d'indisponibilite d'un logement")
    public List<IndisponibiliteDeLogementDTO> getIndisponibiliteUnLogement(@PathVariable("logementid") Integer logementid){
        return service.getIndisponibiliteUnLogement(logementid);
    }
}
