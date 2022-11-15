package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Commantaire;
import ca.bdeb.projetsynthese.services.CommentaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/commentaire")
@Api(tags = "API pour Commentaire")
public class CommantaireController {
    @Autowired
    private CommentaireService service;

    @GetMapping("/list")
    @ApiOperation("Récupérer la liste de commentaire")
    public List<Commantaire> getCommantaireList() {
        return service.getCommantaireList();
    }

    @GetMapping("/{id}")
    @ApiOperation("Récupérer une commentaire")
    public Commantaire getCommantaireById(@ApiParam("Comment Id") @PathVariable("id") Integer id) {
        return service.getCommantaire(id);
    }

    @PostMapping("/add")
    @ApiOperation("Ajouter une commentaire")
    public Commantaire addCommantaire(@RequestBody Commantaire commantaire){
        return service.addCommantaire(commantaire);
    }

    @PutMapping("/update")
    @ApiOperation("Modifie une commentaire")
    public Commantaire updateCommantaire(@RequestBody Commantaire commantaire){
       return service.updateCommantaire(commantaire);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Supprimer une commantaire")
    public void deleteCommantaire(@ApiParam("Comment Id") @PathVariable("id") Integer id){
        service.deleteCommantaire(id);
    }

}
