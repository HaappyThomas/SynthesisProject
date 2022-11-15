package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "SecteurDeHebergement")
@Validated
@ApiModel(value = "SecteurDeHebergement Entity")
public class SecteurDeHebergement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Sector Id")
    private int id;

    @Length(min = 1, max = 50, message = "La longuer de secteur doit entre 1 et 50")
    @Column(name = "secteurDeHebergement", columnDefinition = "varchar(50)")
    @ApiModelProperty("Sector name")
    private String secteurDeHebergement;

    // constructor
    public SecteurDeHebergement() {
    }

    public SecteurDeHebergement(String secteurDeHebergement) {
        this.secteurDeHebergement = secteurDeHebergement;
    }

    public int getId() {
        return id;
    }

    public String getSecteurDeHebergement() {
        return secteurDeHebergement;
    }

    public void setSecteurDeHebergement(String secteurDeHebergement) {
        this.secteurDeHebergement = secteurDeHebergement;
    }

    @Override
    public String toString() {
        return "SecteurDeHebergement{" +
                "id=" + id +
                ", secteurDeHebergement='" + secteurDeHebergement + '\'' +
                '}';
    }
}
