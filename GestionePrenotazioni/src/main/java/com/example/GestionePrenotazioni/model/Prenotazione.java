package com.example.GestionePrenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    private LocalDate data;
}
