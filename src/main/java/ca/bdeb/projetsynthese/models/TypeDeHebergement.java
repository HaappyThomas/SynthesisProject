package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "TypeDeHebergement")
@Validated
@ApiModel(value = "TypeDeHebergement Entity")
public class TypeDeHebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "TypeDeHebergement id")
    private int id;

    @Length(min = 1, max = 50, message = "La longueur de type doit entre 1 et 50")
    @Column(name = "typeDeHebergement", columnDefinition = "varchar(50)")
    @ApiModelProperty(value = "Type De Hebergement")
    private String typeDeHebergement;

    // constructor
    public TypeDeHebergement() {
    }

    public TypeDeHebergement(String typeDeHebergement) {
        this.typeDeHebergement = typeDeHebergement;
    }

    public int getId() {
        return id;
    }

    public String getTypeDeHebergement() {
        return typeDeHebergement;
    }

    public void setTypeDeHebergement(String typeDeHebergement) {
        this.typeDeHebergement = typeDeHebergement;
    }

    @Override
    public String toString() {
        return "TypeDeHebergement{" +
                "id=" + id +
                ", typeDeHebergement='" + typeDeHebergement + '\'' +
                '}';
    }
}
