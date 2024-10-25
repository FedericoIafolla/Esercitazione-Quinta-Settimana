package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
        List<Prenotazione> findByPostazione_IdAndData(Long postazioneId, LocalDate data);
}
