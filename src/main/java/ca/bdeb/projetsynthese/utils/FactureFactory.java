package ca.bdeb.projetsynthese.utils;

import ca.bdeb.projetsynthese.models.Facture;
import ca.bdeb.projetsynthese.models.Reservation;

public class FactureFactory {
    private static final float TAUX_TAX = 0.15f;

    public static Facture getInstance(Reservation reservation) {
        Facture facture = new Facture();

        // calculate the somme de sejour
        int jours = (int) (reservation.getDateDeDepart().toEpochDay()
                - reservation.getDateDeArrive().toEpochDay());
        float sommeDeSejour = jours * reservation.getHebergement().getPrix();
        facture.setSommeDeSejour(sommeDeSejour);

        // calculate nettoyage frais
        float nettoyageFrais = reservation.getHebergement().getFraisDeNettoyage();
        facture.setFraisDeNettoyage(nettoyageFrais);

        // calculate service frais
        float serviceFrais = reservation.getHebergement().getFraisDeService();
        facture.setFraisDeService(serviceFrais);

        // calculate tax
        float tax = (sommeDeSejour + nettoyageFrais + serviceFrais) * TAUX_TAX;
        facture.setTax(tax);

        // calculate total
        float total = sommeDeSejour + nettoyageFrais + serviceFrais + tax;
        facture.setTotal(total);

        // to relate locataire
        facture.setLocataire(reservation.getLocataire());

        return facture;
    }
}
