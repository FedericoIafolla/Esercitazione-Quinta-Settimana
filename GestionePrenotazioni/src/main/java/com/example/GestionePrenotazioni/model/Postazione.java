package com.example.GestionePrenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "postazioni")
@Data
public class Postazione {
    public enum Tipo {
        PRIVATO, OPENSPACE, SALA_RIUNIONI
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione() {
    }

    public Postazione(String codice, String descrizione, Tipo tipo, int maxOccupanti, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }
}
