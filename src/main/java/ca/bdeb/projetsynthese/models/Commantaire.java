package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Commantaire")
@Validated
@ApiModel(value = "Commantaire Entity")
public class Commantaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "commentaire Id")
    private int id;

    @Column(name = "commantaire", columnDefinition = "varchar(200)")
    @Length(min=0, max=200, message="Commantaire doit entre 0 et 200 characters")
    @ApiModelProperty(value = "Commantaire for a logement")
    private String commantaire;


    @Column(name = "etatDeCommantaire", columnDefinition = "boolean DEFAULT true")
    @ApiModelProperty(value = "Status of commantaire: true is valid, false is invalid")
    private boolean etatDeCommantaire;

    /** relation **/
    // relation(1:n) Locataire(1) <===> Commantaire(n)
    @ManyToOne
    @JoinColumn(name = "emailLocataire",
                referencedColumnName = "emailLocataire",
                columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "The locataire who wrote this comment")
    private Locataire locataire;
    /** fin relation **/

    /**
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
    **/

}
