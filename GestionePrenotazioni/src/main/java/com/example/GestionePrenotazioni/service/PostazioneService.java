package com.example.GestionePrenotazioni.service;

import com.example.GestionePrenotazioni.model.Postazione;
import com.example.GestionePrenotazioni.repository.PostazioneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public List<Postazione> cercaPostazioni(String tipo, String città) {
        return postazioneRepository.findByTipoAndEdificio_Città(tipo, città);
    }
}
