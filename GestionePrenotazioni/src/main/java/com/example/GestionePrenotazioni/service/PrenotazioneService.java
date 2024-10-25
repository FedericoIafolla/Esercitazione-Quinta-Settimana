package com.example.GestionePrenotazioni.service;

import com.example.GestionePrenotazioni.model.Prenotazione;
import com.example.GestionePrenotazioni.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public List<Prenotazione> getPrenotazioniPerPostazione(Long postazioneId, LocalDate data) {
        return prenotazioneRepository.findByPostazione_IdAndData(postazioneId, data);
    }
}