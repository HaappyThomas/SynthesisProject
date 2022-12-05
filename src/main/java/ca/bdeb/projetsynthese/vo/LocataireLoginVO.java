package ca.bdeb.projetsynthese.vo;

import ca.bdeb.projetsynthese.models.Locataire;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocataireLoginVO {
    private String message;
    private Locataire locataire;
}
