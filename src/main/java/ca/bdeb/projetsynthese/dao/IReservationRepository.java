package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findByNumeroDeReservation(Integer nemero);
}
