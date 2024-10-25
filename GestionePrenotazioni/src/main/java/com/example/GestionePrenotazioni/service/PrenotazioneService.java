package com.example.GestionePrenotazioni.service;

import com.example.GestionePrenotazioni.model.Prenotazione;
import com.example.GestionePrenotazioni.model.Utente;
import com.example.GestionePrenotazioni.repository.PrenotazioneRepository;
import com.example.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteRepository utenteRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UtenteRepository utenteRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteRepository = utenteRepository;
    }

    public List<Prenotazione> getPrenotazioniPerPostazione(Long postazioneId, LocalDate data) {
        return prenotazioneRepository.findByPostazioneAndData(postazioneId, data);
    }

    public void savePrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public boolean canBook(Long postazioneId, Long utenteId, LocalDate data) {
        List<Prenotazione> prenotazioniPerPostazione = prenotazioneRepository.findByPostazioneAndData(postazioneId, data);
        if (!prenotazioniPerPostazione.isEmpty()) {
            return false;
        }
        List<Prenotazione> prenotazioniPerUtente = prenotazioneRepository.findByUtenteAndData(utenteId, data);
        if (!prenotazioniPerUtente.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean verificaUtente(Long utenteId) {
        return utenteRepository.findById(utenteId).isPresent();
    }

    public Optional<Utente> trovaUtentePerEmail(String email) {
        return utenteRepository.findByEmail(email);
    }
}
