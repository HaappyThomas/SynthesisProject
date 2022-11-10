package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Administrateur;
import ca.bdeb.projetsynthese.services.AdministrateurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Thomas Wang on 10/31/2022.
 */
@Api(tags = "API pour administrateur")
@RestController
@RequestMapping("/api/v1/administrateur")
public class AdministrateurController {
    @Autowired
    private AdministrateurService AdministrateurService;

    @ApiOperation(value = "Récupérer la list d'administrateur")
    @GetMapping("/list")
    public List<Administrateur> findAllAdministrateurs(){
        return AdministrateurService.getAdministrateurList();
    }

    @ApiOperation(value = "Récupérer l'administrateur spécifié par id")
    @GetMapping("/{id}")
    public Administrateur findAdministrateurById(@ApiParam("Administrateur Id") @PathVariable int id){
        return AdministrateurService.getAdministrateurById(id);
    }

    @ApiOperation(value = "Récupérer l'administrateur spécifié par nom'")
    @GetMapping("/name/{name}")
    public Administrateur findAdministrateurByName(@ApiParam("Administrateur name") @PathVariable String name){
        return AdministrateurService.getAdministrateurByName(name);
    }

    @ApiOperation(value = "Ajouter un nouvel administrateur")
    @PostMapping("/add")
    public Administrateur addAdministrateur(@RequestBody Administrateur administrateur){
        return AdministrateurService.addAdministrateur(administrateur);
    }

    @ApiOperation(value = "Modifer un administrateur existe")
    @PutMapping("/update")
    public Administrateur updateAdministrateur(@RequestBody Administrateur administrate){
        return AdministrateurService.updateAdministrateur(administrate);
    }

    @ApiOperation(value = "Supprimer un administrateur")
    @DeleteMapping("/delete/{id}")
    public void deleteAdministrateur(@ApiParam("Administrateur Id") @PathVariable Integer id){
        AdministrateurService.deleteAdministrateur(id);
    }

    ////////////////////////////////////////////////////////////////
    // ce methode est pour test ce controller
    @ApiOperation(value="Test access administrateur controller")
    @GetMapping("/test")
    @ResponseBody
    public String  findTestAllAdministrateurs(){
        return "test for all Administrateurs";
    }
}
