package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    Optional<Edificio> findByNome(String nome);
}
