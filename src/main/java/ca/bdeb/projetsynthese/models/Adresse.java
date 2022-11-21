package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Adresse")
@Validated
@ApiModel(value = "Adresse Entity")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "Adresse Id")
    private int id;

    @NotNull(message = "Le numero de l'adresse est obligatoire")
    @Column(name = "numeroDeRue", columnDefinition = "varchar(25)")
    @ApiModelProperty(value = "Street number")
    private String numeroDeRue;

    @NotNull(message = "La rue est obligatoire")
    @Column(name = "rue", columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "Street name")
    private String rue;

    @Column(name = "ville", columnDefinition = "varchar(50) DEFAULT 'Montreal'")
    @ApiModelProperty(value = "City name")
    private String ville;

    @Column(name = "province", columnDefinition = "varchar(50) DEFAULT 'Quebec'")
    @ApiModelProperty(value = "Province name")
    private String province;

    @Column(name = "pays", columnDefinition = "varchar(50) DEFAULT 'Canada'")
    @ApiModelProperty(value = "Country name")
    private String pays;

    @NotNull(message = "Le code postale est obligatoire")
    @Column(name = "codePostale", columnDefinition = "varchar(25)")
    @ApiModelProperty(value = "postal code")
    private String codePostale;

    // constructor without id
    public Adresse(String numeroDeRue, String rue, String ville, String province, String pays, String codePostale) {
        this.numeroDeRue = numeroDeRue;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
        this.codePostale = codePostale;
    }


    /**
    // constructor
    public Adresse() {
    }

    public Adresse(String numeroDeRue, String rue, String ville, String province, String pays, String codePostale) {
        this.numeroDeRue = numeroDeRue;
        this.rue = rue;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
        this.codePostale = codePostale;
    }

    public int getId() {
        return id;
    }

    public String getNumeroDeRue() {
        return numeroDeRue;
    }

    public void setNumeroDeRue(String numeroDeRue) {
        this.numeroDeRue = numeroDeRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numeroDeRue='" + numeroDeRue + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", province='" + province + '\'' +
                ", pays='" + pays + '\'' +
                ", codePostale='" + codePostale + '\'' +
                '}';
    }
    **/

}
