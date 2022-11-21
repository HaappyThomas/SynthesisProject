package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Proprietaire;
import ca.bdeb.projetsynthese.services.ProprietaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API pour proprietaire")
@RestController
@RequestMapping("api/v1/proprietaire")
public class ProprietaireController {
    @Autowired
    private ProprietaireService service;

    @ApiOperation(value = "Récupérer la list de proprietaire")
    @GetMapping("/list")
    public List<Proprietaire> getList() {
        return service.getList();
    }

    @ApiOperation(value = "Récupérer un proprietaire par email")
    @GetMapping("/{email}")
    public Proprietaire getByEmail(
            @ApiParam("email proprietaire") @PathVariable("email") String email) {
        return service.getByEmail(email);
    }

    @ApiOperation(value = "Ajouter un proprietaire")
    @PostMapping("/add")
    public Proprietaire add(@RequestBody Proprietaire proprietaire) {
        return service.add(proprietaire);
    }

    @ApiOperation(value = "Update un proprietaire")
    @PutMapping("/update")
    public Proprietaire update(@RequestBody Proprietaire proprietaire) {
        return service.update(proprietaire);
    }

    @ApiOperation(value = "Supprimer un proprietaire")
    @DeleteMapping("/delete/{email}")
    public void delete(@ApiParam("proprietaire email") @PathVariable("email") String email) {
       service.delete(email);
    }

}

