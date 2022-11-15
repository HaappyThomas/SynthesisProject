package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Locataire;
import ca.bdeb.projetsynthese.services.LocataireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API pour Locataire")
@RestController
@RequestMapping("api/v1/locataire")
public class LocataireController {
    @Autowired
    private LocataireService service;

    @ApiOperation(value = "Récupérer la liste de Locataire")
    @GetMapping("/list")
    public List<Locataire> getLocataireList(){
        return service.getLocataireList();
    }

    @ApiOperation(value = "Récupérer le locataire spécifié by emmail")
    @GetMapping("/{email}")
    public Locataire getLocataireByEmail(@PathVariable("email") String email){
        return service.getLocataireByEmail(email);
    }

    @ApiOperation(value = "Ajouter un nouveau locataire")
    @PostMapping("/add")
    public Locataire addLocataire(@RequestBody Locataire locataire){
        return service.addLocataire(locataire);
    }

    @ApiOperation(value = "Modifier un locataire")
    @PutMapping("/update")
    public Locataire updateLocataire(@RequestBody Locataire locataire){
        return service.updateLocataire(locataire);
    }

    @ApiOperation(value = "Supprimer un nouveau locataire")
    @DeleteMapping("/delete/{email}")
    public void deleteLocataire(@PathVariable("email") String email){
        service.removeLocataire(email);
    }

}
