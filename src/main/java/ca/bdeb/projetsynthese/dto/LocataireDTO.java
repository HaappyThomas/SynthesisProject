package ca.bdeb.projetsynthese.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocataireDTO {
    private String emailLocataire;

    private String motDePasse;

    private String nom;

    private String prenom;

    private String telephone;

}
