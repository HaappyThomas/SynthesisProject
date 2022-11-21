package ca.bdeb.projetsynthese.utils;

import ca.bdeb.projetsynthese.models.CarteCredit;
import ca.bdeb.projetsynthese.models.Reservation;

public class CarteCreditFactory {

    public static CarteCredit getInstance(Reservation reservation) {
        return new CarteCredit(reservation.getCarteCredit().getNumero(),
                reservation.getCarteCredit().getExpiration());
    }
}
