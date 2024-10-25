package com.example.GestionePrenotazioni.controller;

import com.example.GestionePrenotazioni.model.Prenotazione;
import com.example.GestionePrenotazioni.service.PrenotazioneService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/postazione/{postazioneId}/data/{data}")
    public List<Prenotazione> getPrenotazioniPerPostazione(@PathVariable Long postazioneId, @PathVariable LocalDate data) {
        return prenotazioneService.getPrenotazioniPerPostazione(postazioneId, data);
    }
}
