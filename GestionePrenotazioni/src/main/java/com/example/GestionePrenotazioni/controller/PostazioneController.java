package com.example.GestionePrenotazioni.controller;

import com.example.GestionePrenotazioni.model.Postazione;
import com.example.GestionePrenotazioni.service.PostazioneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
    private final PostazioneService postazioneService;

    public PostazioneController(PostazioneService postazioneService) {
        this.postazioneService = postazioneService;
    }

    @GetMapping
    public List<Postazione> cercaPostazioni(@RequestParam String tipo, @RequestParam String città) {
        return postazioneService.cercaPostazioni(tipo, città);
    }
}
