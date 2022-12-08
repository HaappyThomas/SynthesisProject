package ca.bdeb.projetsynthese.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProprietaireDTO {
    private String emailProprietaire;

    private String motDePasse;

    private String nom;

    private String prenom;

    private String telephone;

}
