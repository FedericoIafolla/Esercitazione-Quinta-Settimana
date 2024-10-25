package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.model.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Città(String tipo, String città);
}