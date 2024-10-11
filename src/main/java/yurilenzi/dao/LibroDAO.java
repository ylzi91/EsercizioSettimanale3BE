package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import yurilenzi.entities.Libro;
import yurilenzi.entities.Utente;

import java.util.List;
import java.util.UUID;

public class LibroDAO {
    private final EntityManager entityManager;

    public LibroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Libro nuovoLibro){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(nuovoLibro);
        transaction.commit();
        System.out.println("Il libro '" + nuovoLibro.getTitolo() + "' è stato salvato correttamente");
    }

    public List<Libro> findForAuthor(String autore){
        TypedQuery<Libro>  query = entityManager.createQuery("select l from Libro l where l.autore like :autore", Libro.class);
        query.setParameter("autore", "%" + autore + "%");
        return query.getResultList();
    }

    public Libro findById(UUID idLibro){
        Libro found = entityManager.find(Libro.class, idLibro);

        return found;
    }

    public void deleteById(UUID idLibro){
        Libro found = this.findById(idLibro);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Il libro '" + found.getTitolo() + "' è stato cancellato");
    }
}
