package com.example.GestionePrenotazioni.loader;

import com.example.GestionePrenotazioni.model.Edificio;
import com.example.GestionePrenotazioni.model.Postazione;
import com.example.GestionePrenotazioni.model.Utente;
import com.example.GestionePrenotazioni.model.Prenotazione;
import com.example.GestionePrenotazioni.repository.EdificioRepository;
import com.example.GestionePrenotazioni.repository.PostazioneRepository;
import com.example.GestionePrenotazioni.repository.UtenteRepository;
import com.example.GestionePrenotazioni.repository.PrenotazioneRepository;
import com.example.GestionePrenotazioni.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        Edificio edificioA = edificioRepository.findByNome("Skylab")
                .orElseGet(() -> edificioRepository.save(new Edificio("Skylab", "Via Washington, 35", "Pizzo Calabro")));
        Edificio edificioB = edificioRepository.findByNome("ALchiccoDOro")
                .orElseGet(() -> edificioRepository.save(new Edificio("ALchiccoDOro", "Via Roma 1", "Roma")));
        Edificio edificioC = edificioRepository.findByNome("Monte Fato")
                .orElseGet(() -> edificioRepository.save(new Edificio("Monte Fato", "Mordor", "Terra di Mezzo")));
        Edificio edificioD = edificioRepository.findByNome("TARDIS")
                .orElseGet(() -> edificioRepository.save(new Edificio("TARDIS", "Spazio e Tempo", "Universo")));
        Edificio edificioE = edificioRepository.findByNome("Avenger's Tower")
                .orElseGet(() -> edificioRepository.save(new Edificio("Avenger's Tower", "Avenue of Heroes 42", "New York")));
        Edificio edificioF = edificioRepository.findByNome("Belfast Pub")
                .orElseGet(() -> edificioRepository.save(new Edificio("Statua della Libertà", "Liberty Island", "New York")));
        Edificio edificioG = edificioRepository.findByNome("Bag End")
                .orElseGet(() -> edificioRepository.save(new Edificio("La Contea", "Via dei Baggins", "Terra di Mezzo")));
        Edificio edificioH = edificioRepository.findByNome("TARDIS - Secondo Piano")
                .orElseGet(() -> edificioRepository.save(new Edificio("Sherlock Holmes, un episodio crossover?", "221B Baker Street", "Londra")));

        Postazione postazione1 = postazioneRepository.findByCodice("P001")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P001", "Postazione 1", Postazione.Tipo.PRIVATO, 1, edificioA)));
        Postazione postazione2 = postazioneRepository.findByCodice("P002")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P002", "Postazione 2", Postazione.Tipo.OPENSPACE, 4, edificioA)));
        Postazione postazione3 = postazioneRepository.findByCodice("P003")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P003", "Postazione 3", Postazione.Tipo.SALA_RIUNIONI, 10, edificioA)));
        Postazione postazione4 = postazioneRepository.findByCodice("P004")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P004", "Postazione 4", Postazione.Tipo.OPENSPACE, 4, edificioB)));
        Postazione postazione5 = postazioneRepository.findByCodice("P005")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P005", "Postazione 5", Postazione.Tipo.PRIVATO, 1, edificioB)));
        Postazione postazione6 = postazioneRepository.findByCodice("P006")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P006", "Postazione 6", Postazione.Tipo.OPENSPACE, 4, edificioC)));
        Postazione postazione7 = postazioneRepository.findByCodice("P007")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P007", "Postazione 7", Postazione.Tipo.PRIVATO, 1, edificioD)));
        Postazione postazione8 = postazioneRepository.findByCodice("P008")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P008", "Postazione 8", Postazione.Tipo.SALA_RIUNIONI, 10, edificioE)));
        Postazione postazione9 = postazioneRepository.findByCodice("P009")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P009", "Postazione 9", Postazione.Tipo.OPENSPACE, 4, edificioF)));
        Postazione postazione10 = postazioneRepository.findByCodice("P010")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P010", "Postazione 10", Postazione.Tipo.PRIVATO, 1, edificioG)));
        Postazione postazione11 = postazioneRepository.findByCodice("P011")
                .orElseGet(() -> postazioneRepository.save(new Postazione("P011", "Postazione 11", Postazione.Tipo.SALA_RIUNIONI, 10, edificioH)));

        Utente utente1 = utenteRepository.findByEmail("GiacominoPoretti@gmail.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Sugar Poretti", "Giacomino Poretti", "GiacominoPoretti@gmail.com")));
        Utente utente2 = utenteRepository.findByEmail("GiovanniStorti@gmail.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Pdor", "Giovanni Storti", "GiovanniStorti@gmail.com")));
        Utente utente3 = utenteRepository.findByEmail("AldoBaglio@gmail.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Dexter", "Aldo Baglio", "AldoBaglio@gmail.com")));
        Utente utente4 = utenteRepository.findByEmail("eleventhdoctor@tardis.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Il Dottore", "Eleventh Doctor", "eleventhdoctor@tardis.com")));
        Utente utente5 = utenteRepository.findByEmail("frodo@shire.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Frodo", "Frodo Baggins", "frodo@shire.com")));
        Utente utente6 = utenteRepository.findByEmail("peterparker@dailybugle.com")
                .orElseGet(() -> utenteRepository.save(new Utente("Spider-Man", "Peter Parker", "peterparker@dailybugle.com")));

        LocalDate dataPrenotazione1 = LocalDate.of(2024, 10, 30);
        if (prenotazioneService.canBook(postazione1.getId(), utente1.getId(), dataPrenotazione1)) {
            Prenotazione prenotazione1 = new Prenotazione(dataPrenotazione1, utente1, postazione1);
            prenotazioneService.savePrenotazione(prenotazione1);
        }

        LocalDate dataPrenotazione2 = LocalDate.of(2024, 10, 30);
        if (prenotazioneService.canBook(postazione2.getId(), utente2.getId(), dataPrenotazione2)) {
            Prenotazione prenotazione2 = new Prenotazione(dataPrenotazione2, utente2, postazione2);
            prenotazioneService.savePrenotazione(prenotazione2);
        }

        LocalDate dataPrenotazione3 = LocalDate.of(2024, 10, 31);
        if (prenotazioneService.canBook(postazione3.getId(), utente1.getId(), dataPrenotazione3)) {
            Prenotazione prenotazione3 = new Prenotazione(dataPrenotazione3, utente1, postazione3);
            prenotazioneService.savePrenotazione(prenotazione3);
        }

        LocalDate dataPrenotazione4 = LocalDate.of(2024, 10, 31);
        if (prenotazioneService.canBook(postazione4.getId(), utente3.getId(), dataPrenotazione4)) {
            Prenotazione prenotazione4 = new Prenotazione(dataPrenotazione4, utente3, postazione4);
            prenotazioneService.savePrenotazione(prenotazione4);
        }

        LocalDate dataPrenotazione5 = LocalDate.of(2024, 11, 1);
        if (prenotazioneService.canBook(postazione6.getId(), utente4.getId(), dataPrenotazione5)) {
            Prenotazione prenotazione5 = new Prenotazione(dataPrenotazione5, utente4, postazione6);
            prenotazioneService.savePrenotazione(prenotazione5);
        }

        LocalDate dataPrenotazione6 = LocalDate.of(2024, 11, 2);
        if (prenotazioneService.canBook(postazione7.getId(), utente5.getId(), dataPrenotazione6)) {
            Prenotazione prenotazione6 = new Prenotazione(dataPrenotazione6, utente5, postazione7);
            prenotazioneService.savePrenotazione(prenotazione6);
        }

        LocalDate dataPrenotazione7 = LocalDate.of(2024, 11, 3);
        if (prenotazioneService.canBook(postazione8.getId(), utente6.getId(), dataPrenotazione7)) {
            Prenotazione prenotazione7 = new Prenotazione(dataPrenotazione7, utente6, postazione8);
            prenotazioneService.savePrenotazione(prenotazione7);
        }

        LocalDate dataPrenotazione8 = LocalDate.of(2024, 11, 4);
        if (prenotazioneService.canBook(postazione9.getId(), utente1.getId(), dataPrenotazione8)) {
            Prenotazione prenotazione8 = new Prenotazione(dataPrenotazione8, utente1, postazione9);
            prenotazioneService.savePrenotazione(prenotazione8);
        }

        LocalDate dataPrenotazione9 = LocalDate.of(2024, 11, 4);
        if (prenotazioneService.canBook(postazione10.getId(), utente2.getId(), dataPrenotazione9)) {
            Prenotazione prenotazione9 = new Prenotazione(dataPrenotazione9, utente2, postazione10);
            prenotazioneService.savePrenotazione(prenotazione9);
        }

        LocalDate dataPrenotazione10 = LocalDate.of(2024, 11, 5);
        if (prenotazioneService.canBook(postazione11.getId(), utente3.getId(), dataPrenotazione10)) {
            Prenotazione prenotazione10 = new Prenotazione(dataPrenotazione10, utente3, postazione11);
            prenotazioneService.savePrenotazione(prenotazione10);
        }
    }
}
