package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CarteCredit")
@Validated
@ApiModel(value = "CarteCredit Entity")
public class CarteCredit {
    @Id
    @Column(name = "numero", columnDefinition = "varchar(25)")
    @Length(min = 12, max = 25, message="number of credit cards must be between 12 and 25")
    @ApiModelProperty(value = "credit card number")
    private String numero;

    @Column(name = "expiration")
    @Future(message = "La date d'expiration doit après aujourd'hui")
    @ApiModelProperty(value = "Expiration date")
    private LocalDate expiration;

    /**
    // constructor
    public CarteCredit() {
    }

    public CarteCredit(String numero, LocalDate expiration) {
        this.numero = numero;
        this.expiration = expiration;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "CarteCredit{" +
                "numero='" + numero + '\'' +
                ", expiration=" + expiration +
                '}';
    }
    **/
}
