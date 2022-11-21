package ca.bdeb.projetsynthese.dto;

import ca.bdeb.projetsynthese.models.SecteurDeHebergement;
import ca.bdeb.projetsynthese.models.TypeDeHebergement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CritereHebergement {
    private int id;
    private float prix;
    private float fraisDeNettoyage;
    private float fraisDeService;
    private float etatDeHebergement;
    private int typeDeHebergementId;
    private int secteurDeHebergementId;
    private LocalDate dateDeArrive;
    private LocalDate dateDeDepart;
}
