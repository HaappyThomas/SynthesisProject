package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.services.AdresseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Thomas Wang on 11/8/2022.
 */
@Api(tags = "API pour adresse")
@RestController
@RequestMapping("/api/v1/adresse")
public class AdresseController {

    @Autowired
    private AdresseService service;

    //get the adresse list
    @ApiOperation(value = "Récupérer la list de l'adresse")
    @GetMapping("/list")
    public List<Adresse> getAdresseList() {
       return service.getAdresseList();
    }
    // get an adresse specific by its id
    @ApiOperation(value = "Récupérer un adresse spécifié")
    @GetMapping("/{id}")
    public Adresse getAdresseById(@ApiParam("Adresse Id") @PathVariable Integer id) {
        return  service.getAdresseById(id);
    }
    // add an adresse
    @ApiOperation(value = "Ajouter un nouvel adresse")
    @PostMapping("/add")
    public Adresse addAdresse(@RequestBody Adresse adresse) {
        return service.addAdresse(adresse);
    }
    // update an adresse
    @ApiOperation(value = "Modifier un adresse")
    @PutMapping("/update")
    public Adresse updateAdresse(@RequestBody Adresse adresse) {
        return service.updateAdresse(adresse);
    }
    // delete an adresse
    @ApiOperation(value = "Supprimer un adresse")
    @DeleteMapping("/delete/{id}")
    public void deleteAdresse(@ApiParam("Adresse Id") @PathVariable Integer id) {
        service.deleteAdresse(id);
    }


}
