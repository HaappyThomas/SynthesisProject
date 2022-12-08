package ca.bdeb.projetsynthese.models;

import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "IndisponibiliteDeLogement")
@Validated
@ApiModel(value = "DisponibiliteDeLogement Entity")
public class IndisponibiliteDeLogement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = " indisponibiliteDeLogementList id")
    private int id;

    @NotNull(message="La date de début est obligatoire")
    @Column(name = "debutDeDateDeIndisponibilite")
    @ApiModelProperty(value = " debutDeDateDeIndisponibilite")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDeDateDeIndisponibilite;

    @NotNull(message="La date de départ est obligatoire")
    @Column(name = "finDeDateDeIndisponibilite")
    @ApiModelProperty(value = " finDeDateDeIndisponibilite")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finDeDateDeIndisponibilite;

    /** relation **/
    // relation(n:1) DisponibiliteDelogement(n) <===> Herbergement(1)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idHebergement",
                referencedColumnName = "id")
    private Hebergement hebergement;
    /** fin relation **/

    // constructor without id
    public IndisponibiliteDeLogement(LocalDate debutDeDateDeIndisponibilite, LocalDate finDeDateDeIndisponibilite, Hebergement hebergement) {
        this.debutDeDateDeIndisponibilite = debutDeDateDeIndisponibilite;
        this.finDeDateDeIndisponibilite = finDeDateDeIndisponibilite;
        this.hebergement = hebergement;
    }

    IndisponibiliteDeLogementDTO asDTO(){
        return new IndisponibiliteDeLogementDTO(this.id,this.debutDeDateDeIndisponibilite,this.finDeDateDeIndisponibilite);
    }

    /**
    // constructor
    public DisponibiliteDeLogement() {
    }

    public DisponibiliteDeLogement(Date debutDeDateDeDisponibilite,
                                   Date finDeDateDeDisponibilite,
                                   Hebergement hebergement) {
        this.debutDeDateDeDisponibilite = debutDeDateDeDisponibilite;
        this.finDeDateDeDisponibilite = finDeDateDeDisponibilite;
        this.hebergement = hebergement;
    }

    public int getId() {
        return id;
    }

    public Date getDebutDeDateDeDisponibilite() {
        return debutDeDateDeDisponibilite;
    }

    public void setDebutDeDateDeDisponibilite(Date debutDeDateDeDisponibilite) {
        this.debutDeDateDeDisponibilite = debutDeDateDeDisponibilite;
    }

    public Date getFinDeDateDeDisponibilite() {
        return finDeDateDeDisponibilite;
    }

    public void setFinDeDateDeDisponibilite(Date finDeDateDeDisponibilite) {
        this.finDeDateDeDisponibilite = finDeDateDeDisponibilite;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    @Override
    public String toString() {
        return "DisponibiliteDeLogement{" +
                "id=" + id +
                ", debutDeDateDeDisponibilite=" + debutDeDateDeDisponibilite +
                ", finDeDateDeDisponibilite=" + finDeDateDeDisponibilite +
                ", hebergement=" + hebergement +
                '}';
    }
    **/
}
