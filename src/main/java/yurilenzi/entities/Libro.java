package yurilenzi.entities;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Libro extends Articolo{
    private String autore;
    private String genere;

    public Libro(){

    }
    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{\n" +
                "autore='\n" + autore + '\'' +
                ", genere='\n" + genere + '\'' +
                ", id_articolo=\n" + idArticolo +
                ", Titolo='\n" + Titolo + '\'' +
                ", annoPubblicazione=\n" + annoPubblicazione +
                ", numeroPagine=\n" + numeroPagine +
                "} ";
    }
}
