package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import yurilenzi.entities.Articolo;
import yurilenzi.entities.Libro;

import java.util.List;
import java.util.UUID;

public class ArticoloDAO {
    private final EntityManager entityManager;

    public ArticoloDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Articolo> getIdArticoli(){
        TypedQuery<Articolo> query = entityManager.createQuery("select a from Articolo a", Articolo.class);
        return query.getResultList();
    }

    public List<Articolo> getArticoloFromData(int anno){
        TypedQuery<Articolo> query = entityManager.createQuery("select a from Articolo a where a.annoPubblicazione = :anno", Articolo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Articolo> findByTitolo(String titolo){
        TypedQuery<Articolo> query = entityManager.createQuery("select a from Articolo a where a.Titolo like :titolo", Articolo.class);
        query.setParameter("titolo",  "%" + titolo + "%");
        return query.getResultList();
    }

    public Articolo findById(UUID idAricolo){
        Articolo found = entityManager.find(Articolo.class, idAricolo);
        return found;
    }

    public void deleteById(UUID idArticolo){
        Articolo found = this.findById(idArticolo);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'aritocolo '" + found.getTitolo() + "' è stato cancellato");
    }


}
