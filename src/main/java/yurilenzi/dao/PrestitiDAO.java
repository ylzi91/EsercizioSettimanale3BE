package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import yurilenzi.entities.Articolo;
import yurilenzi.entities.Prestito;

import java.util.List;

public class PrestitiDAO {
    private final EntityManager entityManager;

    public PrestitiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito nuovoPrestito){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(nuovoPrestito);
        transaction.commit();
        System.out.println("L'articolo '" + nuovoPrestito.getArticolo().getTitolo() + "' è stato prestato a" + nuovoPrestito.getUtente().getNome());
    }


    public List<Articolo> cercaArticoloDaPrestito(long idUtente){
        TypedQuery<Articolo> query = entityManager.createQuery("select p.articolo from Prestito p where p.utente.idUtente = :idUtente", Articolo.class);
        query.setParameter("idUtente", idUtente);
        return query.getResultList();
    }

    public List<Prestito> prestitiScaduti(){
        System.out.println("--------------------------------------------------------Prestiti Scaduti--------------------------------------------------");
        TypedQuery<Prestito> query = entityManager.createQuery("select p from Prestito p where p.data_restituzione_prevista < p.getData_restituzione_effettiva", Prestito.class);
        return query.getResultList();
    }
}
