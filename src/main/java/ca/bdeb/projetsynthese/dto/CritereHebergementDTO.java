package ca.bdeb.projetsynthese.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CritereHebergementDTO {
    private float prixMin;
    private float prixMax;
    private int typeDeHebergementId;
    private int secteurDeHebergementId;
    private LocalDate dateDeArrive;
    private LocalDate dateDeDepart;
}
