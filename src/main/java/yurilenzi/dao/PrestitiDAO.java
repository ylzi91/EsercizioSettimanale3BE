package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import yurilenzi.entities.Prestito;

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


}
