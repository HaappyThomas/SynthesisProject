package ca.bdeb.projetsynthese.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;

/**
 * Created by Thomas Wang on 10/27/2022.
 */
@Entity
@Table(name = "CarteCredit")
@Validated
public class CarteCredit {
    @Id
    @Column(name = "numero", columnDefinition = "varchar(25)")
    @Length(min = 12, max = 25, message="number of credit cards must be between 12 and 25")
    private String numero;

    @Column(name = "expiration")
    @Future(message = "La date d'expiration doit après aujourd'hui")
    private Date expiration;

    // constructor
    public CarteCredit() {
    }

    public CarteCredit(String numero, Date expiration) {
        this.numero = numero;
        this.expiration = expiration;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "CarteCredit{" +
                "numero='" + numero + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}
