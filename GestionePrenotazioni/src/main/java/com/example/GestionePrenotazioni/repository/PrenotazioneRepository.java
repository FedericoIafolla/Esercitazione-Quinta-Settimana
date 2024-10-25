package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
        @Query("SELECT p FROM Prenotazione p WHERE p.postazione.id = :postazioneId AND p.data = :data")
        List<Prenotazione> findByPostazioneAndData(@Param("postazioneId") Long postazioneId, @Param("data") LocalDate data);

        @Query("SELECT p FROM Prenotazione p WHERE p.utente.id = :utenteId AND p.data = :data")
        List<Prenotazione> findByUtenteAndData(@Param("utenteId") Long utenteId, @Param("data") LocalDate data);
}
