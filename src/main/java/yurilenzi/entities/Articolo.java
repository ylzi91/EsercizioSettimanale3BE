package yurilenzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table (name = "articoli")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Articolo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_articolo")
    protected UUID idArticolo;
    protected String Titolo;
    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;
    @Column (name = "numero_pagine")
    protected int numeroPagine;


    public Articolo(){

    }
    public Articolo(String titolo, int annoPubblicazione, int numeroPagine) {
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID getId_articolo() {
        return idArticolo;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "id_articolo=" + idArticolo +
                ", Titolo='" + Titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
