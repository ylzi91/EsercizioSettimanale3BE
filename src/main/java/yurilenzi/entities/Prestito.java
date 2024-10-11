package yurilenzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "id_prestito")
    private long idPrestito;
    @OneToOne
    @JoinColumn(name = "elemento_prestato")
    private Articolo articolo;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista")
    private LocalDate data_restituzione_prevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate getData_restituzione_effettiva;
    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;


    public Prestito(){

    }
    public Prestito(Articolo articolo, LocalDate dataInizioPrestito, Utente utente) {
        Random plusDays = new Random();
        this.articolo = articolo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.data_restituzione_prevista = this.dataInizioPrestito.plusDays(30);
        this.getData_restituzione_effettiva = dataInizioPrestito.plusDays(plusDays.nextInt(10,50));
        this.utente = utente;
    }

    public long getIdPrestito() {
        return idPrestito;
    }


    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getGetData_restituzione_effettiva() {
        return getData_restituzione_effettiva;
    }

    public void setGetData_restituzione_effettiva(LocalDate getData_restituzione_effettiva) {
        this.getData_restituzione_effettiva = getData_restituzione_effettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestito{\n" +
                "idPrestito=\n" + idPrestito +
                ", articolo=\n" + articolo +
                ", dataInizioPrestito=\n" + dataInizioPrestito +
                ", data_restituzione_prevista=\n" + data_restituzione_prevista +
                ", getData_restituzione_effettiva=\n" + getData_restituzione_effettiva +
                ", utente=\n" + utente +
                '}';
    }
}
