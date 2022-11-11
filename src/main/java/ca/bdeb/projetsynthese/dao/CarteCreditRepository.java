package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.CarteCredit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Thomas Wang on 11/10/2022.
 */
@Repository
public interface CarteCreditRepository extends JpaRepository<CarteCredit, String> {
    CarteCredit findByNumero(String numero);

}
