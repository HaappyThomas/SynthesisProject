package ca.bdeb.projetsynthese.vo;

import ca.bdeb.projetsynthese.models.Administrateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministrateurLoginVO {
    private String message;
    private Administrateur administrateur;
}
