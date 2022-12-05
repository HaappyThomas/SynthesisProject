package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findByNumeroDeReservation(Integer nemero);

    @Query("select r from Reservation r where r.locataire.emailLocataire = ?1")
    List<Reservation> getListByEmail(String email);
}
