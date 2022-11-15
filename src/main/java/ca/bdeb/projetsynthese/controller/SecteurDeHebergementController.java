package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.SecteurDeHebergement;
import ca.bdeb.projetsynthese.services.SecteurDeHebergementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API pour secteur de hébergement")
@RestController
@RequestMapping("/api/v1/secteur-de-hebergement")
public class SecteurDeHebergementController {
    @Autowired
    private SecteurDeHebergementService secteurDeHebergementService;

    @ApiOperation(value = "Récupérer la list secteur de hébergement")
    @GetMapping("/list")
    public List<SecteurDeHebergement> getSecteurDeHebergementList() {
        return secteurDeHebergementService.getSecteurDeHebergementList();
    }

    @ApiOperation(value = "Récupérer secteurDeHebergementService spécifié par id")
    @GetMapping("/{id}")
    public SecteurDeHebergement getSecteurDeHebergement(@ApiParam("Secteur Id") @PathVariable Integer id){
        return secteurDeHebergementService.getSecteurDeHebergementById(id);
    }

    @ApiOperation(value = "Ajouter un secteur de Hébergement")
    @PostMapping("/add")
    public SecteurDeHebergement addSecteurDeHebergement(@RequestBody SecteurDeHebergement secteurDeHebergement){
        return secteurDeHebergementService.addSecteurDeHebergement(secteurDeHebergement);
    }

    @ApiOperation(value = "Modifier un secteur de Hébergement")
    @PutMapping("/update")
    public SecteurDeHebergement updateSecteurDeHebergement(@RequestBody SecteurDeHebergement secteurDeHebergement){
        return secteurDeHebergementService.updateSecteurDeHebergement(secteurDeHebergement);
    }

    @ApiOperation(value = "Supprimer un secteur de Héberge")
    @DeleteMapping("/delete/{id}")
    public void deleteSecteurDeHebergement(@ApiParam("Secteur Id") @PathVariable Integer id){
        secteurDeHebergementService.deleteSecteurDeHebergement(id);
    }
}
