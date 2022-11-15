package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Administrateur;
import ca.bdeb.projetsynthese.models.Hebergement;

import ca.bdeb.projetsynthese.services.HebergementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "API pour hebergement")
@RestController
@RequestMapping("/api/v1/hebergement")
@CrossOrigin(origins = "http://localhost:4200")
public class HebergementController {
    @Autowired
    private HebergementService hebergementService;

    @ApiOperation(value = "Récupérer la list des hebergements")
    @GetMapping("/listHebergement")

    public List<Hebergement> findAllHebergement()  {

        return hebergementService.getListHebergement();
    }

    @ApiOperation(value = "Récupérer l'hebergement spécifié par id")
    @GetMapping("/{id}")
    public Hebergement findHebergementById(@ApiParam("Hebergement Id") @PathVariable int id){
        return hebergementService.getAdministrateurById(id);
    }



    @ApiOperation(value = "Ajouter un nouvel hebergement")
    @PostMapping("/add")
    public Hebergement addHebergement(@RequestBody Hebergement hebergement){
        return hebergementService.addHebergement(hebergement);
    }

    @ApiOperation(value = "Modifer un hebergement")
    @PutMapping("/update")
    public Hebergement updateHebergement(@RequestBody Hebergement hebergement){
        return hebergementService.updateHebergement(hebergement);
    }

    @ApiOperation(value = "Supprimer un hebergement")
    @DeleteMapping("/delete/{id}")
    public void deleteHebergement(@ApiParam("Hebergement Id") @PathVariable Integer id){
        hebergementService.deleteHebergement(id);
    }



}
