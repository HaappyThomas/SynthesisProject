package ca.bdeb.projetsynthese.dto;

import ca.bdeb.projetsynthese.models.Adresse;
import ca.bdeb.projetsynthese.models.IndisponibiliteDeLogement;
import ca.bdeb.projetsynthese.models.SecteurDeHebergement;
import ca.bdeb.projetsynthese.models.TypeDeHebergement;
import ca.bdeb.projetsynthese.vo.HebergementVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HebergementDTO {
    private int id;
    private float prix;
    private float fraisDeNettoyage;
    private float fraisDeService;
    private String repertoireDePhoto;
    private boolean etatDeHebergement;

    private Adresse adresse;
    private TypeDeHebergement typeDeHebergement;
    private SecteurDeHebergement secteurDeHebergement;
    private List<IndisponibiliteDeLogementDTO> indisponibiliteDeLogementListDTO = new ArrayList<>();

    public HebergementVO asVO()
    {
        return new HebergementVO(this.id, this.prix,this.fraisDeNettoyage,
        this.fraisDeNettoyage,this.repertoireDePhoto,this.etatDeHebergement);
    }
}
