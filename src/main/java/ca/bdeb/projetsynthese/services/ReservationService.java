package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.*;
import ca.bdeb.projetsynthese.dto.IndisponibiliteDeLogementDTO;
import ca.bdeb.projetsynthese.models.*;
import ca.bdeb.projetsynthese.utils.CarteCreditFactory;
import ca.bdeb.projetsynthese.utils.FactureFactory;
import ca.bdeb.projetsynthese.utils.IndisponibiliteDeLogementFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private IReservationRepository repository;
    @Autowired
    private ILocataireRepository locataireRepository;
    @Autowired
    private IHebergementRepository hebergementRepository;
    @Autowired
    private IFactureRepository factureRepository;
    @Autowired
    private ICarteCreditRepository carteCreditRepository;
    @Autowired
    private IndisponibiliteDeLogementService indisponibiliteService;
    @Autowired
    private IIndisponibiliteDeLogementRepository indisponibiliteRepository;

    // get reservation list
    public List<Reservation> getList() {
        return repository.findAll();
    }

    // get reservation by numero(id)
    public Reservation getByNumero(Integer numero) {
        return repository.findByNumeroDeReservation(numero);
    }

    // add reservation
    public Reservation add(Reservation reservation) {
        // get locataire for this reservation
        Locataire locataire =
                locataireRepository.findByEmailLocataire(reservation.getLocataire().getEmailLocataire());
        reservation.setLocataire(locataire);

        // get hebergement for this reservation
        Hebergement hebergement =
                hebergementRepository.findById(reservation.getHebergement().getId()).get();
        reservation.setHebergement(hebergement);

        // generer facture
        Facture facture = FactureFactory.getInstance(reservation);
        // insert this facture into table of the DB
        facture = factureRepository.save(facture);
        reservation.setFacture(facture);

        // get credit car for this reservation
        CarteCredit carteCredit =
                carteCreditRepository.findByNumero(reservation.getCarteCredit().getNumero());
        // generate new credit car for this reservation if it doesn't exist
        if (carteCredit == null) {
            carteCredit = CarteCreditFactory.getInstance(reservation);
            carteCredit = carteCreditRepository.save(carteCredit);
        }
        reservation.setCarteCredit(carteCredit);

        // add a disponibiliteDeLogement into the table of the DB
        indisponibiliteService.add(IndisponibiliteDeLogementFactory.getInstance(reservation));

        // add reservation
        return repository.save(reservation);
    }

    // update reservation
    public Reservation update(Reservation reservation) {
        // get reservation if it exists
        Reservation reservationExisted =
                repository.findByNumeroDeReservation(reservation.getNumeroDeReservation());
        System.out.println("reservationExisted: =======> " + reservationExisted.toString());

        if (reservationExisted != null) {
            // before update old reservation(reservationExisted), delete sa indisponibilite
            // get exited indisponibilite and delete it, because it is prossible to change hebergement
            //// get old herbergementId
            int oldHebergementId = reservationExisted.getHebergement().getId();
            //// get old indisponibiliteId of this old herbergement
            int indisponibiliteId = 0;
            List<IndisponibiliteDeLogementDTO> listDTO = indisponibiliteRepository.findByLogementId(oldHebergementId);
            System.out.println("lsitDTO: ====> " + listDTO);
            for (IndisponibiliteDeLogementDTO dto : listDTO) {
                System.out.println(reservationExisted.getDateDeArrive());
                System.out.println(dto.getDebutDeDateDeIndisponibilite());
                if (dto.getDebutDeDateDeIndisponibilite().isEqual(reservationExisted.getDateDeArrive())) {
                    indisponibiliteId = dto.getId();
                    break;
                }
            }
            //// delete the old indisponibilite if it exists
            if(indisponibiliteId != 0){
                System.out.println("old indisponibiliteId: ===> " + indisponibiliteId);
                indisponibiliteService.deleteById(indisponibiliteId);
            }

            // before update old reservation(reservationExisted), delete sa indisponibilite
            int oldFactureId = reservationExisted.getFacture().getNumeroDeFacture();
            System.out.println("oldFactureId ===> :" + oldFactureId);


            // update reservation
            reservationExisted = reservation;

            // get new locataire for this reservation
            Locataire locataire =
                    locataireRepository.findByEmailLocataire(reservation.getLocataire().getEmailLocataire());
            // update locataire of this reservation
            reservationExisted.setLocataire(locataire);

            // get new hebergement for this reservation
            Hebergement hebergement =
                    hebergementRepository.findById(reservation.getHebergement().getId()).get();
            // update hebergement of this reservation
            reservationExisted.setHebergement(hebergement);

            // generate new facture for this reservation
            Facture newFacture = FactureFactory.getInstance(reservation);
            newFacture.setNumeroDeFacture(oldFactureId);
            // update into the table of DB
            factureRepository.save(newFacture);
            reservationExisted.setFacture(newFacture);

            // get new credit car for this reservation
            CarteCredit carteCredit =
                    carteCreditRepository.findByNumero(reservation.getCarteCredit().getNumero());
            // generate new credit car for this reservation if it doesn't exist
            if (carteCredit == null) {
                carteCredit = CarteCreditFactory.getInstance(reservation);
            }
            // update credit car for this reservation
            reservationExisted.setCarteCredit(carteCredit);

            // get new indisponibiliteDeLogement and update it
            IndisponibiliteDeLogement newIndisponibilite = IndisponibiliteDeLogementFactory.getInstance(reservation);
            indisponibiliteService.add(newIndisponibilite);

            // update this reservation with the new information
            return repository.save(reservationExisted);
        } else {
            return null;
        }
    }

    // delete reservation
    public void delete(Integer numero) {
        Reservation reservation = repository.findByNumeroDeReservation(numero);

        // delete indisponibilite for this reservation
        int hebergementId = reservation.getHebergement().getId();
        //// get indisponibiliteId of this herbergement
        int indisponibiliteId = 0;
        List<IndisponibiliteDeLogementDTO> listDTO = indisponibiliteRepository.findByLogementId(hebergementId);
        System.out.println("lsitDTO: ====> " + listDTO);
        for (IndisponibiliteDeLogementDTO dto : listDTO) {
            System.out.println(reservation.getDateDeArrive());
            System.out.println(dto.getDebutDeDateDeIndisponibilite());
            if (dto.getDebutDeDateDeIndisponibilite().isEqual(reservation.getDateDeArrive())) {
                indisponibiliteId = dto.getId();
                break;
            }
        }
        //// delete the old indisponibilite if it exists
        if(indisponibiliteId != 0){
            System.out.println("old indisponibiliteId: ===> " + indisponibiliteId);
            indisponibiliteService.deleteById(indisponibiliteId);
        }

        repository.delete(reservation);
    }

    public List<Reservation> getListByLocataire(String email) {
        return repository.getListByEmail(email);
    }
}
