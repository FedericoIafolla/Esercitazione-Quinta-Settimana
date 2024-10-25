package com.example.GestionePrenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "utenti")
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nomeCompleto;
    private String email;

    public Utente() {
    }

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
}
