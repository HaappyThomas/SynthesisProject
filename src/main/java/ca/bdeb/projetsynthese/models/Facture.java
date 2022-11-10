package ca.bdeb.projetsynthese.models;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by Thomas Wang on 10/27/2022.
 */
@Entity
@Table(name = "Facture")
@Validated
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroDeFacture;

    @Min(value = 0, message = "La somme de séjour supérieur 0")
    @Column(name = "sommeDeSejout", columnDefinition = "float(10) DEFAULT 0.00")
    private float sommeDeSejout;

    @Min(value = 0, message = "Le frais de nettoyage supérieur 0")
    @Column(name = "fraisDeNettoyage", columnDefinition="float(10) DEFAULT 0.00")
    private float fraisDeNettoyage;

    @Min(value = 0, message = "Le frais de service supérieur 0")
    @Column(name = "fraisDeService", columnDefinition="float(10) DEFAULT 0.00")
    private float fraisDeService;

    @Min(value = 0, message = "Le tax supérieur 0")
    @Column(name = "tax", columnDefinition= "float(10) DEFAULT 0.00")
    private float tax;

    @Min(value = 0, message = "La somme totale supérieur 0")
    @Column(name = "total", columnDefinition="float(10) DEFAULT 0.00")
    private float total;

    /** relation **/
    // relation(1:n) Locataire(1) <===> Facture(n)
    @ManyToOne
    @JoinColumn(name = "emailLocataire",
                referencedColumnName = "emailLocataire",
                columnDefinition="varchar(50)")
    private Locataire locataire;

    // relation(1:1) Reservation(1) <===> Facture(1)
    @OneToOne(mappedBy = "facture")
    private Reservation reservation;
    /** fin relation **/

    // constructor
    public Facture() {
    }

    public Facture(float sommeDeSejout,
                   float fraisDeNettoyage,
                   float fraisDeService,
                   float tax,
                   float total,
                   Locataire locataire,
                   Reservation reservation) {
        this.sommeDeSejout = sommeDeSejout;
        this.fraisDeNettoyage = fraisDeNettoyage;
        this.fraisDeService = fraisDeService;
        this.tax = tax;
        this.total = total;
        this.locataire = locataire;
        this.reservation = reservation;
    }

    public int getNumeroDeFacture() {
        return numeroDeFacture;
    }

    public float getSommeDeSejout() {
        return sommeDeSejout;
    }

    public void setSommeDeSejout(float sommeDeSejout) {
        this.sommeDeSejout = sommeDeSejout;
    }

    public float getFraisDeNettoyage() {
        return fraisDeNettoyage;
    }

    public void setFraisDeNettoyage(float fraisDeNettoyage) {
        this.fraisDeNettoyage = fraisDeNettoyage;
    }

    public float getFraisDeService() {
        return fraisDeService;
    }

    public void setFraisDeService(float fraisDeService) {
        this.fraisDeService = fraisDeService;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "numeroDeFacture=" + numeroDeFacture +
                ", sommeDeSejout=" + sommeDeSejout +
                ", fraisDeNettoyage=" + fraisDeNettoyage +
                ", fraisDeService=" + fraisDeService +
                ", tax=" + tax +
                ", total=" + total +
                ", locataire=" + locataire +
                '}';
    }
}
