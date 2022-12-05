package ca.bdeb.projetsynthese.vo;

import ca.bdeb.projetsynthese.models.Proprietaire;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProprietaireLoginVO {
    private String message;
    private Proprietaire proprietaire;
}
