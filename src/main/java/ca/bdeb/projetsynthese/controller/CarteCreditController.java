package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.CarteCredit;
import ca.bdeb.projetsynthese.services.CarteCreditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/carteCredit")
@Api(tags = "API pour CarteCredit")
public class CarteCreditController {
    @Autowired
    private CarteCreditService carteCreditService;

    // get the credit card list
    @GetMapping("/list")
    @ApiOperation("Récupérer la list de carteCredit")
    public List<CarteCredit> getCarteCreditList(){
        return carteCreditService.getCreditList();
    }

    // get a sepecfic credit card by number
    @GetMapping("/{numero}")
    @ApiOperation("Récupérer la carteCredit par numero")
    public CarteCredit getCarteCredit(@ApiParam("Credit card number") @PathVariable("numero") String numero) {
        return carteCreditService.getCarteCreditByNumero(numero);
    }

    // add a new credit card
    @PostMapping("/add")
    @ApiOperation("Ajouter un carteCredit")
    public CarteCredit addCarteCredit(@RequestBody CarteCredit carteCredit) {
        return carteCreditService.addCarteCredit(carteCredit);
    }

    // update a carte credit
    @PutMapping("/update")
    @ApiOperation("Modifier la carteCredit")
    public CarteCredit updateCarteCredit(@RequestBody CarteCredit carteCredit) {
        return carteCreditService.updateCarteCredit(carteCredit);
    }

    // delete a carte credit
    @DeleteMapping("/delete/{numero}")
    @ApiOperation("Supprimer la carteCredit")
    public void deleteCarteCredit(@ApiParam("Credit card number") @PathVariable("numero") String numero) {

        carteCreditService.deleteCarteCreditByNumero(carteCreditService.getCarteCreditByNumero(numero));
    }



}
