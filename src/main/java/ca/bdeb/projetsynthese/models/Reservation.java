package ca.bdeb.projetsynthese.models;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Thomas Wang on 10/27/2022.
 */
@Entity
@Table(name = "Reservation")
@Validated
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroDeReservation;

    @NotNull(message = "La date d'arrivé est obligatoire")
    @Future(message = "La date d'arrivé doit être après aujourd'hui")
    @Column(name = "dateDeArrive")
    private Date dateDeArrive;

    @NotNull(message = "La date de départ est obligatoire")
    @Column(name = "dateDeDepart")
    @Future(message = "La date de départ doit être après aujourd'hui")
    private Date dateDeDepart;

    @NotNull(message="Le nombre de l'adulte est obligatoire")
    @Min(1)
    @Column(name = "nombreAdulte")
    private int nombreAdulte;

    @Column(name = "nombreEnfant", columnDefinition="int DEFAULT 0")
    @Min(0)
    private int nombreEnfant;

    @Column(name = "nombreBebe", columnDefinition="int DEFAULT 0")
    @Min(0)
    private int nombreBebe;

    @Column(name = "nombreAnimauxAssistance", columnDefinition="int DEFAULT 0")
    @Min(0)
    private int nombreAnimauxAssistance;

    @Column(name = "etatReservation", columnDefinition="boolean DEFAULT true")
    private boolean etatReservation;

    /** relation **/
    // relation(1:n) Reservation(1) <===> Locataire(n)
    @ManyToOne
    @JoinColumn(name = "emailLocataire",
                referencedColumnName = "emailLocataire",
                columnDefinition = "varchar(50)")
    private Locataire locataire;

    // relation(1:1) Reservation(1) ===> Hebergement(1)
    @OneToOne
    @JoinColumn(name = "idHebergement",
                referencedColumnName = "id")
    private Hebergement hebergement;

    // relation(1:1) Reservation(1) <===> Facture(1)
    @OneToOne
    @JoinColumn(name = "numeroDeFacture",
                referencedColumnName = "numeroDeFacture")
    private Facture facture;

    // relation(1:1) Reservation(1) ===> CarteCredit(1)
    @OneToOne
    @JoinColumn(name = "numeroCarteCredit",
                referencedColumnName = "numero",
                columnDefinition="varchar(25)")
    private CarteCredit carteCredit;
    /** fin relation **/

    // constructor
    public Reservation() {
    }

    public Reservation(Date dateDeArrive,
                       Date dateDeDepart,
                       int nombreAdulte,
                       int nombreEnfant,
                       int nombreBebe,
                       int nombreAnimauxAssistance,
                       boolean etatReservation,
                       Locataire locataire,
                       Hebergement hebergement,
                       Facture facture,
                       CarteCredit carteCredit) {
        this.dateDeArrive = dateDeArrive;
        this.dateDeDepart = dateDeDepart;
        this.nombreAdulte = nombreAdulte;
        this.nombreEnfant = nombreEnfant;
        this.nombreBebe = nombreBebe;
        this.nombreAnimauxAssistance = nombreAnimauxAssistance;
        this.etatReservation = etatReservation;
        this.locataire = locataire;
        this.hebergement = hebergement;
        this.facture = facture;
        this.carteCredit = carteCredit;
    }

    public int getNumeroDeReservation() {
        return numeroDeReservation;
    }

    public Date getDateDeArrive() {
        return dateDeArrive;
    }

    public void setDateDeArrive(Date dateDeArrive) {
        this.dateDeArrive = dateDeArrive;
    }

    public Date getDateDeDepart() {
        return dateDeDepart;
    }

    public void setDateDeDepart(Date dateDeDepart) {
        this.dateDeDepart = dateDeDepart;
    }

    public int getNombreAdulte() {
        return nombreAdulte;
    }

    public void setNombreAdulte(int nombreAdulte) {
        this.nombreAdulte = nombreAdulte;
    }

    public int getNombreEnfant() {
        return nombreEnfant;
    }

    public void setNombreEnfant(int nombreEnfant) {
        this.nombreEnfant = nombreEnfant;
    }

    public int getNombreBebe() {
        return nombreBebe;
    }

    public void setNombreBebe(int nombreBebe) {
        this.nombreBebe = nombreBebe;
    }

    public int getNombreAnimauxAssistance() {
        return nombreAnimauxAssistance;
    }

    public void setNombreAnimauxAssistance(int nombreAnimauxAssistance) {
        this.nombreAnimauxAssistance = nombreAnimauxAssistance;
    }

    public boolean isEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(boolean etatReservation) {
        this.etatReservation = etatReservation;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroDeReservation=" + numeroDeReservation +
                ", dateDeArrive=" + dateDeArrive +
                ", dateDeDepart=" + dateDeDepart +
                ", nombreAdulte=" + nombreAdulte +
                ", nombreEnfant=" + nombreEnfant +
                ", nombreBebe=" + nombreBebe +
                ", nombreAnimauxAssistance=" + nombreAnimauxAssistance +
                ", etatReservation=" + etatReservation +
                ", locataire=" + locataire +
                ", hebergement=" + hebergement +
                ", facture=" + facture +
                ", carteCredit=" + carteCredit +
                '}';
    }
}
