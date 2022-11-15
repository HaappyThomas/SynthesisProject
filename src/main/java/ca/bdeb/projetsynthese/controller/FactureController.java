package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Facture;
import ca.bdeb.projetsynthese.services.FactureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/facture")
@Api(tags = "API pour Facture")
public class FactureController {
    @Autowired
    private FactureService service;

    @GetMapping("/list")
    @ApiOperation("Récupérer la liste de facture")
    public List<Facture> getFactureList() {
        return service.getFactureList();
    }

    @GetMapping("/{numero}")
    @ApiOperation("Récupérer une facture par numero")
    public Facture getFactureByNumero(@PathVariable("numero") Integer numero) {
        return service.getByNumro(numero);
    }

    @PostMapping("/add")
    @ApiOperation("Ajouter une facture")
    public Facture addFacture(@RequestBody Facture facture) {
        return service.addFacture(facture);
    }

    @PutMapping("/update")
    @ApiOperation("Modifier la facture")
    private Facture updateFacture(@RequestBody Facture facture) {
        return service.updateFacture(facture);
    }

    @DeleteMapping("/delete/{numero}")
    @ApiOperation("Supprimer une facture")
    public void deleteFacture(@PathVariable Integer numero) {
        service.deleteFacture(numero);
    }

}
