package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.CarteCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarteCreditRepository extends JpaRepository<CarteCredit, String> {
    CarteCredit findByNumero(String numero);

}
