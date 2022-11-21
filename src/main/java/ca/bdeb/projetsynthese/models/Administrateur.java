package ca.bdeb.projetsynthese.models;


//import org.hibernate.validator.constraints.Length;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Administrateur")
@Validated
@ApiModel(value = "Administrateur Entity")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "Administrateur Id")
    private int id;

    @NotNull
    @Column(name = "nomAdministrateur", columnDefinition= "varchar(50)")
    @Length(min=3, max=50, message="Length of name must be between 3 and 50 characters")
    @ApiModelProperty(value = "Administrateur name")
    private String nomAdministrateur;

    @NotNull
    @Column(name = "motDePasse", columnDefinition = "varchar(25)")
    @Length(min=6, max=50, message="Length of password must be between 6 and 50 characters")
    @ApiModelProperty(value = "Mot de passe d'administrateur")
    private String motDePasse;

    /**
    // constructor
    public Administrateur() {
    }

    public Administrateur(String nomAdministrateur, String motDePasse) {
        this.nomAdministrateur = nomAdministrateur;
        this.motDePasse = motDePasse;
    }

    // setter and getter
    public int getId() {
        return id;
    }

    public String getNomAdministrateur() {
        return nomAdministrateur;
    }

    public void setNomAdministrateur(String nomAdministrateur) {
        this.nomAdministrateur = nomAdministrateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + id +
                ", nomAdministrateur='" + nomAdministrateur + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
    **/

}
