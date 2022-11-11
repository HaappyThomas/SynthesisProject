package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.CarteCreditRepository;
import ca.bdeb.projetsynthese.models.CarteCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas Wang on 11/10/2022.
 */
@Service
public class CarteCreditService {
    @Autowired
    private CarteCreditRepository carteCreditRepository;

    // get all credit cards
    public List<CarteCredit> getCreditList(){
        return carteCreditRepository.findAll();
    }

    // get credit card by nember
    public CarteCredit getCarteCreditByNumero(String numero) {
        return carteCreditRepository.findByNumero(numero);
    }

    // add a new credit card
    public CarteCredit addCarteCredit(CarteCredit carteCredit) {
        return carteCreditRepository.save(carteCredit);
    }
    // update a credit card
    public CarteCredit updateCarteCredit(CarteCredit carteCredit) {
        return carteCreditRepository.save(carteCredit);
    }
    // delete a credit card
    public void deleteCarteCreditByNumero(CarteCredit carteCredit) {
        carteCreditRepository.delete(carteCredit);
    }
}
