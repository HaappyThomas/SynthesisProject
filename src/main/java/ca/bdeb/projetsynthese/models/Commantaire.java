package ca.bdeb.projetsynthese.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

/**
 * Created by Thomas Wang on 10/27/2022.
 */
@Entity
@Table(name = "Commantaire")
@Validated
public class Commantaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commantaire", columnDefinition = "varchar(200)")
    @Length(min=0, max=200, message="Commantaire doit entre 0 et 200 characters")
    private String commantaire;


    @Column(name = "etatDeCommantaire", columnDefinition = "boolean DEFAULT true")
    private boolean etatDeCommantaire;

    /** relation **/
    // relation(1:n) Locataire(1) <===> Commantaire(n)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emailLocataire",
                referencedColumnName = "emailLocataire",
                columnDefinition = "varchar(50)")
    private Locataire locataire;
    /** fin relation **/

    // constructor
    public Commantaire() {
    }

    public Commantaire(String commantaire,
                       boolean etatDeCommantaire,
                       Locataire locataire) {
        this.commantaire = commantaire;
        this.etatDeCommantaire = etatDeCommantaire;
        this.locataire = locataire;
    }

    public int getId() {
        return id;
    }

    public String getCommantaire() {
        return commantaire;
    }

    public void setCommantaire(String commantaire) {
        this.commantaire = commantaire;
    }

    public boolean isEtatDeCommantaire() {
        return etatDeCommantaire;
    }

    public void setEtatDeCommantaire(boolean etatDeCommantaire) {
        this.etatDeCommantaire = etatDeCommantaire;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    @Override
    public String toString() {
        return "Commantaire{" +
                "id=" + id +
                ", commantaire='" + commantaire + '\'' +
                ", etatDeCommantaire=" + etatDeCommantaire +
                ", locataire=" + locataire +
                '}';
    }
}
