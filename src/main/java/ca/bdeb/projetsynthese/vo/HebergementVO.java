package ca.bdeb.projetsynthese.vo;

import ca.bdeb.projetsynthese.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HebergementVO {
    private int id;
    private float prix;
    private float fraisDeNettoyage;
    private float fraisDeService;
    private String repertoireDePhoto;
    private boolean etatDeHebergement;
}
