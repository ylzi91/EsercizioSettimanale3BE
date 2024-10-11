package yurilenzi;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import yurilenzi.dao.*;
import yurilenzi.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsercizioSettimanale3");
    public static EntityManager em = emf.createEntityManager();
    public static UtenteDAO utenteDAO = new UtenteDAO(em);
    public static LibroDAO libroDAO = new LibroDAO(em);
    public static RivistaDAO rivistaDAO = new RivistaDAO(em);
    public static ArticoloDAO articoloDAO = new ArticoloDAO(em);
    public static PrestitiDAO prestitiDAO = new PrestitiDAO(em);

    public static void main(String[] args) {



        List<Articolo> articoliFromdb = articoloDAO.getIdArticoli();
        articoloDAO.getArticoloFromData(1974).forEach(System.out::println);
        libroDAO.findForAuthor("Penelope").forEach(System.out::println);
        articoloDAO.findByTitolo("The Last").forEach(System.out::println);

        System.out.println(prestitiDAO.cercaArticoloDaPrestito(57));
        prestitiDAO.prestitiScaduti().forEach(System.out::println);



    }

    public static void salvaLRU() {
        List<Utente> utenti = new ArrayList<>();
        List<Libro> libri = new ArrayList<>();
        List<Rivista> riviste = new ArrayList<>();
        Faker faker = new Faker(Locale.ITALY);
        for (int i = 0; i < 10; i++) {
            int anno = new Random().nextInt(1920, 2015);
            int mese = new Random().nextInt(1, 12);
            int giorno;
            if (mese == 2) giorno = new Random().nextInt(1, 28);
            else giorno = new Random().nextInt(1, 30);
            int annoArticolo = new Random().nextInt(1800, 2024);

            utenti.add(new Utente(faker.name().name(), faker.name().lastName(), LocalDate.of(anno, mese, giorno)));
            libri.add(new Libro(faker.book().title(), annoArticolo, faker.number().numberBetween(50, 500), faker.book().author(), faker.book().genre()));
            riviste.add(new Rivista(faker.book().title(), annoArticolo, faker.number().numberBetween(50, 500), Periodicita.ANNUALE));

            utenteDAO.save(utenti.get(i));
            libroDAO.save(libri.get(i));
            rivistaDAO.save(riviste.get(i));
        }
    }
    public static void salvaPrestiti(){
        List<Prestito> prestiti = new ArrayList<>();
        List<Articolo> articoliFromdb = articoloDAO.getIdArticoli();
        AtomicInteger i = new AtomicInteger();
        articoliFromdb.forEach(articolo -> {
            Random randomUser = new Random();
            int mese = new Random().nextInt(1, 12);
            int giorno;
            if (mese == 2) giorno = new Random().nextInt(1, 28);
            else giorno = new Random().nextInt(1, 30);
           prestiti.add(new Prestito(articolo, LocalDate.of(2024, mese, giorno), utenteDAO.findById(randomUser.nextLong(52,61))));
           prestitiDAO.save(prestiti.get(i.get()));
           i.getAndIncrement();
        });
    }
}
