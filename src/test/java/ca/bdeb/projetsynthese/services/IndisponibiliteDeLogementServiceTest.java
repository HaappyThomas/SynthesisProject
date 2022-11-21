package ca.bdeb.projetsynthese.services;

import ca.bdeb.projetsynthese.dao.*;
import ca.bdeb.projetsynthese.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IndisponibiliteDeLogementServiceTest {

    @Autowired
    private IndisponibiliteDeLogementService service;
    @Autowired
    private IHebergementRepository iHebergementRepository;
    @Autowired
    private IAdresseRepository adresseRepository;
    @Autowired
    private IProprietaireRepository proprietaireRepository;
    @Autowired
    private ITypeDeHebergementRepository typeDeHebergementRepository;
    @Autowired
    private ISecteurDeHebergementRepository secteurDeHebergementRepository;
    @Autowired
    private IIndisponibiliteDeLogementRepository repository;

    private IndisponibiliteDeLogement indisponibiliteDeLogement;

    @BeforeEach
    void setUp() {
//        Adresse adresse = new Adresse("new 123", "new rue", "new ville",
//                "new province", "new country", "new postal");
//        Proprietaire proprietaire = new Proprietaire("newemail@gmail.com",
//                "new password", "new name", "new last name",
//                "new telephone", true, adresse, null);
//        TypeDeHebergement typeDeHebergement = new TypeDeHebergement("new type");
//        SecteurDeHebergement secteurDeHebergement = new SecteurDeHebergement("new sect");
//        Hebergement herbergement = new Hebergement(300,110,150,"/newphoto",true,adresse,
//                proprietaire,typeDeHebergement,secteurDeHebergement,null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("success test for add")
    void addSansConflit() {
        Hebergement herbergement = iHebergementRepository.findById(1).get();
        indisponibiliteDeLogement = new IndisponibiliteDeLogement(
                LocalDate.of(2022, 12, 24),
                LocalDate.of(2022, 12, 25), herbergement);

        System.out.println("avant insert ======> " + indisponibiliteDeLogement.toString());
        indisponibiliteDeLogement = service.add(indisponibiliteDeLogement);
//        System.out.println("apres insert ======> " + indisponibiliteDeLogement.toString());

        assertEquals(indisponibiliteDeLogement.getId(), repository.findMaxId());
    }

    @Test
    @DisplayName(" fail test for add: start date conflict test")
    void addAvecConflitDateDebut() {
        Hebergement herbergement = iHebergementRepository.findById(1).get();
        indisponibiliteDeLogement = new IndisponibiliteDeLogement(
                LocalDate.of(2022, 12, 28),
                LocalDate.of(2022, 12, 31), herbergement);

        System.out.println("avant insert ======> " + indisponibiliteDeLogement.toString());
        indisponibiliteDeLogement = service.add(indisponibiliteDeLogement);
//        System.out.println("apres insert ======> " + indisponibiliteDeLogement.toString());
        assertEquals(null, indisponibiliteDeLogement);

    }

    @Test
    @DisplayName(" fail test for add: finish date conflict test")
    void addAvecConflitDateFin() {
        Hebergement herbergement = iHebergementRepository.findById(1).get();
        indisponibiliteDeLogement = new IndisponibiliteDeLogement(
                LocalDate.of(2022, 12, 18),
                LocalDate.of(2022, 12, 22), herbergement);

        System.out.println("avant insert ======> " + indisponibiliteDeLogement.toString());
        indisponibiliteDeLogement = service.add(indisponibiliteDeLogement);
//        System.out.println("apres insert ======> " + indisponibiliteDeLogement.toString());
        assertEquals(null, indisponibiliteDeLogement);

    }

    @Test
    @DisplayName("success test for update")
    void updateSansConfit() {
        // modify indisponibiliteDeLogementId = 1
        int indispoId= 1;
        IndisponibiliteDeLogement indisponibilite = repository.findById(indispoId).get();
        // old date: 2022-12-20  2022-12-23
        // new date: attention, finDate 2022-12-22 is between old date
        LocalDate debutDate = LocalDate.of(2022, 12, 18);
        LocalDate finDate= LocalDate.of(2022, 12, 22);
        // update new date for indisponibiliteId = 1
        indisponibilite.setDebutDeDateDeIndisponibilite(debutDate);
        indisponibilite.setFinDeDateDeIndisponibilite(finDate);

        System.out.println("avant update ======> " + repository.findById(indispoId).get().toString());
        indisponibiliteDeLogement = service.update(indisponibilite);
        System.out.println("apres update ======> " + repository.findById(indispoId).get().toString());

        assertEquals(debutDate, repository.findById(indispoId).get().getDebutDeDateDeIndisponibilite());
        assertEquals(finDate, repository.findById(indispoId).get().getFinDeDateDeIndisponibilite());
    }

    @Test
    @DisplayName("success test for update")
    void updateAvecConfitDebutDate() {
        // modify indisponibiliteDeLogementId = 1
        int indispoId= 1;
        IndisponibiliteDeLogement indisponibilite = repository.findById(indispoId).get();
        // new date
        LocalDate debutDate = LocalDate.of(2022, 12, 28);
        LocalDate finDate= LocalDate.of(2022, 12, 31);
        // update new date for indisponibiliteId = 1
        indisponibilite.setDebutDeDateDeIndisponibilite(debutDate);
        indisponibilite.setFinDeDateDeIndisponibilite(finDate);

        System.out.println("avant update ======> " + repository.findById(indispoId).get().toString());
        indisponibiliteDeLogement = service.update(indisponibilite);
        System.out.println("apres update ======> " + repository.findById(indispoId).get().toString());

        assertEquals(null,indisponibiliteDeLogement );
    }

    @Test
    @DisplayName("success test for update")
    void updateAvecConfitFinDate() {
        // modify indisponibiliteDeLogementId = 1
        int indispoId= 1;
        IndisponibiliteDeLogement indisponibilite = repository.findById(indispoId).get();
        // new date
        LocalDate debutDate = LocalDate.of(2022, 12, 25);
        LocalDate finDate= LocalDate.of(2022, 12, 28);
        // update new date for indisponibiliteId = 1
        indisponibilite.setDebutDeDateDeIndisponibilite(debutDate);
        indisponibilite.setFinDeDateDeIndisponibilite(finDate);

        System.out.println("avant update ======> " + repository.findById(indispoId).get().toString());
        indisponibiliteDeLogement = service.update(indisponibilite);
        System.out.println("apres update ======> " + repository.findById(indispoId).get().toString());

        assertEquals(null,indisponibiliteDeLogement );
    }

    @Test
    void deleteById() {
    }
}