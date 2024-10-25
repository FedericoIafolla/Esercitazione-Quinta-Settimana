package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.model.Postazione;
import com.example.GestionePrenotazioni.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Città(String tipo, String città);
    Optional<Postazione> findByCodice(String codice);
    List<Postazione> findByEdificio(Edificio edificio);
}
