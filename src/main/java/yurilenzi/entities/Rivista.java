package yurilenzi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Rivista extends Articolo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(){

    }
    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", id_articolo=" + idArticolo+
                ", Titolo='" + Titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                "} ";
    }
}
