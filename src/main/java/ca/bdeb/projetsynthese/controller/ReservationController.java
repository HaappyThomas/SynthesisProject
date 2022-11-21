package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Reservation;
import ca.bdeb.projetsynthese.services.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
@Api(tags = "API pour reservation")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping("/list")
    @ApiOperation("Récupérer la liste de reservations")
    public List<Reservation> getList() {
        return service.getList();
    }

    @GetMapping("/{numero}")
    @ApiOperation("Récupérer une reservation par numero")
    public Reservation getByNumero(@PathVariable("numero") Integer numero) {
        return service.getByNumero(numero);
    }

    @PostMapping("/add")
    @ApiOperation("Ajouter une reservation")
    public Reservation add(@RequestBody Reservation reservation) {
        return service.add(reservation);
    }

    @PutMapping("/update")
    @ApiOperation("Modifier une reservation")
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping("/delete/{numero}")
    @ApiOperation("Supprimer une reservation par numero")
    public void delete(@PathVariable Integer numero) {
        service.delete(numero);
    }

}

