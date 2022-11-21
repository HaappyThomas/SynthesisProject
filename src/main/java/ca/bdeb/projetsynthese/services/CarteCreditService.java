package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.ICarteCreditRepository;
import ca.bdeb.projetsynthese.models.CarteCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteCreditService {
    @Autowired
    private ICarteCreditRepository repository;

    // get all credit cards
    public List<CarteCredit> getCreditList(){
        return repository.findAll();
    }

    // get credit card by nember
    public CarteCredit getCarteCreditByNumero(String numero) {
        return repository.findByNumero(numero);
    }

    // add a new credit card
    public CarteCredit addCarteCredit(CarteCredit carteCredit) {
        return repository.save(carteCredit);
    }
    // update a credit card
    public CarteCredit updateCarteCredit(CarteCredit carteCredit) {
        return repository.save(carteCredit);
    }
    // delete a credit card
    public void deleteCarteCreditByNumero(CarteCredit carteCredit) {
        repository.delete(carteCredit);
    }
}
