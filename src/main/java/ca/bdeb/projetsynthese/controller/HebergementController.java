package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.dto.CritereHebergement;
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
    private HebergementService service;

    @ApiOperation(value = "Récupérer la list des hebergements")
    @GetMapping("/list")
    public List<Hebergement> getList()  {
        return service.getList();
    }

    @ApiOperation(value = "Récupérer l'hebergement spécifié par id")
    @GetMapping("/{id}")
    public Hebergement getById(@ApiParam("Hebergement Id") @PathVariable int id){
        return service.getById(id);
    }

    @ApiOperation(value = "Ajouter un nouvel hebergement")
    @PostMapping("/add")
    public Hebergement add(@RequestBody Hebergement hebergement){
        return service.add(hebergement);
    }

    @ApiOperation(value = "Modifer un hebergement")
    @PutMapping("/update")
    public Hebergement update(@RequestBody Hebergement hebergement){
        return service.update(hebergement);
    }

    @ApiOperation(value = "Supprimer un hebergement")
    @DeleteMapping("/delete/{id}")
    public void delete(@ApiParam("Hebergement Id") @PathVariable Integer id){
        service.delete(id);
    }

    @ApiOperation(value = "Récupérer la liste de l'hébergement par requête critère")
    @GetMapping("/critere")
    public List<Hebergement> list(@RequestBody CritereHebergement critereHebergement){
        return service.getListByCriteria(critereHebergement);
    }


}
