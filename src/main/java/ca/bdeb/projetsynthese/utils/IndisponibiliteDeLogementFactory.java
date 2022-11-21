package ca.bdeb.projetsynthese.utils;

import ca.bdeb.projetsynthese.models.IndisponibiliteDeLogement;
import ca.bdeb.projetsynthese.models.Reservation;

public class IndisponibiliteDeLogementFactory {

    public static IndisponibiliteDeLogement getInstance(Reservation reservation) {
        IndisponibiliteDeLogement instance = new IndisponibiliteDeLogement();

        instance.setDebutDeDateDeIndisponibilite(reservation.getDateDeArrive());
        instance.setFinDeDateDeIndisponibilite(reservation.getDateDeDepart());
        instance.setHebergement(reservation.getHebergement());

        return instance;
    }
}
