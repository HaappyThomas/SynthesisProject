package ca.bdeb.projetsynthese.models;

import ca.bdeb.projetsynthese.dto.HebergementDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hebergement")
@Validated
public class Hebergement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "prix", columnDefinition = "float(10) DEFAULT 0.00")
    @Min(value = 0, message = "Le prix doit  etre supérieur 0")
    private float prix;

    @NotNull
    @Column(name = "fraisDeNettoyage", columnDefinition = "float(10) DEFAULT 0.00")
    @Min(value = 0, message = "Le frais de nettoyage doit supérieur 0")
    private float fraisDeNettoyage;

    @NotNull
    @Column(name = "fraisDeService", columnDefinition = "float(10) DEFAULT 0.00")
    @Min(value = 0, message = "Le frais de service doit supérieur 0")
    private float fraisDeService;

    @Column(name = "repertoireDePhoto", columnDefinition = "varchar(100)")
    @Length(min = 0, max = 100, message = "Le longueur de repertoire de photo doit entre 0 et 100")
    private String repertoireDePhoto;

    @Column(name = "etatDeHebergement", columnDefinition = "boolean DEFAULT true")
    private boolean etatDeHebergement;

    /**
     * relation
     **/
    // relation(1:1) Hebergement(1) ===> Adresse(1)
    @OneToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;

    // relation(1:n) Proprietaire(1) <===> Hebergement(n)
    @ManyToOne
    @JoinColumn(name = "emailProprietaire",
            referencedColumnName = "emailProprietaire",
            columnDefinition = "varchar(50)")
    private Proprietaire proprietaire;

    // relation(1:1) Hebergement(1) ===> TypeDeHebergement(1)
    @OneToOne
    @JoinColumn(name = "idTypeDeHebergement")
    private TypeDeHebergement typeDeHebergement;

    // relation(1:1) Hebergement(1) ===> SecteurDeHebergement(1)
    @OneToOne
    @JoinColumn(name = "idSecteurDeHebergement")
    private SecteurDeHebergement secteurDeHebergement;

    // relation(1:n) Hebergement(1) <===> IndisponibiliteDeLogement(n)
    @OneToMany(mappedBy = "hebergement")
    @JsonIgnore
//    @JsonIgnoreProperties(value ={"hebergement"})
    private List<IndisponibiliteDeLogement> indisponibiliteDeLogementList = new ArrayList<>();

    // translate to HebergementDTO
    public HebergementDTO asDTO(){
        return new HebergementDTO(this.id, this.prix,this.fraisDeNettoyage,
                this.fraisDeService, this.repertoireDePhoto, this.etatDeHebergement,
                this.adresse, this.typeDeHebergement, this.secteurDeHebergement,
                null);
    }

    /**
     private List<IndisponibiliteDeLogement> indisponibiliteDeLogementList = new AbstractList<IndisponibiliteDeLogement>()
     {
     @Override public IndisponibiliteDeLogement get(int index) {
     return null;
     }

     @Override public int size() {
     return 0;
     }
     };
     **/

    /** fin relation **/

    // constructor without id
    public Hebergement(float prix, float fraisDeNettoyage, float fraisDeService, String repertoireDePhoto, boolean etatDeHebergement, Adresse adresse, Proprietaire proprietaire, TypeDeHebergement typeDeHebergement, SecteurDeHebergement secteurDeHebergement, List<IndisponibiliteDeLogement> indisponibiliteDeLogementList) {
        this.prix = prix;
        this.fraisDeNettoyage = fraisDeNettoyage;
        this.fraisDeService = fraisDeService;
        this.repertoireDePhoto = repertoireDePhoto;
        this.etatDeHebergement = etatDeHebergement;
        this.adresse = adresse;
        this.proprietaire = proprietaire;
        this.typeDeHebergement = typeDeHebergement;
        this.secteurDeHebergement = secteurDeHebergement;
        this.indisponibiliteDeLogementList = indisponibiliteDeLogementList;
    }

    /**
     // constructor
     public Hebergement() {
     }

     public Hebergement(int id, float prix, float fraisDeNettoyage, float fraisDeService, String repertoireDePhoto, boolean etatDeHebergement, Adresse adresse, Proprietaire proprietaire, TypeDeHebergement typeDeHebergement, SecteurDeHebergement secteurDeHebergement) {

     this.id = id;
     this.prix = prix;
     this.fraisDeNettoyage = fraisDeNettoyage;
     this.fraisDeService = fraisDeService;
     this.repertoireDePhoto = repertoireDePhoto;
     this.etatDeHebergement = etatDeHebergement;
     this.adresse = adresse;
     this.proprietaire = proprietaire;
     this.typeDeHebergement = typeDeHebergement;
     this.secteurDeHebergement = secteurDeHebergement;
     }

     public Hebergement(float prix,
     float fraisDeNettoyage,
     float fraisDeService,
     String repertoireDePhoto,
     boolean etatDeHebergement,
     Adresse adresse,
     Proprietaire proprietaire,
     TypeDeHebergement typeDeHebergement,
     SecteurDeHebergement secteurDeHebergement,
     List<IndisponibiliteDeLogement> indisponibiliteDeLogementList) {
     this.prix = prix;
     this.fraisDeNettoyage = fraisDeNettoyage;
     this.fraisDeService = fraisDeService;
     this.repertoireDePhoto = repertoireDePhoto;
     this.etatDeHebergement = etatDeHebergement;
     this.adresse = adresse;
     this.proprietaire = proprietaire;
     this.typeDeHebergement = typeDeHebergement;
     this.secteurDeHebergement = secteurDeHebergement;
     this.indisponibiliteDeLogementList = indisponibiliteDeLogementList;
     }

     public int getId() {
     return id;
     }

     public float getPrix() {
     return prix;
     }

     public void setPrix(float prix) {
     this.prix = prix;
     }

     public float getFraisDeNettoyage() {
     return fraisDeNettoyage;
     }

     public void setFraisDeNettoyage(float fraisDeNettoyage) {
     this.fraisDeNettoyage = fraisDeNettoyage;
     }

     public float getFraisDeService() {
     return fraisDeService;
     }

     public void setFraisDeService(float fraisDeService) {
     this.fraisDeService = fraisDeService;
     }

     public String getRepertoireDePhoto() {
     return repertoireDePhoto;
     }

     public void setRepertoireDePhoto(String repertoireDePhoto) {
     this.repertoireDePhoto = repertoireDePhoto;
     }

     public boolean isEtatDeHebergement() {
     return etatDeHebergement;
     }

     public void setEtatDeHebergement(boolean etatDeHebergement) {
     this.etatDeHebergement = etatDeHebergement;
     }

     public Adresse getAdresse() {
     return adresse;
     }

     public void setAdresse(Adresse adresse) {
     this.adresse = adresse;
     }

     public Proprietaire getProprietaire() {
     return proprietaire;
     }

     public void setProprietaire(Proprietaire proprietaire) {
     this.proprietaire = proprietaire;
     }

     public TypeDeHebergement getTypeDeHebergement() {
     return typeDeHebergement;
     }

     public void setTypeDeHebergement(TypeDeHebergement typeDeHebergement) {
     this.typeDeHebergement = typeDeHebergement;
     }

     public SecteurDeHebergement getSecteurDeHebergement() {
     return secteurDeHebergement;
     }

     public void setSecteurDeHebergement(SecteurDeHebergement secteurDeHebergement) {
     this.secteurDeHebergement = secteurDeHebergement;
     }

     public List<IndisponibiliteDeLogement> getDisponibiliteDeLogementList() {
     return indisponibiliteDeLogementList;
     }

     public void setDisponibiliteDeLogementList(List<IndisponibiliteDeLogement> indisponibiliteDeLogementList) {
     this.indisponibiliteDeLogementList = indisponibiliteDeLogementList;
     }

     @Override public String toString() {
     return "Hebergement{" +
     "id=" + id +
     ", prix=" + prix +
     ", fraisDeNettoyage=" + fraisDeNettoyage +
     ", fraisDeService=" + fraisDeService +
     ", repertoireDePhoto='" + repertoireDePhoto + '\'' +
     ", etatDeHebergement=" + etatDeHebergement +
     ", adresse=" + adresse +
     ", proprietaire=" + proprietaire +
     ", typeDeHebergement=" + typeDeHebergement +
     ", secteurDeHebergement=" + secteurDeHebergement +
     ", indisponibiliteDeLogementList=" + indisponibiliteDeLogementList +
     '}';
     }
     **/
}
