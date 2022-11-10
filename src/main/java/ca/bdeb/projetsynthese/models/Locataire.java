package ca.bdeb.projetsynthese.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas Wang on 10/26/2022.
 */
@Entity
@Table(name = "Locataire")
// for verifying the data
@Validated
public class Locataire {
    @Id
    @Column(name = "emailLocataire", columnDefinition = "varchar(50)")
    @Email(message = "The email address is not a valid email address")
    private String emailLocataire;

    @NotNull
    @Column(name = "motDePasse", columnDefinition = "varchar(25)")
    @Length(min = 6, max = 25, message="La longueur de la mot de passe doit entre 6 et 25")
    private String motDePasse;

    @Column(name = "nom", columnDefinition = "varchar(50)")
    @Length(min = 6, max = 50, message="La longueur du nom doit entre 6 et 50")
    private String nom;

    @Column(name = "prenom", columnDefinition = "varchar(50)")
    @Length(min = 6, max = 50, message="La longueur du prénom doit entre 6 et 50")
    private String prenom;

    @Column(name = "telephone", columnDefinition = "varchar(25)")
    @Length(min = 0, max = 25, message="La longueur du téléphone doit entre 0 et 25")
    private String telephone;

    @Column(name = "etatDeLocataire", columnDefinition = "boolean DEFAULT true")
    private boolean etatDeLocataire;

    /**
     * relation
     **/
    // relation(1:1) Locataire(1) ===> Adresse(1)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdresse", referencedColumnName = "id")
    private Adresse adresse;

    // relation(1:n) Locataire(1) <===> Commantaire(n)
    @OneToMany(mappedBy = "locataire",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Commantaire> commantaireList = new ArrayList<>();

    // relation(1:n) Locataire(1) <===> Facture(n)
    @OneToMany(mappedBy = "locataire",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Facture> factureList = new ArrayList<>();

    // relation(1:n) Locataire(1) <===> Reservation(n)
    @OneToMany(mappedBy = "locataire",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    /**
     * fin relation
     **/

    // constructor
    public Locataire() {
    }

    public Locataire(String motDePasse,
                     String nom,
                     String prenom,
                     String telephone,
                     boolean etatDeLocataire,
                     Adresse adresse,
                     List<Commantaire> commantaireList,
                     List<Facture> factureList,
                     List<Reservation> reservationList) {
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.etatDeLocataire = etatDeLocataire;
        this.adresse = adresse;
        this.commantaireList = commantaireList;
        this.factureList = factureList;
        this.reservationList = reservationList;
    }

    public String getEmailLocataire() {
        return emailLocataire;
    }

    public void setEmailLocataire(String emailLocataire) {
        this.emailLocataire = emailLocataire;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isEtatDeLocataire() {
        return etatDeLocataire;
    }

    public void setEtatDeLocataire(boolean etatDeLocataire) {
        this.etatDeLocataire = etatDeLocataire;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Commantaire> getCommantaireList() {
        return commantaireList;
    }

//    public void setCommantaireList(List<Commantaire> commantaireList) {
//        this.commantaireList = commantaireList;
//    }

    public List<Facture> getFactureList() {
        return factureList;
    }

//    public void setFactureList(List<Facture> factureList) {
//        this.factureList = factureList;
//    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

//    public void setReservationList(List<Reservation> reservationList) {
//        this.reservationList = reservationList;
//    }

    @Override
    public String toString() {
        return "Locataire{" +
                "emailLocataire='" + emailLocataire + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", etatDeLocataire=" + etatDeLocataire +
                ", adresse=" + adresse +
                '}';
    }
}
